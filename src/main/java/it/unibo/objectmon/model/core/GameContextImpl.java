package it.unibo.objectmon.model.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.world.api.World;

/**
 * Represents the context of the game, containing information about the game world,
 * players, and NPCs. This implementation provides access to the game world, player,
 * and NPC manager.
 */
public final class GameContextImpl implements GameContext {
    private final World world;
    private final Player player;
    private final Set<AbstractNPC> npcs;

    /**
     * Creates a GameContextImpl instance with the specified world, player and NPC manager.
     * 
     * @param world The game world associated with the context.
     * @param player The player associated with the context.
     * @param npcs The set of NPCS to be put in the NPCManager associated with the context.
     */
    public GameContextImpl(final World world, final Player player, final Set<AbstractNPC> npcs) {
        this.world = world;
        this.player = player;
        this.npcs = new HashSet<>(npcs);
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public Set<AbstractNPC> getNPCs() {
        return Collections.unmodifiableSet(this.npcs);
    }
}
