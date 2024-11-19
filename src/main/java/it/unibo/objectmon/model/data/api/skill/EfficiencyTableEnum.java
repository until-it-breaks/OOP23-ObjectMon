package it.unibo.objectmon.model.data.api.skill;

import java.util.HashMap;
import java.util.Map;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.aspect.ElementalType;

import java.util.List;

/**
 * A chart of Efficiencies used to calculated the effectiveness of a skill.
 */
public enum EfficiencyTableEnum {

    /**
     * The EfficiencyTable of a NORMAL.
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
     * The EfficiencyTable of a GRASS.
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
     * The EfficiencyTable of a FIRE.
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
     * The EfficiencyTable of a WATER.
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
     * The EfficiencyTable of a FLYING.
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
     * The EfficiencyTable of a POISON.
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
     * The EfficiencyTable of a GROUND.
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
     * The EfficiencyTable of a ROCK.
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
     * The EfficiencyTable of a FIGHTING.
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
     * The EfficiencyTable of a BUG.
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

    private static final double SAME_TYPE_BONUS = 1.5;

    private final Aspect skillAspect;
    private final Map<Aspect, Efficiency> multiplierChart = new HashMap<>();

    /**
     * Creates a new EfficiencyTable.
     *
     * @param skillAspect The ElementalType of the associated Skill.
     * @param multipliers The map of related efficiencies.
     */
    EfficiencyTableEnum(final Aspect skillAspect, final Map<Aspect, Efficiency> multipliers) {
        this.skillAspect = skillAspect;
        this.multiplierChart.putAll(multipliers);
    }

    /**
     * Returns an efficiency table.
     *
     * @param elementalType The ElementalType of the skill.
     * @return Returns the EfficiencyTable of the associated ElementalType.
     */
    public static EfficiencyTableEnum getChart(final ElementalType elementalType) {
        for (final EfficiencyTableEnum chart : EfficiencyTableEnum.values()) {
            if (chart.getSkillAspect().equals(elementalType)) {
                return chart;
            }
        }
        throw new IllegalArgumentException("No such elemental type: " + elementalType);
    }

    /**
     * Calculates the multiplier of a Skill against the opposing Objectmon.
     *
     * @param userAspects The Aspects of the Objectmon that uses the Skill.
     * @param defenderAspects The Aspects of the target Objectmon.
     * @return Returns the final multiplier after checking all defenderAspects.
     */
    public double potencyMultiplier(final List<Aspect> userAspects, final List<Aspect> defenderAspects) {
        double mult = getSkillAspect().sameAspect(userAspects) ? SAME_TYPE_BONUS : 1.0;
        for (final Aspect singleAspect : defenderAspects) {
            mult *= getMultiplierChart().get(singleAspect).getMultiplier();
        }
        return mult;
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
     * Getter of a Skill's Aspect.
     *
     * @return Returns the Skill's Aspect.
     */
    protected Aspect getSkillAspect() {
        return this.skillAspect;
    }
}
