package it.unibo.objectmon.model.entities.npc;

import java.util.Collections;
import java.util.Set;

import it.unibo.objectmon.model.entities.api.NPCManager;
import it.unibo.objectmon.model.entities.api.npc.AbstractNPC;

import java.util.HashSet;

/**
 * A concrete implementation of the NPCManager interface that manages non-playable characters (NPCs) in the game.
 * This class provides methods for initializing NPCs, retrieving the current set of NPCs,
 * and managing their states.
 */
public final class NPCManagerImpl implements NPCManager {
    private final Set<AbstractNPC> npcs;

    /**
     * Constructs an NPCManagerImpl with the specified set of NPCs.
     * 
     * @param npcs The set of NPCs to be managed by this NPCManagerImpl.
     */
    public NPCManagerImpl(final Set<AbstractNPC> npcs) {
        this.npcs = new HashSet<>(npcs);
    }

    @Override
    public Set<AbstractNPC> getNPCs() {
        return Collections.unmodifiableSet(this.npcs);
    }

    @Override
    public void setDefeatStatus(final TrainerNPCImpl trainerNPC) {
        //sets trainer to defeated;
    }
}
