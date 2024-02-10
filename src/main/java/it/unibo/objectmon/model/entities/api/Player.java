package it.unibo.objectmon.model.entities.api;

import it.unibo.objectmon.model.entities.api.npc.Trainer;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;

/**
 * Represents a playable entity able to move.
 */
public interface Player extends Entity, Trainer {

    /**
     * Attempts to move the player towards a certain direction.
     * 
     * @param direction the direction to move towards.
     * @param collisionChecker the collision checker that will determine whether the player is able to move.
     */
    void move(Direction direction, CollisionManager collisionChecker);
}
