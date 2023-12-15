package it.unibo.objectmon.api.data.skill;

import java.util.HashMap;
import java.util.Map;

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
    private final Map<String, Double> strenght = new HashMap<>();

    Potency(final String name, final double value) {
        this.strenght.put(name, value);
    }

    /**
     * 
     * @param key Name of the multiplier
     * @return Returns the multiplier
     */
    protected final double getMultiplier(final String key) {
        return this.strenght.get(key);
    }
}
