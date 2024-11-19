package it.unibo.objectmon.model.data.api.statistics;

/**
 * An enumeration containing the various stats of an Objectmon.
 */
public enum StatEnum {

    /**
     * Identifies the Health Points of an Objectmon.
     * If it reaches 0, the Objectmon is defeated.
     */
    HP,

    /**
     * Identifies the Physical attack capabilities of an Objectmon.
     * If an Objectmon uses a Physical attack skill, then this stat is used
     * for the Physical damage calculation.
     */
    ATK,

    /**
     * Identifies the Physical defense capabilities of an Objectmon.
     * If an opponent uses a Physical attack skill, then this stat is used 
     * for the Physical damage calculation.
     */
    DEF,

    /**
     * Identifies the Special attack capabilities of an Objectmon.
     * If an Objectmon uses a Special attack skill, then this stat is used
     * for Special damage calculation.
     */
    SPATK,

    /**
     * Identifies the Special defense capabilities of an Objectmon.
     * If an opponent uses a Special attack skill, then this stat is used 
     * for Special damage calculation.
     */
    SPDEF,

    /**
     * Identifies the speed of an Objectmon.
     * The Objectmon with the highest speed is the first perform their move.
     */
    SPD
}
