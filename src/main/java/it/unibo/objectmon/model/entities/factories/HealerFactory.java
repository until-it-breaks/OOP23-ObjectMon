package it.unibo.objectmon.model.entities.factories;

import java.util.List;

import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.npc.HealerImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * A factory class responsible for creating Healer NPCs.
 * This factory specializes in creating NPCs able to heal the player's Objectmons.
 */
public final class HealerFactory implements NPCFactory {

    @Override
    public AbstractNPC createNPC(final String name, final Coord position,
        final List<ObjectmonEnum> objectmonList, final int level,
        final BattleInitiator battleInitiator, final TradeInitiator tradeInitiator) {
        return new HealerImpl(name, position);
    }
}
