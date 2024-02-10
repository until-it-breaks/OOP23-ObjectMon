package it.unibo.objectmon.model.data.api.skill;

import java.util.HashMap;
import java.util.Map;

import it.unibo.objectmon.model.data.api.aspect.Aspect;

import java.util.List;

/**
 * a chart of Potency.
 * Used to calculate the Aspect multiplier by using the Skill Aspect
 */
public enum PotencyChart {

    /**
     *A Map of NORMAL, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    NORMAL(
        Aspect.NORMAL,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.EFFECTIVE,

            Aspect.FIRE,
            Potency.EFFECTIVE,

            Aspect.WATER,
            Potency.EFFECTIVE,

            Aspect.FLYING,
            Potency.EFFECTIVE,

            Aspect.POISON,
            Potency.EFFECTIVE,

            Aspect.GROUND,
            Potency.EFFECTIVE,

            Aspect.ROCK,
            Potency.NOTEFFECTIVE,

            Aspect.FIGHTING,
            Potency.EFFECTIVE,

            Aspect.BUG,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of GRASS, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    GRASS(
        Aspect.GRASS,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.NOTEFFECTIVE,

            Aspect.FIRE,
            Potency.NOTEFFECTIVE,

            Aspect.WATER,
            Potency.SUPEREFFECTIVE,

            Aspect.FLYING,
            Potency.NOTEFFECTIVE,

            Aspect.POISON,
            Potency.NOTEFFECTIVE,

            Aspect.GROUND,
            Potency.SUPEREFFECTIVE,

            Aspect.ROCK,
            Potency.SUPEREFFECTIVE,

            Aspect.FIGHTING,
            Potency.EFFECTIVE,

            Aspect.BUG,
            Potency.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of FIRE, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    FIRE(
        Aspect.FIRE,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.SUPEREFFECTIVE,

            Aspect.FIRE,
            Potency.NOTEFFECTIVE,

            Aspect.WATER,
            Potency.NOTEFFECTIVE,

            Aspect.FLYING,
            Potency.EFFECTIVE,

            Aspect.POISON,
            Potency.EFFECTIVE,

            Aspect.GROUND,
            Potency.EFFECTIVE,

            Aspect.ROCK,
            Potency.NOTEFFECTIVE,

            Aspect.FIGHTING,
            Potency.EFFECTIVE,

            Aspect.BUG,
            Potency.SUPEREFFECTIVE
        )
    ),
    /**
     *A Map of WATER, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    WATER(
        Aspect.WATER,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.NOTEFFECTIVE,

            Aspect.FIRE,
            Potency.SUPEREFFECTIVE,

            Aspect.WATER,
            Potency.NOTEFFECTIVE,

            Aspect.FLYING,
            Potency.EFFECTIVE,

            Aspect.POISON,
            Potency.EFFECTIVE,

            Aspect.GROUND,
            Potency.SUPEREFFECTIVE,

            Aspect.ROCK,
            Potency.SUPEREFFECTIVE,

            Aspect.FIGHTING,
            Potency.EFFECTIVE,

            Aspect.BUG,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of FLYING, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    FLYING(
        Aspect.FLYING,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.SUPEREFFECTIVE,

            Aspect.FIRE,
            Potency.EFFECTIVE,

            Aspect.WATER,
            Potency.EFFECTIVE,

            Aspect.FLYING,
            Potency.EFFECTIVE,

            Aspect.POISON,
            Potency.EFFECTIVE,

            Aspect.GROUND,
            Potency.NOTEFFECTIVE,

            Aspect.ROCK,
            Potency.NOTEFFECTIVE,

            Aspect.FIGHTING,
            Potency.SUPEREFFECTIVE,

            Aspect.BUG,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of POISON, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    POISON(
        Aspect.POISON,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.SUPEREFFECTIVE,

            Aspect.FIRE,
            Potency.EFFECTIVE,

            Aspect.WATER,
            Potency.EFFECTIVE,

            Aspect.FLYING,
            Potency.EFFECTIVE,

            Aspect.POISON,
            Potency.NOTEFFECTIVE,

            Aspect.GROUND,
            Potency.NOTEFFECTIVE,

            Aspect.ROCK,
            Potency.NOTEFFECTIVE,

            Aspect.FIGHTING,
            Potency.EFFECTIVE,

            Aspect.BUG,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of GROUND, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    GROUND(
        Aspect.GROUND,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.NOTEFFECTIVE,

            Aspect.FIRE,
            Potency.SUPEREFFECTIVE,

            Aspect.WATER,
            Potency.EFFECTIVE,

            Aspect.FLYING,
            Potency.IMMUNE,

            Aspect.POISON,
            Potency.SUPEREFFECTIVE,

            Aspect.GROUND,
            Potency.EFFECTIVE,

            Aspect.ROCK,
            Potency.SUPEREFFECTIVE,

            Aspect.FIGHTING,
            Potency.EFFECTIVE,

            Aspect.BUG,
            Potency.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of ROCK, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    ROCK(
        Aspect.ROCK,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.EFFECTIVE,

            Aspect.FIRE,
            Potency.SUPEREFFECTIVE,

            Aspect.WATER,
            Potency.EFFECTIVE,

            Aspect.FLYING,
            Potency.SUPEREFFECTIVE,

            Aspect.POISON,
            Potency.EFFECTIVE,

            Aspect.GROUND,
            Potency.NOTEFFECTIVE,

            Aspect.ROCK,
            Potency.NOTEFFECTIVE,

            Aspect.FIGHTING,
            Potency.NOTEFFECTIVE,

            Aspect.BUG,
            Potency.SUPEREFFECTIVE
        )
    ),
    /**
     *A Map of FIGHTING, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    FIGHTING(
        Aspect.FIGHTING,
        Map.of(
            Aspect.NORMAL,
            Potency.SUPEREFFECTIVE,

            Aspect.GRASS,
            Potency.EFFECTIVE,

            Aspect.FIRE,
            Potency.EFFECTIVE,

            Aspect.WATER,
            Potency.EFFECTIVE,

            Aspect.FLYING,
            Potency.NOTEFFECTIVE,

            Aspect.POISON,
            Potency.NOTEFFECTIVE,

            Aspect.GROUND,
            Potency.EFFECTIVE,

            Aspect.ROCK,
            Potency.SUPEREFFECTIVE,

            Aspect.FIGHTING,
            Potency.EFFECTIVE,

            Aspect.BUG,
            Potency.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of BUG, containing the Skill Aspect and a Map of the defenderAspect and Potency.
     */
    BUG(
        Aspect.BUG,
        Map.of(
            Aspect.NORMAL,
            Potency.EFFECTIVE,

            Aspect.GRASS,
            Potency.SUPEREFFECTIVE,

            Aspect.FIRE,
            Potency.NOTEFFECTIVE,

            Aspect.WATER,
            Potency.EFFECTIVE,

            Aspect.FLYING,
            Potency.NOTEFFECTIVE,

            Aspect.POISON,
            Potency.NOTEFFECTIVE,

            Aspect.GROUND,
            Potency.EFFECTIVE,

            Aspect.ROCK,
            Potency.EFFECTIVE,

            Aspect.FIGHTING,
            Potency.NOTEFFECTIVE,

            Aspect.BUG,
            Potency.EFFECTIVE
        )
    );

