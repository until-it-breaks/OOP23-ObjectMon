package it.unibo.objectmon.model.misc.collision.api;

import it.unibo.objectmon.model.world.api.Coord;

/**
 * Models a manager that checks collisions within a game environment.
 */
public interface CollisionManager {

    /**
     * Checks if a collision occurs at the specified position within the game environment.
     *
     * @param position The position to check for collision
     * @return {@code true} if a collision occurs at the specified position, {@code false} otherwise
     */
    boolean isCollision(Coord position);

}
