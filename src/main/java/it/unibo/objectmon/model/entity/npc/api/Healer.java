package it.unibo.objectmon.model.entity.npc.api;

import java.util.Set;
import it.unibo.objectmon.api.data.objectmon.Objectmon;

/**
 * Models a healer NPC.
 */
public interface Healer {
    /**
     * Heals the entire Objectmon team.
     * @param team The team to be healed.
     */
    void healTeam(Set<Objectmon> team);
}
