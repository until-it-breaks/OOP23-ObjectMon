package it.unibo.objectmon.model;

import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.world.Coord;
/**
 * Encapsulates the concept of "Player".
 */
public final class PlayerController {
    private GameManager gameManager;
    private final Player player;

    /**
     * Creates a new player.
     */
    public PlayerController(final GameManager gameManager) {
        this.gameManager = gameManager;
        this.player = new PlayerImpl("player1", new Coord(0, 0));
    }

    /**
     * Moves up.
     */
    public void moveUp() {
        Coord nextPosition = new Coord(getPosition().x(), getPosition().y() - 1);
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.UP);
        } else {
            this.player.setDirection(Direction.UP);
            this.player.moveUp();
        }
    }

    /**
     * Moves down.
     */
    public void moveDown() {
        Coord nextPosition = new Coord(getPosition().x(), getPosition().y() + 1);
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.DOWN);
        } else {
            this.player.setDirection(Direction.DOWN);
            this.player.moveDown();
        }
    }
    /**
     * Moves left.
     */
    public void moveLeft() {
        Coord nextPosition = new Coord(getPosition().x() - 1, getPosition().y());
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.LEFT);
        } else {
            this.player.setDirection(Direction.LEFT);
            this.player.moveLeft();
        }
    }

    /**
     * Moves right.
     */
    public void moveRight() {
        Coord nextPosition = new Coord(getPosition().x() + 1, getPosition().y());
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.RIGHT);
        } else {
            this.player.setDirection(Direction.RIGHT);
            this.player.moveRight();
        }
    }
    
    /**
     * 
     * @return the player position.
     */
    public Coord getPosition() {
        return player.getPosition();
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
