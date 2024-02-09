package it.unibo.objectmon.model;

import java.util.Set;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.entities.api.NPCManager;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.npc.AbstractNPC;
import it.unibo.objectmon.model.entities.npc.NPCManagerImpl;
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
     * @param npcs The set of NPCS to be put in the NPCManager associated with the context.
     */
    public GameContextImpl(final World world, final Player player, final Set<AbstractNPC> npcs) {
        this.world = world;
        this.player = player;
        this.npcManager = new NPCManagerImpl(npcs);
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
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "The NPCManager is supposed to be used for read and write operations")
    public NPCManager getNpcManager() {
        return this.npcManager;
    }
}
