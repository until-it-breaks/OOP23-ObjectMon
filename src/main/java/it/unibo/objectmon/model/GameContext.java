package it.unibo.objectmon.model;

import it.unibo.objectmon.model.entities.api.NPCManager;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.world.World;

/**
 * Represents the context of the game, containing information about the game world,
 * players, and NPCs.
 */
public interface GameContext {

    /**
     * Retrieves the world associated with the game context.
     * 
     * @return The world.
     */
    World getWorld();

    /**
     * Retrieves the player associated with the game context.
     * 
     * @return The player.
     */
    Player getPlayer();

    /**
     * Retrieves the NPC manager associated with the game context.
     * 
     * @return The NPC manager.
     */
    NPCManager getNpcManager();
}
