package it.unibo.objectmon.model.entity.api.npc;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * Models an entity capable of battling with its team of Objectmons.
 */
public interface Trainer {

    /**
     * Determines whether the Trainer entity has been defeated in battle.
     *
     * @return {@code true} if the Trainer has been defeated, {@code false} otherwise.
     */
    boolean isDefeated();

    /**
     * Sets the defeat status of the Trainer.
     * This method is typically used to mark the Trainer as defeated after losing a battle.
     *
     * @param defeatStatus {@code true} to mark the Trainer as defeated, {@code false} otherwise.
     */
    void setDefeated(boolean defeatStatus);

    /**
     * Retrieves the Trainer's team of Objectmons.
     *
     * @return The team of Objectmons belonging to the Trainer.
     */
    ObjectmonParty getObjectmonParty();
}
