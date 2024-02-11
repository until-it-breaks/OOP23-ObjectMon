package it.unibo.objectmon.model.item.api;

/**
 * Enum of item Heal.
 */
public enum HealEnum {
    /**
     * The smallest heal item.
     */
    POTION("Small Heal", 100, 15),
    /**
     * The medium heal item.
     */
    SUPERPOTION("Medium Heal", 200, 30),
    /**
     * The largest heal item.
     */
    HYPERPOTION("Large Heal", 400, 60);

    private final String name;
    private final int value;
    private final int healPoint;

    HealEnum(final String name, final int value, final int healPoint) {
        this.name = name;
        this.value = value;
        this.healPoint = healPoint;
    }

    /**
     * returns string of the name of the item.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * returns the value of the item.
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * returns point of heal of the item.
     * @return healPoint
     */
    public int getHealPoint() {
        return healPoint;
    }
}
