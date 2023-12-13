package it.unibo.objectmon.api.data.statistics;

/**
 * Enum of the Statistics of an Objectmon.
 */
public enum StatId {
    /**
     * Identifies the Health Points of the Objectmon.
     * If it reaches negative or 0, set HP to 0 and
     * the Objectmon is defeated.
     */
    HP,
    /**
     * Identifies the Attack of the Objectmon.
     * If the Objectmon uses a Physical Skill, then this stat is used
     * for damage calculation.
     */
    ATK,
    /**
     * Identifies the Defense of the Objectmon.
     * If the opponent uses a Physical Skill, then this stat is used 
     * for damage calculation.
     */
    DEF,
    /**
     * Identifies the Special Attack of the Objectmon.
     * If the Objectmon uses a Special Skill, then this stat is used
     * for damage calculation.
     */
    SPATK,
    /**
     * Identifies the Special Defense of the Objectmon.
     * If the opponent uses a Special Skill, then this stat is used 
     * for damage calculation.
     */
    SPDEF,
    /**
     * Identifies the Speed of the Objectmon.
     * The Objectmon with the highest speed is the first to use their Skill.
     */
    SPD
}
