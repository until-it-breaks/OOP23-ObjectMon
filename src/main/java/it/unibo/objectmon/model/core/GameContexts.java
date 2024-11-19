package it.unibo.objectmon.model.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.factories.NPCGenerator;
import it.unibo.objectmon.model.entities.player.PlayerImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.world.WorldImpl;
import it.unibo.objectmon.model.world.api.World;
import it.unibo.objectmon.model.world.api.Worlds;

/**
 * Utility class for creating default instances of {@link GameContext}.
 */
public final class GameContexts {

    private GameContexts() {
    }

    /**
     * Creates a default game context with predefined settings, including a default world,
     * player and a set of NPCs.
     * 
     * @param battleInitiator A listener responsible for starting battles.
     * @param tradeInitiator A listener responsible for starting a trade session.
     * @return A default {@link GameContext} instance.
     */
    public static GameContext createDefaultContext(final BattleInitiator battleInitiator,
        final TradeInitiator tradeInitiator) {
        final World defaultWorld = new WorldImpl(Worlds.DEMO);
        final Player defaultPlayer = new PlayerImpl("Player",
            defaultWorld.getStartingPosition(),
            new ArrayList<>(ObjectmonFactory.createObjectmonSet(
                List.of(ObjectmonEnum.TORCHIC,
                    ObjectmonEnum.TREECKO,
                    ObjectmonEnum.MUDKIP),
                5)));
        final Set<AbstractNPC> npcSet = NPCGenerator.createDefaultNPCs(battleInitiator, tradeInitiator);
        return new GameContextImpl(defaultWorld, defaultPlayer, npcSet);
    }
}
