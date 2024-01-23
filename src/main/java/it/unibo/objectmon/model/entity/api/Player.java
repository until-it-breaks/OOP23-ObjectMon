package it.unibo.objectmon.model.entity.api;

/**
 * Represents a player with basic movement functions.
 */
public interface Player {
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
    
    void interact();
}
