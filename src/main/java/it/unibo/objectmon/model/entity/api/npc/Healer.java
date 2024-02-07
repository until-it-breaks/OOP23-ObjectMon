package it.unibo.objectmon.model.entity.api.npc;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * Models a healer NPC.
 */
public interface Healer {
    /**
     * Heals the entire Objectmon team.
     * @param objectmonParty The team to be healed.
     */
    void healTeam(ObjectmonParty objectmonParty);
}
