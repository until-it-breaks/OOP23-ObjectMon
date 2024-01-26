package it.unibo.objectmon.api.data.aspect;

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
    POISON(5, "Poison"),
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

    private final int aspectId;
    private final String aspectName;

    /**
     *
     * @param id Id of the aspect.
     * @param name Name of the aspect.
     */
    Aspect(final int id, final String name) {
        this.aspectId = id;
        this.aspectName = name;
    }

    /**
     *
     * @return Returns the id of the Aspect.
     */
    public int getAspectId() {
        return this.aspectId;
    }

    /**
     *
     * @return Returns the name of the Aspect.
     */
    public String getAspectName() {
        return this.aspectName;
    }
}
