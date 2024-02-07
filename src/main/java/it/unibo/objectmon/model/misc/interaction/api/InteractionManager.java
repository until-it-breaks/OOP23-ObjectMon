package it.unibo.objectmon.model.misc.interaction.api;

import java.util.Set;

import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;
import it.unibo.objectmon.model.entity.player.PlayerManager;
/**
 * Models a manager responsible for triggering the behaviour of an npc upon succesful check.
 */
public interface InteractionManager {
    /**
     * Triggers an npc's interaction upon a succesful check.
     * @param npcs the npcs in the game.
     * @param player the player that will be subject of the interaction.
     */
    void triggerInteraction(Set<AbstractNPC> npcs, PlayerManager player);
}
