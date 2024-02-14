package it.unibo.objectmon.model.misc.interaction.api;

import java.util.List;
import java.util.Set;

import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;

/**
 * An interface for managing interactions with NPCs.
 * Implementations of this interface are responsible for triggering NPC behavior upon successful checks.
 */
public interface InteractionManager {

    /**
     * Triggers an interaction with NPCs upon a successful check.
     *
     * @param npcs   The set of NPCs in the game.
     * @param player The player who will be the subject of the interaction.
     * @return {@code true} if an interaction has taken place; {@code false} otherwise.
     */
    boolean triggerInteraction(Set<AbstractNPC> npcs, Player player);

    /**
     * Retrieves the log of messages generated during interactions.
     *
     * @return A {@link List} of {@link String} representing the messages logged during interactions.
     */
    List<String> getMessages();
}
