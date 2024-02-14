package it.unibo.objectmon.model.encounters.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Random;
import java.util.Optional;

import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.encounters.api.RandomEncounterManager;
import it.unibo.objectmon.model.entities.player.PlayerImpl;
import it.unibo.objectmon.model.gamestate.Observer;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * The RandomEncounterManager class manages random encounters in the game world.
 * It observes changes in the game context and triggers encounters based on certain condition.
 */
public final class RandomEncounterManagerImpl implements Observer, RandomEncounterManager {

    private final GameContext gameContext;
    private final BattleManager battleManager;
    private static final double ENCOUNTER_RATE = 0.2;
    private static final int DEFAULT_LEVEL = 5;
    private final Random random = new Random();

    /**
     * Constructs a RandomEncounterManager.
     * @param gameContext the game context
     * @param battleManager the manager used to start the battle
     */
    @SuppressFBWarnings (value = "EI_EXPOSE_REP", justification = "Temporary")
    public RandomEncounterManagerImpl(final GameContext gameContext, final BattleManager battleManager) {
        this.gameContext = gameContext;
        PlayerImpl playerImpl = (PlayerImpl) gameContext.getPlayer();
        playerImpl.addObserver(this);
        this.battleManager = battleManager;
    }

    @Override
    public void performCheck() {
        final Coord position = gameContext.getPlayer().getPosition();
        if (gameContext.getWorld().getMap().get(position).isTriggerEncounter() && encountersOccurs()) {
            startRandomEncounter();
        }
    }

    private boolean encountersOccurs() {
        double number = random.nextDouble();
        return number <= ENCOUNTER_RATE;
    }

    private void startRandomEncounter() {
        final Objectmon wildObjectmon = ObjectmonFactory.createObjectmon(selectRandomObjectmon(), DEFAULT_LEVEL);
        battleManager.startBattle(gameContext.getPlayer(), Optional.empty(), Optional.of(wildObjectmon));
    }

    private ObjectmonEnum selectRandomObjectmon() {
        final ObjectmonEnum[] avaiableObjectmon = ObjectmonEnum.values();
        final int randomIndex = random.nextInt(avaiableObjectmon.length - 1);
        return avaiableObjectmon[randomIndex];
    }

    @Override
    public void update() {
        performCheck();
    }
}
