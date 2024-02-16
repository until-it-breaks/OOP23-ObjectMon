package it.unibo.objectmon.model.randomencountermanager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.encounters.impl.RandomEncounterManagerImpl;
import it.unibo.objectmon.model.entities.player.PlayerImpl;

/**
 * Tests for the {@link RandomEncounterManagerImpl}.
 */
class RandomEncounterManagerImplTest {

    private static final int DEFAULT_GRACE_DURATION = 5;
    private GameContext gameContext;
    private BattleInitiator battleInitiator;
    private int graceDuration;

    @BeforeEach
    void init() {
        // Create mock objects
        gameContext = mock(GameContext.class);
        final PlayerImpl player = mock(PlayerImpl.class);
        battleInitiator = mock(BattleInitiator.class);
        graceDuration = DEFAULT_GRACE_DURATION;
        // Configure mock objects with when()
        when(gameContext.getPlayer()).thenReturn(player);
    }

    // Checks if grace period works.
    @Test
    void testGracePeriod() {
        // Create RandomEncounterManagerImpl instance
        final RandomEncounterManagerImpl randomEncounterManager = new RandomEncounterManagerImpl(
            gameContext, battleInitiator, graceDuration);

        // Verify if grace period is not active initially
        assertFalse(randomEncounterManager.isGracePeriodActive());

        // Activate grace period
        randomEncounterManager.activateGracePeriod();
        assertTrue(randomEncounterManager.isGracePeriodActive());

        // Deactivate grace period
        for (int i = 0; i < graceDuration; i++) {
            randomEncounterManager.update();
        }
        assertFalse(randomEncounterManager.isGracePeriodActive());
    }

    // Testing if all the available Objectmons are selected at least once.
    @SuppressWarnings("PMD.DoNotUseReflectionForFieldAccess")
    @Test
    //NOPMD
    void testSelectRandomObjectmon() {
        final Set<ObjectmonEnum> selectedObjectmons = new HashSet<>();
        try {
            final RandomEncounterManagerImpl randomEncounterManager = new RandomEncounterManagerImpl(
                gameContext, battleInitiator, graceDuration);
            final Method selectRandomObjectmonMethod = RandomEncounterManagerImpl.class.getDeclaredMethod(
                "selectRandomObjectmon");
            selectRandomObjectmonMethod.setAccessible(true); //NOPMD reflection needed.
            for (int i = 0; i < 1000; i++) {
                final ObjectmonEnum selectedObjectmon = 
                    (ObjectmonEnum) selectRandomObjectmonMethod.invoke(randomEncounterManager);
                selectedObjectmons.add(selectedObjectmon);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, 
            "Failed to access the selectRandomObjectmon method via reflection", e);
        }

        // Check if all ObjectmonEnum values have been selected at least once
        for (final ObjectmonEnum objectmonEnum : ObjectmonEnum.values()) {
            assertTrue(selectedObjectmons.contains(objectmonEnum), "Expected ObjectmonEnum " 
            + objectmonEnum + " was not chosen");
        }
    }

    // Testing if out of all checks on suitable tiles the encounter rate is the expected one.
    @Test
    void testEncounterSuccessRate() {
        final RandomEncounterManagerImpl randomEncounterManager = new RandomEncounterManagerImpl(
            gameContext, battleInitiator, graceDuration);
        final int totalChecks = 1000;
        final double expectedSuccessRate = RandomEncounterManagerImpl.ENCOUNTER_RATE;
        final double tolerance = 0.05;

        try {
            final Method encountersOccursMethod = RandomEncounterManagerImpl.class.getDeclaredMethod("encountersOccurs");
            encountersOccursMethod.setAccessible(true); //NOPMD reflection needed.

            // Perform checks and count success
            int successfulChecks = 0;
            for (int i = 0; i < totalChecks; i++) {
                final boolean result = (boolean) encountersOccursMethod.invoke(randomEncounterManager);
                if (result) {
                    successfulChecks++;
                }
            }

            // Calculate success rate
            final double actualSuccessRate = (double) successfulChecks / totalChecks;

            // Verify that the actual success rate is equal to the expected success rate
            assertTrue(Math.abs(actualSuccessRate - expectedSuccessRate) < tolerance, 
                String.format("Expected success rate: %.2f, Actual success rate: %.2f", 
                    expectedSuccessRate, actualSuccessRate));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, 
            "Failed to access encounterOccurs method via reflection", e);
        }
    }
}
