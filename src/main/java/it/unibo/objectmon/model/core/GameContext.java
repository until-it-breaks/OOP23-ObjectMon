package it.unibo.objectmon.model.core;

import java.util.Set;

import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.world.api.World;

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
     * Retrieves the NPCs in the game.
     * 
     * @return The NPCs.
     */
    Set<AbstractNPC> getNPCs();
}
