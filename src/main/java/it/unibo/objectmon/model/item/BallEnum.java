package it.unibo.objectmon.model.item;

/**
 * Enum Item Ball.
 */
public enum BallEnum {
    /**
     * 
     */
    OBJECTBALL("Object Ball", 100, 1.0),
    /**
     * 
     */
    MEGABALL("Mega Ball", 200, 1.5),
    /**
     * 
     */
    ULTRABALL("Ultra Ball", 400, 2.0);

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

