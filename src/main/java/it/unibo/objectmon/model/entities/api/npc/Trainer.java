package it.unibo.objectmon.model.entities.api.npc;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * Models an entity capable of fighting with its Objectmon team.
 */
public interface Trainer {

    /**
     * Returns whether the entity is battle worthy.
     * 
     * @return The preparedness of the Trainer.
     */
    boolean isDefeated();

    /**
     * Sets the defeat status of the trainer.
     * @param defeatStatus Whether the trainer has been defeated.
     */
    void setDefeated(boolean defeatStatus);

    /**
     * Returns the Trainer's team of Objectmons.
     * 
     * @return The Trainer's team of Objectmons.
     */
    ObjectmonParty getObjectmonParty();
}
