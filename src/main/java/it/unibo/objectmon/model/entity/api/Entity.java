package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.world.Coord;
/**
 * Represents an entity that could be the player or an NPC.
 */
public interface Entity {
    /**
     * Sets the entity position.
     */
    void setPosition(final Coord coord);
    /**
     * @return entity position.
     */
    Coord getPosition();
    /**
     * @return entity's name.
     */
    String getName();
    /**
     * 
     * @return the direction the entity is facing.
     */
    Direction getFacingDirection();
    /**
     * 
     * @param facingDirection the direction towards which the entity is looking.
     */
    void setFacingDirection(Direction facingDirection);
}
