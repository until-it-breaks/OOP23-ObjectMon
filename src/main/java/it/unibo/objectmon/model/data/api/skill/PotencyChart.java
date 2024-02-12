package it.unibo.objectmon.model.data.api.skill;

import java.util.HashMap;
import java.util.Map;

import it.unibo.objectmon.model.data.api.aspect.Aspect;

import java.util.List;

/**
 * A chart of Potency.
 * <br>Used to calculated the Potency of a Skill.
 *
 * <br>In Battle, an Objectmon can use a Skill.
 * When using a Skill we need to calculate a multiplier,
 * which is based on the following parts:
 * <br>(1) The Aspect of the Skill used and the user's Aspects;
 * <br>(2) The Aspect of the Skill used and the opposing Objectmon's Aspects.
 * <br>
 * <br>(1) If they share the Aspect, then the base multiplier is 1.5,
 * otherwise it's 1;
 * <br>
 * <br>(2) If the Skill is:
 * <br>Effective, then the multiplier is EFFECTIVE;
 * <br>Super Effective, then the multiplier is SUPEREFFECTIVE;
 * <br>Not Very Effective, then the multiplier is NOTEFFECTIVE;
 * <br>Null, then the multiplier is NULL.
 * <br>(2) is calculated for each Aspect of the opposing Objectmon.
 *
 * */
public enum PotencyChart {

    /**
     *The PotencyChart of a NORMAL Skill.
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
     *The PotencyChart of a GRASS Skill.
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
     *The PotencyChart of a FIRE Skill.
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
     *The PotencyChart of a WATER Skill.
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
     *The PotencyChart of a FLYING Skill.
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
     *The PotencyChart of a POISON Skill.
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
     *The PotencyChart of a GROUND Skill.
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
            Potency.NULL,

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
     *The PotencyChart of a ROCK Skill.
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
     *The PotencyChart of a FIGHTING Skill.
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
     *The PotencyChart of a BUG Skill.
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

    private static final double SAMETYPEBONUS = 1.5;

    private final Aspect skillAspect;
    private final Map<Aspect, Potency> multiplierChart = new HashMap<>();

    /**
     * Constructor of the enum PotencyChart.
     * 
     * @param skillAspect Aspect of the associated Skill.
     * @param multipliers Map of the relation with other Aspects and the Potency.
     */
    PotencyChart(final Aspect skillAspect, final Map<Aspect, Potency> multipliers) {
        this.skillAspect = skillAspect;
        this.multiplierChart.putAll(multipliers);
    }

    /**
     * Getter of a Skill's Aspect.
     * 
     * @return Returns the Skill's Aspect.
     */
    protected Aspect getSkillAspect() {
        return this.skillAspect;
    }

    /**
     * Getter of the PotencyChart.
     * 
     * @param aspect Aspect of the Skill.
     * @return Returns the PotencyChart of the associated Aspect.
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
     * Getter of the multiplier of a PotencyChart.
     * 
     * @return Returns a copy of the Multiplier chart.
     */
    protected Map<Aspect, Potency> getMultiplierChart() {
        return Map.copyOf(this.multiplierChart);
    }

    /**
     * Calculates the multiplier of a Skill against the opposing Objectmon.
     * 
     * @param userAspects The Aspects of the Objectmon that uses the Skill.
     * @param defenderAspects The Aspects of the target Objectmon.
     * @return Returns the final multiplier after checking all defenderAspects.
     */
    public double potencyMultiplier(final List<Aspect> userAspects, final List<Aspect> defenderAspects) {
        double mult = getSkillAspect().sameAspect(userAspects) ? SAMETYPEBONUS : 1.0;
        for (final Aspect singleAspect : defenderAspects) {
            mult *= getMultiplierChart().get(singleAspect).getMultiplier();
        }
        return mult;
    }
}
