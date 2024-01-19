package it.unibo.objectmon.api.data.aspect;

import java.util.HashMap;
import java.util.Map;

/**
 *Aspect correspond to Pokémon's Type. Each aspect has an id and a name
 */
public enum Aspect {

    /**
     * Aspect of Normal.
     */
    NORMAL(0, "Normal"),
    /**
     * Aspect of Grass.
     */
    GRASS(1, "Grass"),
    /**
     * Aspect of Fire.
     */
    FIRE(2, "Fire"),
    /**
     * Aspect of Water.
     */
    WATER(3, "Water"),
    /**
     * Aspect of Flying.
     */
    FLYING(4, "Flying"),
    /**
     * Aspect of Poison.
     */
    POISON(5, "Posion"),
    /**
     * Aspect of Ground.
     */
    GROUND(6, "Ground"),
    /**
     * Aspect of Rock.
     */
    ROCK(7, "Rock"),
    /**
     * Aspect of Fighting.
     */
    FIGHTING(8, "Fighting"),
    /**
     * Aspect of Bug.
     */
    BUG(9, "Bug");

    private final Map<Integer, String> aspect = new HashMap<>();
    /*
    private static final double NEUTRAL_VALUE = 1.0;
    private static final double SAME_ASPECT_BONUS = 1.5;
    */
    Aspect(final int id, final String name) {
        this.aspect.put(id, name);
    }
}
