package it.unibo.objectmon.model.data.api.aspect;

import java.util.List;

/**
 *  An objectmon may have up to 2 elemental types.
 *  Its skills may only have 1.
 */
public enum ElementalType {

    /**
     * Normal type.
     */
    NORMAL("Normal"),

    /**
     * Grass type.
     */
    GRASS("Grass"),

    /**
     * Fire type.
     */
    FIRE("Fire"),

    /**
     * Water type.
     */
    WATER("Water"),

    /**
     * Flying type.
     */
    FLYING("Flying"),

    /**
     * Poison type.
     */
    POISON("Poison"),

    /**
     * Ground type.
     */
    GROUND("Ground"),

    /**
     * Rock type.
     */
    ROCK("Rock"),

    /**
     * Fighting type.
     */
    FIGHTING("Fighting"),

    /**
     * Bug type.
     */
    BUG("Bug");

    private final String aspectName;

    /**
     * Creates an elemental type.
     * 
     * @param name The name of the elemental type.
     */
    ElementalType(final String name) {
        this.aspectName = name;
    }

    /**
     * Retrieves the name of the elemental type.
     * 
     * @return The name of the elemental type.
     */
    public String getAspectName() {
        return this.aspectName;
    }

    // TODO
    /**
     * Method that checks if the Aspect of an Objectmon are the same of a move.
     * To check if an aspect is the same as another equals should be used.
     * 
     * @param objectmonAspects The Aspect of the Objectmon
     * @return  Returns true if it's the same, false otherwise.
     */
    public boolean sameAspect(final List<ElementalType> objectmonAspects) {
        boolean isSame = false;
        for (final ElementalType singleAspect : objectmonAspects) {
            isSame = isSame || this.equals(singleAspect);
        }
        return isSame;
    }
}
