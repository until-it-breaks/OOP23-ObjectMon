package it.unibo.objectmon.model.entities.api;

import it.unibo.objectmon.model.world.api.Coord;

/**
 * Represents an entity in the game, that is, something that has name, position and direction.
 */
public interface Entity {

    /**
     * Sets the entity's position.
     * 
     * @param coord The next position.
     */
    void setPosition(Coord coord);

    /**
     * Returns the current entity position.
     * 
     * @return The entity's current position.
     */
    Coord getPosition();

    /**
     * Retrieves the entity's name.
     * 
     * @return The entity's name.
     */
    String getName();

    /**
     * Retrieves the direction the entity is facing.
     * 
     * @return The direction the entity is currently facing at.
     */
    Direction getDirection();

    /**
     * Sets the position the entity is facing towards.
     * 
     * @param direction The next direction towards which the entity will face at.
     */
    void setDirection(Direction direction);
}
