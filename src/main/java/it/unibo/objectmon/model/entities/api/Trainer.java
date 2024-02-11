package it.unibo.objectmon.model.entities.api;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * Models an entity capable of fighting with its Objectmon team.
 */
public interface Trainer {

    /**
     * Returns the Trainer is capable of fighting again.
     * 
     * @return The trainer's will to fight.
     */
    boolean isDefeated();

    /**
     * Returns the Trainer's team of Objectmons.
     * 
     * @return The Trainer's team of Objectmons.
     */
    ObjectmonParty getObjectmonParty();
}
