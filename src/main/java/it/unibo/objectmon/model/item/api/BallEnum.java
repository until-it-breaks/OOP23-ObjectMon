package it.unibo.objectmon.model.item.api;

/**
 * Enum Item Ball.
 */
public enum BallEnum {
    /**
     * The most common objectball.
     */
    OBJECTBALL("Object Ball", 100, 1.0),
    /**
     * An average objectball.
     */
    MEGABALL("Mega Ball", 200, 1.5),
    /**
     * The strongest objectball available commercially.
     */
    ULTRABALL("Ultra Ball", 400, 2.0),
    /**
     * An sure-fire objectball, one of a kind.
     */
    MASTERBALL("Master Ball", 3000, Double.POSITIVE_INFINITY);

    private final String name;
    private final int value;
    private final double catchRateMultiplier;

    BallEnum(final String name, final int value, final double catchRateMultiplier) {
        this.name = name;
        this.value = value;
        this.catchRateMultiplier = catchRateMultiplier;
    }

    /**
     * return value of item.
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * returns catch rate multiplier.
     * @return catchRateMultiplier
     */
    public double getCatchRateMultiplier() {
        return catchRateMultiplier;
    }

    /**
     * returns name of item.
     * @return name
     */
    public String getName() {
        return this.name;
    }

}

