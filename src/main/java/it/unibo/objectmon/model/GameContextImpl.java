package it.unibo.objectmon.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.entity.api.NPCManager;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.world.World;

/**
 * Represents the context of the game, containing information about the game world,
 * players, and NPCs. This implementation provides access to the game world, player,
 * and NPC manager.
 */
public final class GameContextImpl implements GameContext {
    private final World world;
    private final Player player;
    private final NPCManager npcManager;

    /**
     * Constructs a GameContextImpl instance with the specified world, player, and NPC manager.
     * 
     * @param world The game world associated with the context.
     * @param player The player associated with the context.
     * @param npcManager The NPC manager associated with the context.
     */
    public GameContextImpl(final World world, final Player player, final NPCManager npcManager) {
        this.world = world;
        this.player = player;
        this.npcManager = npcManager;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "The Player is supposed to be used for read and write operations")
    public Player getPlayer() {
        return this.player;
    }

    @Override
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "The NPCManager is supposed to be used for read and write operations")
    public NPCManager getNpcManager() {
        return this.npcManager;
    }
}
