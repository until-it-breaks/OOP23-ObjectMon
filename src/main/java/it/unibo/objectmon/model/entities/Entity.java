package it.unibo.objectmon.model.entities;

import it.unibo.objectmon.model.world.Coord;

/**
 * Represents an entity that could be the player or an NPC.
 */
public interface Entity {
    /**
     * @return entity position.
     */
    Coord getPosition();

    /**
     * @return entity's name.
     */
    String getName();
}
