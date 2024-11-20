package it.unibo.objectmon.model.data.api.skill;

/**
 * An enumeration of possible outcomes when ElementalTypes are compared.
 */
public enum EffectivenessEnum {

    /**
     * Effective.
     */
    EFFECTIVE("Effective", 1.0),

    /**
     * Super Effective.
     */
    SUPER_EFFECTIVE("Super effective", 2.0),

    /**
     * Not Very Effective.
     */
    NOT_EFFECTIVE("Not very effective", 0.5),

    /**
     * TODO
     * Null.
     */
    NULL("Null", 0.0);

    private final String name;
    private final double multiplier;

    /**
     * Creates a new efficiency,
     * 
     * @param name The name of the efficiency.
     * @param multiplier The damage multiplier assigned to the outcome.
     */
    EffectivenessEnum(final String name, final double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    /**
     * Retrieves the efficiency outcome name.
     * 
     * @return The efficiency outcome.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the efficiency damage multiplier.
     * 
     * @return Returns the efficiency damage multiplier.
     */
    public final double getMultiplier() {
        return this.multiplier;
    }
}
