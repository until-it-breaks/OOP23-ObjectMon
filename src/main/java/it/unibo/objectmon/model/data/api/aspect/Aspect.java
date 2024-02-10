package it.unibo.objectmon.model.data.api.aspect;

import java.util.List;

/**
 *Aspect correspond to Pokémon's Type. Each aspect has an id and a name
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
     *
     * @param id Id of the aspect.
     * @param name Name of the aspect.
     */
    Aspect(final String name) {
        this.aspectName = name;
    }

    /**
     *
     * @return Returns the name of the Aspect.
     */
    public String getAspectName() {
        return this.aspectName;
    }


    /**
     *
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
