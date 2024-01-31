package it.unibo.objectmon.model.entity.npc.api;

import java.util.Set;
import it.unibo.objectmon.api.data.objectmon.Objectmon;

/**
 * Models an entity capable of fighting with its Objectmon team.
 */
public interface Trainer {

    /**
     * Sets the preparedness to fight.
     * @param isDefeated The preparedness of the Trainer.
     */
    void setDefeated(boolean isDefeated);

    /**
     * Returns whether the entity is battle worthy.
     * @return The preparedness of the Trainer.
     */
    boolean isDefeated();

    /**
     * Returns the Trainer's team of Objectmons.
     * @return The Trainer's team of Objectmons.
     */
    Set<Objectmon> getTeam();
}
