package it.unibo.objectmon.model.entities.api;

import java.util.Set;

/**
 * An interface defining the contract for managing non-playable characters (NPCs) in the game.
 * Implementations of this interface are responsible for providing access to the current set of NPCs
 * and allowing the manipulation of their states, such as setting defeat status for specific NPCs.
 */
public interface NPCManager {

    /**
     * Retrieves an immutable set of all current NPCs managed by the implementation.
     * 
     * @return An immutable set of current NPCs.
     */
    Set<AbstractNPC> getNPCs();

}
