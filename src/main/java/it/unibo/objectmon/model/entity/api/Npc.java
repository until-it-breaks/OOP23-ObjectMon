package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.PlayerController;

/**
 * Models an NPC special characteristics.
 */
public interface Npc extends Entity {
    /**
     * Handles the interaction between player and npc.
     * @param player the that the npc will interact with.
     */
    void handleInteraction(PlayerController player);
    /**
     * @return the npc type.
     */
    NpcType getNpcType();
}
