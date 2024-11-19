package it.unibo.objectmon.model.item.api;

/**
 * The healing items in the game.
 */
public enum HealingItemEnum {
    /**
     * The potion heals a moderate amount of HP.
     */
    POTION("Potion", 100, 50, "/items/potion.png", 
    "The least powerful healing item. Popular among novice trainers."),
    /**
     * The super potion heals a considerable amount of HP.
     */
    SUPERPOTION("Super Potion", 200, 100, "/items/superpotion.png", 
    "The is the best seller in the market right now."),
    /**
     * The hyper potion heals a large amount of HP.
     */
    HYPERPOTION("Hyper Potion", 500, 200, "/items/hyperpotion.png", 
    "The latest healing item developed by the Objectmon Corporation. Highly effective but quite expensive.");

    private final String name;
    private final int value;
    private final int healingAmount;
    private final String imagePath;
    private final String description;

    HealingItemEnum(final String name, 
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
     * Retrieves the name of the heal.
     * 
     * @return The name of the heal.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the value of the heal.
     * 
     * @return The value of the heal.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Retrieves the amount healed by the item.
     * 
     * @return The amount of HP the item is capable of healing.
     */
    public int getHealingAmount() {
        return this.healingAmount;
    }

    /**
     * Retrieves the image path of the heal.
     * 
     * @return The image path of the heal.
     */
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * Retrieves the description of the heal.
     * 
     * @return The description of the heal.
     */
    public String getDescription() {
        return this.description;
    }
}
