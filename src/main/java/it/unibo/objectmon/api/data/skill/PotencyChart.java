package it.unibo.objectmon.api.data.skill;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The map of Potency.
 * Each Map contains the id of the Aspect and a set of potency
 * (a move of a certain Aspect against all other Aspects).
 */
public enum PotencyChart {

    /**
     *A Map of NORMAL, containing an id and a Set of Potency against each other Aspect.
     */
    NORMAL(
        0,
        Set.of(
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of GRASS, containing an id and a Set of Potency against each other Aspect.
     */
    GRASS(
        1,
        Set.of(
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of FIRE, containing an id and a Set of Potency against each other Aspect.
     */
    FIRE(
        2,
        Set.of(
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE
        )
    ),
    /**
     *A Map of WATER, containing an id and a Set of Potency against each other Aspect.
     */
    WATER(
        3,
        Set.of(
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of FLYING, containing an id and a Set of Potency against each other Aspect.
     */
    FLYING(
        4,
        Set.of(
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of POISON, containing an id and a Set of Potency against each other Aspect.
     */
    POISON(
        5,
        Set.of(
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE
        )
    ),
    /**
     *A Map of GROUND, containing an id and a Set of Potency against each other Aspect.
     */
    GROUND(
        6,
        Set.of(
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.IMMUNE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of ROCK, containing an id and a Set of Potency against each other Aspect.
     */
    ROCK(
        7,
        Set.of(
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.SUPEREFFECTIVE
        )
    ),
    /**
     *A Map of FIGHTING, containing an id and a Set of Potency against each other Aspect.
     */
    FIGHTING(
        8,
        Set.of(
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE
        )
    ),
    /**
     *A Map of BUG, containing an id and a Set of Potency against each other Aspect.
     */
    BUG(
        0,
        Set.of(
            Potency.EFFECTIVE,
            Potency.SUPEREFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE,
            Potency.EFFECTIVE,
            Potency.NOTEFFECTIVE,
            Potency.EFFECTIVE
        )
    );

    private final Map<Integer, Set<Potency>> map = new HashMap<>();

    PotencyChart(final int id, final Set<Potency> multipliers) {
        this.map.put(id, multipliers);
    }
}
