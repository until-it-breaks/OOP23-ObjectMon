package it.unibo.objectmon.model.item.api;

/**
 * The objectballs in the game.
 */
public enum ObjectballEnum {
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
    "The most reliable objectball available out there, performance is great but it's quite expensive."),
    /**
     * An sure-fire objectball, one of a kind.
     */
    MASTERBALL("Master Ball", 3000, Double.POSITIVE_INFINITY, "/items/masterball.png", 
    "The best of the best, capture is guaranteed according to the seller but it's prohibitively expensive."
    + " Word's on the street that the batch of masterballs sold here is full of duds.");

    private final String name;
    private final int value;
    private final double catchRateMultiplier;
    private final String imagePath;
    private final String description;

    ObjectballEnum(final String name, 
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
     * Retrieves the value of the objectball.
     * 
     * @return The value of the objectball.
     */
    public int getValue() {
        return value;
    }

    /**
     * Retrieves the catch rate multiplier of the objectball.
     * 
     * @return The catch rate multiplier of the objectball.
     */
    public double getCatchRateMultiplier() {
        return catchRateMultiplier;
    }

    /**
     * Retrieves the name of the objectball.
     * 
     * @return The name of the objectball.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrives the image path of the objectball.
     * 
     * @return The image path of the objectball.
     */
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * Retrives the description of the objectball.
     * 
     * @return The description of the objectball.
     */
    public String getDescription() {
        return this.description;
    }
}
