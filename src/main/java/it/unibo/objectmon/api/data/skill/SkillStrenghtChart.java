package it.unibo.objectmon.api.data.skill;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The SkillMap of SkillStrenght.
 */
public enum SkillStrenghtChart {

    /**
     *A Map of NORMAL, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    NORMAL(
        0,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE
        )
    ),
    /**
     *A Map of GRASS, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    GRASS(
        1,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of FIRE, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    FIRE(
        2,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE
        )
    ),
    /**
     *A Map of WATER, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    WATER(
        3,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE
        )
    ),
    /**
     *A Map of FLYING, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    FLYING(
        4,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE
        )
    ),
    /**
     *A Map of POISON, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    POISON(
        5,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE
        )
    ),
    /**
     *A Map of GROUND, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    GROUND(
        6,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.IMMUNE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of ROCK, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    ROCK(
        7,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE
        )
    ),
    /**
     *A Map of FIGHTING, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    FIGHTING(
        8,
        Set.of(
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of BUG, containing an id and a Set of SkillStrenght against each other Aspect.
     */
    BUG(
        0,
        Set.of(
            SkillStrenght.EFFECTIVE,
            SkillStrenght.SUPEREFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.EFFECTIVE,
            SkillStrenght.NOTEFFECTIVE,
            SkillStrenght.EFFECTIVE
        )
    );

    private final Map<Integer, Set<SkillStrenght>> map = new HashMap<>();

    SkillStrenghtChart(final int id, final Set<SkillStrenght> multipliers) {
        this.map.put(id, multipliers);
    }
}
