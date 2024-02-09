package it.unibo.objectmon.model.misc.interaction.api;

import java.util.List;
import java.util.Set;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.npc.AbstractNPC;

/**
 * Models a manager responsible for triggering the behaviour of an npc upon succesful check.
 */
public interface InteractionManager {
    /**
     * Triggers an npc's interaction upon a succesful check.
     * @param npcs the npcs in the game.
     * @param player the player that will be subject of the interaction.
     * @return true if an interaction has taken place.
     */
    boolean triggerInteraction(Set<AbstractNPC> npcs, Player player);

    /**
     * Retrieves the interactions message log.
     * @return a List<String> representing the messages.
     */
    List<String> getMessages();
}
