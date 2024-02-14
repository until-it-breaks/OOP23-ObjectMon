package it.unibo.objectmon.model.entities.api;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * Defines a healer NPC behaviour.
 */
public interface Healer {

    /**
     * Restores the health of an {@link ObjectmonParty}.
     * 
     * @param objectmonParty The team to be healed.
     */
    void healTeam(ObjectmonParty objectmonParty);
}
