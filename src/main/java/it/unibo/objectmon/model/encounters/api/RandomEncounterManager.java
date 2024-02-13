package it.unibo.objectmon.model.encounters.api;

/**
 * An interface modelling a manager responsible for random encounters.
 */
public interface RandomEncounterManager {

    /**
     * Assess conditions for a random encounter.
     */
    void performCheck();
}
