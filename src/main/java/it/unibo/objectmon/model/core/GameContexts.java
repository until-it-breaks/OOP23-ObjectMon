package it.unibo.objectmon.model.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.unibo.objectmon.model.battle.api.BattleStartListener;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.npc.NPCGenerator;
import it.unibo.objectmon.model.entities.player.PlayerImpl;
import it.unibo.objectmon.model.world.WorldImpl;
import it.unibo.objectmon.model.world.api.World;
import it.unibo.objectmon.model.world.api.Worlds;

/**
 * Utility class for creating default instances of {@link GameContext}.
 * This class provides a method to create a default game context with predefined settings.
 */
public final class GameContexts {

    private GameContexts() {
    }

    /**
     * Creates a default game context with predefined settings, including a default world,
     * player, and a set of NPCs.
     * 
     * @param battleStartListener The listener for handling events related to the start of battles.
     * @return A default {@link GameContext} instance.
     */
    public static GameContext createDefaultContext(final BattleStartListener battleStartListener) {
        final World defaultWorld = new WorldImpl(Worlds.DEMO);
        final Player defaultPlayer = new PlayerImpl("Player",
            defaultWorld.getStartingPosition(),
            new ArrayList<>(ObjectmonFactory.createObjectmonSet(
                List.of(ObjectmonEnum.TORCHIC,
                    ObjectmonEnum.TREECKO,
                    ObjectmonEnum.MUDKIP),
                5)));
        final Set<AbstractNPC> npcSet = NPCGenerator.createDefaultNPCs(battleStartListener);
        return new GameContextImpl(defaultWorld, defaultPlayer, npcSet);
    }
}
