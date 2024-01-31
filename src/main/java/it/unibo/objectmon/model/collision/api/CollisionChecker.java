package it.unibo.objectmon.model.collision.api;

import it.unibo.objectmon.model.world.Coord;

/**
 * A contract defining operations for checking collisions within a game environment.
 */
public interface CollisionChecker {

    /**
     * Checks if a collision occurs at the specified position within the game environment.
     *
     * @param position the position to check for collision
     * @return {@code true} if a collision occurs at the specified position, {@code false} otherwise
     */
    boolean isCollision(Coord position);

}
