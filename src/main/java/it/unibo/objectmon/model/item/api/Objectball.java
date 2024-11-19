package it.unibo.objectmon.model.item.api;

/**
 * Models a tool used to catch objectmons.
 */
public interface Objectball extends Item {

    /**
     * Retrieves the catch rate multiplier of the objectball.
     * 
     * @return The catch rate multiplier of the objectball.
     */
    double getCatchMultiplier();
}
