package it.unibo.objectmon.model.entities.api;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * Represents an {@link Entity} capable of battling with its {@link ObjectmonParty}.
 */
public interface Trainer extends Entity {

    /**
     * Retrieves whether the Trainer is willing to fight.
     * 
     * @return The trainer's will to fight.
     */
    boolean isDefeated();

    /**
     * Retrieves the Trainer's team of Objectmons.
     * 
     * @return The Trainer's team of Objectmons.
     */
    ObjectmonParty getObjectmonParty();
}
