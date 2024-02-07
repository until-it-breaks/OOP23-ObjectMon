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
        //  0.25
        PotencyChart testPotency = PotencyChart.POISON;
        final double veryNotEffective = 0.25;
        assertEquals(veryNotEffective, testPotency.potencyMultiplier(defenderAspects));

        //  0.50
        final double notEffective = 0.50;
        testPotency = PotencyChart.NORMAL;
        assertEquals(notEffective, testPotency.potencyMultiplier(defenderAspects));

        //  1.00
        final double effective = 1.00;
        testPotency = PotencyChart.BUG;
        assertEquals(effective, testPotency.potencyMultiplier(defenderAspects));

        //  2.00
        final double superEffective = 2.00;
        testPotency = PotencyChart.GROUND;
        assertEquals(superEffective, testPotency.potencyMultiplier(defenderAspects));

        //  4.00
        final double verySuperEffective = 4.00;
        testPotency = PotencyChart.GRASS;
        assertEquals(verySuperEffective, testPotency.potencyMultiplier(defenderAspects));
    }
}
