package it.unibo.objectmon.model.data.api.aspect;

import java.util.List;

/**
 *  Aspect correspond to Pokémon's Type.
 *  Aspects are used on Objectmon (List of max 2 Aspects) and
 *  In a Skill (A Skill has only one Aspect).
 */
public enum Aspect {

    /**
     * Aspect of Normal.
     */
    NORMAL("Normal"),
    /**
     * Aspect of Grass.
     */
    GRASS("Grass"),
    /**
     * Aspect of Fire.
     */
    FIRE("Fire"),
    /**
     * Aspect of Water.
     */
    WATER("Water"),
    /**
     * Aspect of Flying.
     */
    FLYING("Flying"),
    /**
     * Aspect of Poison.
     */
    POISON("Poison"),
    /**
     * Aspect of Ground.
     */
    GROUND("Ground"),
    /**
     * Aspect of Rock.
     */
    ROCK("Rock"),
    /**
     * Aspect of Fighting.
     */
    FIGHTING("Fighting"),
    /**
     * Aspect of Bug.
     */
    BUG("Bug");

    private final String aspectName;

    /**
     * Constructor of the enum Aspect.
     * @param name Name of the Aspect.
     */
    Aspect(final String name) {
        this.aspectName = name;
    }

    /**
     * Getter of the name of the Aspect.
     * @return Returns the name of the Aspect.
     */
    public String getAspectName() {
        return this.aspectName;
    }


    /**
     * Method that checks if the Aspect of an Objectmon are the same of a move.
     * To check if an aspect is the same as another equals should be used.
     * @param objectmonAspects The Aspect of the Objectmon
     * @return  Returns true if it's the same, false otherwise.
     */
    public boolean sameAspect(final List<Aspect> objectmonAspects) {
        boolean isSame = false;
        for (final Aspect singleAspect : objectmonAspects) {
            isSame = isSame || this.equals(singleAspect);
        }
        return isSame;
    }
}
