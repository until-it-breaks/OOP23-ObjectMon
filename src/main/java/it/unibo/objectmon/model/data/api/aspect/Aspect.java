package it.unibo.objectmon.model.data.api.aspect;

import java.util.List;

/**
 *Aspect correspond to Pokémon's Type. Each aspect has an id and a name
 */
public enum Aspect {

    /**
     * Aspect of Normal.
     */
    NORMAL(AspectId.NORMAL, "Normal"),
    /**
     * Aspect of Grass.
     */
    GRASS(AspectId.GRASS, "Grass"),
    /**
     * Aspect of Fire.
     */
    FIRE(AspectId.FIRE, "Fire"),
    /**
     * Aspect of Water.
     */
    WATER(AspectId.WATER, "Water"),
    /**
     * Aspect of Flying.
     */
    FLYING(AspectId.FLYING, "Flying"),
    /**
     * Aspect of Poison.
     */
    POISON(AspectId.POISON, "Poison"),
    /**
     * Aspect of Ground.
     */
    GROUND(AspectId.GROUND, "Ground"),
    /**
     * Aspect of Rock.
     */
    ROCK(AspectId.ROCK, "Rock"),
    /**
     * Aspect of Fighting.
     */
    FIGHTING(AspectId.FIGHTING, "Fighting"),
    /**
     * Aspect of Bug.
     */
    BUG(AspectId.BUG, "Bug");

    private final AspectId aspectId;
    private final String aspectName;

    /**
     *
     * @param id Id of the aspect.
     * @param name Name of the aspect.
     */
    Aspect(final AspectId id, final String name) {
        this.aspectId = id;
        this.aspectName = name;
    }

    /**
     *
     * @return Returns the id of the Aspect.
     */
    public AspectId getAspectId() {
        return this.aspectId;
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
            isSame = isSame || getAspectId().equals(singleAspect.getAspectId());
        }
        return isSame;
    }
}
