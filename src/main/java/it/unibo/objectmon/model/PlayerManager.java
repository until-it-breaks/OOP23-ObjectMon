package it.unibo.objectmon.model;

import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.world.Coord;
/**
 * Encapsulates the concept of "Player".
 */
public final class PlayerManager {
    private final Player player;
    /**
     * Creates a new player.
     */
    public PlayerManager() {
        this.player = new PlayerImpl("player1", new Coord(1, 1));
    }
    /**
     * Moves up.
     */
    public void moveUp() {
        player.moveUp();
    }
    /**
     * Moves down.
     */
    public void moveDown() {
        player.moveDown();
    }
    /**
     * Moves left.
     */
    public void moveLeft() {
        player.moveLeft();
    }
    /**
     * 
     * @return the player position.
     */
    public Coord getPosition() {
        return player.getPosition();
    }
    /**
     * Moves right.
     */
    public void moveRight() {
        player.moveRight();
    }
    /**
     * 
     * @return the player name.
     */
    public String getName() {
        return player.getName();
    }
    /**
     * 
     * @return the player direction.
     */
    public Direction getDirection() {
        return player.getDirection();
    }
}
