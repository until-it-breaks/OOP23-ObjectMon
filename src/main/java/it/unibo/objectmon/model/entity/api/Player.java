package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.entity.api.npc.Trainer;

/**
 * Represents a player with basic movement functions.
 */
public interface Player extends Entity, Trainer {

    /**
     * Moves the player up.
     */
    void moveUp();

    /**
     * Moves the player down.
     */
    void moveDown();

    /**
     * Moves the player left.
     */
    void moveLeft();

    /**
     * Moves the player right.
     */
    void moveRight();
}
