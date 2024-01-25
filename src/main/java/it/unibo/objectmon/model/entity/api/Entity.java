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
}
