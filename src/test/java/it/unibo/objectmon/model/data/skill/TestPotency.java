package it.unibo.objectmon.model.data.skill;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Potency;
import it.unibo.objectmon.model.data.api.skill.PotencyChart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Test of Potency and Potency chart.
 */
class TestPotency {

    /**
     * Test of all potencies.
     */
    @Test
    void testPotencies() {
        Potency potency;
        for (final Potency singlePotency : Potency.values()) {
            potency = singlePotency;
            assertEquals(potency.getName(), singlePotency.getName());
            assertEquals(potency.getMultiplier(), singlePotency.getMultiplier());
        }
    }

    /**
     *  Test that potencies multiply correctly.
     */
    @Test
    void testPotencyChart() {
        final List<Aspect> defenderAspects = List.of(Aspect.ROCK, Aspect.GROUND);
        // user isn't sameAspect and POISON is NOTEFFECTIVE against ROCK and GROUND, so 1*0.5*2 = 0.25
        PotencyChart testPotency = PotencyChart.POISON;
        final double veryNotEffective = 0.25;
        assertEquals(veryNotEffective, testPotency.potencyMultiplier(List.of(Aspect.NORMAL), defenderAspects));

        // user isn't sameAspect and NORMAL is NOTEFFECTIVE against ROCK and EFFECTIVE against GROUND, so 1*0.5*1 = 0.5
        final double notEffective = 0.50;
        testPotency = PotencyChart.NORMAL;
        assertEquals(notEffective, testPotency.potencyMultiplier(List.of(Aspect.POISON), defenderAspects));

        // user isn't sameAspect and BUG is EFFECTIVE against ROCK and GROUND, so 1^3 = 1
        final double effective = 1.00;
        testPotency = PotencyChart.BUG;
        assertEquals(effective, testPotency.potencyMultiplier(List.of(Aspect.NORMAL), defenderAspects));

        // user isn't sameAspect and GROUND is SUPEREFFECTIVE against ROCK and EFFECTIVE against GROUND, so 1*2*1 = 2
        final double superEffective = 2.00;
        testPotency = PotencyChart.GROUND;
        assertEquals(superEffective, testPotency.potencyMultiplier(List.of(Aspect.NORMAL), defenderAspects));

        // user isn't sameAspect and GRASS is SUPEREFFECTIVE against ROCK and GROUND, so 1*2*2 = 4
        final double verySuperEffective = 4.00;
        testPotency = PotencyChart.GRASS;
        assertEquals(verySuperEffective, testPotency.potencyMultiplier(List.of(Aspect.NORMAL), defenderAspects));

        // user is sameAspect and GRASS is SUPEREFFECTIVE against ROCK and GROUND, so 1.5*2*2 = 6
        final double veryVerySuperEffective = 6.00;
        testPotency = PotencyChart.GRASS;
        assertEquals(veryVerySuperEffective, testPotency.potencyMultiplier(List.of(Aspect.GRASS), defenderAspects));
    }
}
