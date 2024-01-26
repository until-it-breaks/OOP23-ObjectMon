package it.unibo.objectmon.model.interaction.api;

import it.unibo.objectmon.model.entity.api.Player;
/**
 * Models the behaviour of an npc when interacted with.
 */
public interface InteractionHandler {
    /**
     * 
     * @param player the player that is involved in the interaction.
     */
    void handleInteraction(Player player);
}
