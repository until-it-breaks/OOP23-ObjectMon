package it.unibo.objectmon.model.entities.factories;

import java.util.List;
import java.util.ArrayList;

import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.npc.TrainerImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * A factory class responsible for creating Trainer NPCs.
 * This factory specializes in creating Trainer NPCs with specific Objectmon teams for battles.
 */
public final class TrainerFactory implements NPCFactory {

    @Override
    public AbstractNPC createNPC(final String name, final Coord position,
        final List<ObjectmonEnum> objectmonList, final int level,
        final BattleInitiator battleInitiator, final TradeInitiator tradeInitiator) {
        final List<Objectmon> objectmons = new ArrayList<>(ObjectmonFactory.createObjectmonSet(objectmonList, level));
        return new TrainerImpl(name, position, objectmons, battleInitiator);
    }
}
