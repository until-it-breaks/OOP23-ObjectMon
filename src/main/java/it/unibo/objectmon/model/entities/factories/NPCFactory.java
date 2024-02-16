package it.unibo.objectmon.model.entities.factories;

import java.util.List;
import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * An interface representing a factory for creating NPCs.
 * Implementing classes should provide specific implementations for creating different types of NPCs.
 */
public interface NPCFactory {

    /**
     * Creates a specific type of NPC with the given parameters.
     *
     * @param name           The name of the NPC.
     * @param position       The position of the NPC in the game world.
     * @param objectmonList  The list of Objectmon the NPC possesses.
     * @param level          The level of the NPC objectmons.
     * @param battleInitiator Responsible for initiating battles.
     * @param tradeInitiator  Responsible for initiating trade sessions.
     * @return A specific type of NPC based on the factory implementation.
     */
    AbstractNPC createNPC(String name, Coord position, List<ObjectmonEnum> objectmonList,
        int level, BattleInitiator battleInitiator, TradeInitiator tradeInitiator);
}