    private final Aspect skillAspect;
    private final Map<Aspect, Potency> multiplierChart = new HashMap<>();

    /**
     *
     * @param skillAspect Aspect of the associated Skill.
     * @param multipliers Map of the relation with other Aspects and the Potency.
     */
    PotencyChart(final Aspect skillAspect, final Map<Aspect, Potency> multipliers) {
        this.skillAspect = skillAspect;
        this.multiplierChart.putAll(multipliers);
    }

    /**
     *
     * @return Returns the skillAspect.
     */
    protected Aspect getSkillAspect() {
        return this.skillAspect;
    }

    /**
     *
     * @param aspect Id of the return chart.
     * @return Returns the potencyChart of the associated id.
     */
    public static PotencyChart getChart(final Aspect aspect) {
        for (final PotencyChart chart : PotencyChart.values()) {
            if (chart.getSkillAspect().equals(aspect)) {
                return chart;
            }
        }
        throw new IllegalArgumentException("No such id : " + aspect + " in the enum");
    }

    /**
     *
     * @return Returns a copy of the Multiplier chart.
     */
    protected Map<Aspect, Potency> getMultiplierChart() {
        return Map.copyOf(this.multiplierChart);
    }

    /**
     * Before using this method there must be a check for the SkillAspect.
     * @param defenderAspects All the Aspects of the target Objectmon.
     * @return Returns the final multiplier after checking all defenderAspects.
     */
    public double potencyMultiplier(final List<Aspect> defenderAspects) {
        double mult = 1;
        for (final Aspect singleAspect : defenderAspects) {
            mult *= getMultiplierChart().get(singleAspect).getMultiplier();
        }
        return mult;
    }
}
