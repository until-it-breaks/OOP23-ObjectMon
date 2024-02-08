package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.entity.api.npc.Trainer;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;

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
    void move(Direction direction, CollisionChecker collisionChecker);
}
