package it.unibo.objectmon.model.item.api;

/**
 * Enum Item Ball.
 */
public enum BallEnum {
    /**
     * The most common objectball.
     */
    OBJECTBALL("Object Ball", 250, 1.0, "/items/objectball.png", 
    "A standard objectball with no special properties."),
    /**
     * An average objectball.
     */
    GREATBALL("Great Ball", 500, 1.5, "/items/greatball.png", 
    "An average objectball, but still slighty superior to the standard one."),
    /**
     * The strongest objectball available commercially.
     */
    ULTRABALL("Ultra Ball", 1000, 2.0, "/items/ultraball.png", 
    "The most reliable objectball available out there, has great performance but it's pricey."),
    /**
     * An sure-fire objectball, one of a kind.
     */
    MASTERBALL("Master Ball", 3000, Double.POSITIVE_INFINITY, "/items/masterball.png", 
    "The best of the best, capture is guaranteed according to the seller but it's prohibitively expensive."
    + " Word's on the street that the batch of masterballs being sold here are faulty.");

    private final String name;
    private final int value;
    private final double catchRateMultiplier;
    private final String imagePath;
    private final String description;

    BallEnum(final String name, 
        final int value, 
        final double catchRateMultiplier, 
        final String imagePath, 
        final String description) {
        this.name = name;
        this.value = value;
        this.catchRateMultiplier = catchRateMultiplier;
        this.imagePath = imagePath;
        this.description = description;
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

    /**
     * returns the image path of the objectball.
     * @return imagePath
     */
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * returns the description of the objectball.
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

}

