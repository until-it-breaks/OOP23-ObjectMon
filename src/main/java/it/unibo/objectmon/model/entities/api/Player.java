package it.unibo.objectmon.model.entities.api;

import it.unibo.objectmon.model.item.inventory.api.Inventory;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;

/**
 * Represents a playable entity able to move, battle and have an inventory.
 */
public interface Player extends Trainer {

    /**
     * Attempts to move the player towards a direction.
     * 
     * @param direction The direction to move towards.
     * @param collisionChecker The collision checker that will determine whether the player is able to move through.
     */
    void move(Direction direction, CollisionManager collisionChecker);

    /**
     * Retrieves the player's inventory.
     * 
     * @return The player's inventory.
     */
    Inventory getInventory();
}
