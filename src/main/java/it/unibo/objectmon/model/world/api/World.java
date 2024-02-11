package it.unibo.objectmon.model.world.api;

import java.util.Map;

import it.unibo.objectmon.model.world.Tile;

/**
 * An interface modelling the concept of world.
 */
public interface World {

    /**
     * Retrieves an immutable mapping of coordinates to tiles, representing the game world.
     * 
     * @return An immutable map of coordinates to tiles.
     */
    Map<Coord, Tile> getMap();

    /**
     * Retrieves the width of the game world grid.
     * 
     * @return The width of the game world.
     */
    int getWidth();

    /**
     * Retrieves the height of the game world grid.
     * 
     * @return The height of the game world.
     */
    int getHeight();

    /**
     * Retrives the starting position of the player.
     * 
     * @return A coord representing the starting position of the player.
     */
    Coord getStartingPosition();
}
