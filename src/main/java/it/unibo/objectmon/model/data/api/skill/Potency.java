package it.unibo.objectmon.model.data.api.skill;

/**
 * An enum of Potency that a Skill can can have.
 */
public enum Potency {

    /**
     *Effective, where the Skill multiplier is 1.0 .
     */
    EFFECTIVE("Effective", 1.0),

    /**
     *Super Effective, where the Skill multiplier is 2.0.
     */
    SUPEREFFECTIVE("Super effective", 2.0),

    /**
     *Not Very Effective, where the Skill multiplier is 0.5.
     */
    NOTEFFECTIVE("Not very effective", 0.5),

    /**
     *Immune, where the Skill multiplier is 0.
     */
    NULL("Null", 0.0);

    private final String name;
    private final double multiplier;

    /**
     * Constructor of the enum Potency.
     * 
     * @param name Name of the Potency.
     * @param multiplier Multiplier assigned to the Potency.
     */
    Potency(final String name, final double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    /**
     * Getter of a Potency's name.
     * 
     * @return Returns the name of the Potency.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of a Potency's multiplier.
     * 
     * @return Returns the multiplier of the Potency.
     */
    public final double getMultiplier() {
        return this.multiplier;
    }
}
