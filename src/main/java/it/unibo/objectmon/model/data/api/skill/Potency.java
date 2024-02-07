package it.unibo.objectmon.model.data.api.skill;

/**
 * This is the potency that a Skill can can have. A Skill can be:
 * <pre>
 *{@link #EFFECTIVE} Effective, where the Skill damage is unchanged.
 *{@link #SUPEREFFECTIVE} Super Effective, where the Skill damage is doubled.
 *{@link #NOTEFFECTIVE} Not Very Effective, where the Skill damage is halved.
 *{@link #IMMUNE} Immune, where the Skill fails (does no damage).
 * </pre>
 */
public enum Potency {
    /**
     *Effective, where the Skill damage is unchanged.
     */
    EFFECTIVE("Effective", 1.0),
    /**
     *Super Effective, where the Skill damage is doubled.
     */
    SUPEREFFECTIVE("Super effective", 2.0),
    /**
     *Not Very Effective, where the Skill damage is halved.
     */
    NOTEFFECTIVE("Not very effective", 0.5),
    /**
     *Immune, where the Skill fails (does no damage).
     */
    IMMUNE("Immune", 0.0);

    /**
     *A map containing each effectiveness.
     */
    private final String name;
    private final double multiplier;

    Potency(final String name, final double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    /**
     *
     * @return Returns the name of the Potency.
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return Returns the multiplier of the Potency.
     */
    public final double getMultiplier() {
        return this.multiplier;
    }
}
