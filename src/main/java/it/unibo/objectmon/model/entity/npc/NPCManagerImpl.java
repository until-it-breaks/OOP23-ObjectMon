package it.unibo.objectmon.model.entity.npc;

import java.util.Collections;
import java.util.Set;
import it.unibo.objectmon.model.entity.api.NPCManager;
import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;

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
        this.npcs = npcs;
    }

    /**
     * Creates a default NPCManagerImpl populated with demo NPCs.
     * 
     * @return A default NPCManagerImpl instance.
     */
    public static NPCManager createDefaultNPCManager() {
        return new NPCManagerImpl(NPCFactory.createDemoNPCs());
    }

    @Override
    public Set<AbstractNPC> getNpcs() {
        return Collections.unmodifiableSet(npcs);
    }

    @Override
    public void setDefeatStatus(final TrainerNPCImpl trainerNPC) {
        //sets trainer to defeated;
    }
}
