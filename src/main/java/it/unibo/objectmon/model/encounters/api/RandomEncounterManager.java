package it.unibo.objectmon.model.encounters.api;

/**
 * An interface modelling a manager responsible for random encounters.
 */
public interface RandomEncounterManager {

    /**
     * Assess conditions for a random encounter.
     */
    void performCheck();

    /**
     * Gives immunity to random encounters.
     */
    void activateGracePeriod();

    /**
     * Returns whether the grace state is active.
     * 
     * @return true if grace is active, false otherwise.
     */
    boolean isGracePeriodActive();
}
