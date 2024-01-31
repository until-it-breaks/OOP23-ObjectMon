package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.world.Coord;

/**
 * Represents an entity that could be the player or an NPC.
 */
public interface Entity {

    /**
     * Sets the entity's position.
     * @param coord the next position.
     */
    void setPosition(Coord coord);

    /**
     * @return the entity's current position.
     */
    Coord getPosition();

    /**
     * @return the entity's name.
     */
    String getName();

    /**
     * @return the direction the entity is currently facing at.
     */
    Direction getDirection();

    /**
     * Sets the position the entity is facing towards.
     * @param direction the next direction towards which the entity is facing at.
     */
    void setDirection(Direction direction);
}
