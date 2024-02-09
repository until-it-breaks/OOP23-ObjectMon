package it.unibo.objectmon.model;

import java.util.List;
import it.unibo.objectmon.model.entity.api.NPCManager;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.NPCManagerImpl;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.model.world.Worlds;

/**
 * Utility class for creating default instances of {@link GameContext}.
 * This class provides a method to create a default game context with predefined settings.
 */
public final class GameContexts {

    private GameContexts() {
    }

    /**
     * Creates a default game context with predefined settings, including a default world,
     * player, and NPC manager.
     * 
     * @return A default {@link GameContext} instance.
     */
    public static GameContext createDefaultContext() {
        final World defaultWorld = new World(Worlds.DEMO);
        final Player defaultPlayer = new PlayerImpl("Player", defaultWorld.getStartingPosition(), List.of());
        final NPCManager defaultNpcManager = NPCManagerImpl.createDefaultNPCManager();
        return new GameContextImpl(defaultWorld, defaultPlayer, defaultNpcManager);
    }
}
