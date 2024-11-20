package it.unibo.objectmon.model.data.api.skill;

import java.util.HashMap;
import java.util.Map;

import it.unibo.objectmon.model.data.api.elementalType.ElementalType;

import java.util.List;

/**
 * A chart of Efficiencies used to calculated the effectiveness of a skill.
 */
public enum EfficiencyTableEnum {

    /**
     * The EfficiencyTable of a NORMAL.
     */
    NORMAL(
        ElementalType.NORMAL,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a GRASS.
     */
    GRASS(
        ElementalType.GRASS,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.NOT_EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a FIRE.
     */
    FIRE(
        ElementalType.FIRE,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.SUPER_EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a WATER.
     */
    WATER(
        ElementalType.WATER,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a FLYING.
     */
    FLYING(
        ElementalType.FLYING,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a POISON.
     */
    POISON(
        ElementalType.POISON,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a GROUND.
     */
    GROUND(
        ElementalType.GROUND,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.NULL,

            ElementalType.POISON,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.NOT_EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a ROCK.
     */
    ROCK(
        ElementalType.ROCK,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.SUPER_EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a FIGHTING.
     */
    FIGHTING(
        ElementalType.FIGHTING,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.NOT_EFFECTIVE
        )
    ),

    /**
     * The EfficiencyTable of a BUG.
     */
    BUG(
        ElementalType.BUG,
        Map.of(
            ElementalType.NORMAL,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.GRASS,
            EffectivenessEnum.SUPER_EFFECTIVE,

            ElementalType.FIRE,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.WATER,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FLYING,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.POISON,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.GROUND,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.ROCK,
            EffectivenessEnum.EFFECTIVE,

            ElementalType.FIGHTING,
            EffectivenessEnum.NOT_EFFECTIVE,

            ElementalType.BUG,
            EffectivenessEnum.EFFECTIVE
        )
    );

    private static final double SAME_TYPE_BONUS = 1.5;

    private final ElementalType skillElementalType;
    private final Map<ElementalType, EffectivenessEnum> multiplierChart = new HashMap<>();

    /**
     * Creates a new EfficiencyTable.
     *
     * @param skillElementalType The ElementalType of the associated Skill.
     * @param multipliers The map of related efficiencies.
     */
    EfficiencyTableEnum(final ElementalType skillElementalType, final Map<ElementalType, EffectivenessEnum> multipliers) {
        this.skillElementalType = skillElementalType;
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
            if (chart.getSkillElementalType().equals(elementalType)) {
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
    public double getEffectivenessMultiplier(final List<ElementalType> userAspects, final List<ElementalType> defenderAspects) {
        double mult = getSkillElementalType().sameAspect(userAspects) ? SAME_TYPE_BONUS : 1.0;
        for (final ElementalType singleAspect : defenderAspects) {
            mult *= getMultiplierChart().get(singleAspect).getMultiplier();
        }
        return mult;
    }

    /**
     * Getter of the multiplier of a PotencyChart.
     *
     * @return Returns a copy of the Multiplier chart.
     */
    protected Map<ElementalType, EffectivenessEnum> getMultiplierChart() {
        return Map.copyOf(this.multiplierChart);
    }

    /**
     * Getter of a Skill's ElementalType.
     *
     * @return Returns the Skill's ElementalType.
     */
    protected ElementalType getSkillElementalType() {
        return this.skillElementalType;
    }
}
