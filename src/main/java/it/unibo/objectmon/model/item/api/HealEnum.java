package it.unibo.objectmon.model.item.api;

/**
 * Enum item Heal.
 */
public enum HealEnum {
    /**
     * This potion heals a moderate amount of HP to an Objectmon.
     */
    POTION("Potion", 50, 50, "/items/potion.png", 
    "The least powerful healing item. Popular among novice trainers."),
    /**
     * This super potion heals a considerable amount of HP to an Objectmon.
     */
    SUPERPOTION("Super Potion", 100, 500, "/items/superpotion.png", 
    "Balanced in price and performance, this is the best seller in the market right now."),
    /**
     * This hyper potion heals a large amount of HP to an Objectmon.
     */
    HYPERPOTION("Hyper Potion", 200, 1000, "/items/hyperpotion.png", 
    "The latest healing item developed by the Objectmon Corporation. Highly effective but quite expensive.");

    private final String name;
    private final int value;
    private final int healingAmount;
    private final String imagePath;
    private final String description;

    HealEnum(final String name, 
        final int value, 
        final int healingAmount, 
        final String imagePath, 
        final String description) {
        this.name = name;
        this.value = value;
        this.healingAmount = healingAmount;
        this.imagePath = imagePath;
        this.description = description;
    }

    /**
     * returns the name of the item.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns the cost of the item.
     * @return value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * returns the healing amount of the item.
     * @return healPoint
     */
    public int getHealingAmount() {
        return this.healingAmount;
    }

    /**
     * Returns the image path of the ite,m.
     * @return imagePath
     */
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * Returns the description of the item.
     * @return description
     */
    public String getDescription() {
        return this.description;
    }
}
