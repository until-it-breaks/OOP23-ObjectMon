package it.unibo.objectmon.model.entity;

import java.util.Collections;
import java.util.List;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.GameManager;
import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.world.Coord;

/**
 * Encapsulates the behavior of a player within the game environment.
 * This class handles player movement and provides access to player information such as position and direction.
 */
public final class PlayerManager {

    private final GameManager gameManager;
    private final Player player;

    /**
     * Creates a new {@link PlayerManager}.
     * @param gameManager
     */
    public PlayerManager(final GameManager gameManager) {
        this.gameManager = gameManager;
        this.player = new PlayerImpl("Player1", new Coord(0, 0), List.of());
    }

    /**
     * Moves up.
     */
    public void moveUp() {
        final Coord nextPosition = new Coord(getPosition().x(), getPosition().y() - 1);
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.UP);
        } else {
            this.player.moveUp();
        }
    }

    /**
     * Moves down.
     */
    public void moveDown() {
        final Coord nextPosition = new Coord(getPosition().x(), getPosition().y() + 1);
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.DOWN);
        } else {
            this.player.moveDown();
        }
    }
    /**
     * Moves left.
     */
    public void moveLeft() {
        final Coord nextPosition = new Coord(getPosition().x() - 1, getPosition().y());
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.LEFT);
        } else {
            this.player.moveLeft();
        }
    }

    /**
     * Moves right.
     */
    public void moveRight() {
        final Coord nextPosition = new Coord(getPosition().x() + 1, getPosition().y());
        if (this.gameManager.getCollisionManager().isCollision(nextPosition)) {
            this.player.setDirection(Direction.RIGHT);
        } else {
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

    /**
     * 
     * @param isDefeated the defeat status to be set.
     */
    public void setDefeated(final boolean isDefeated) {
        this.player.setDefeated(isDefeated);
    }

    /**
     * 
     * @return the player defeat status.
     */
    public boolean isDefeated() {
        return player.isDefeated();
    }

    /**
     * 
     * @return the player's team.
     */
    public List<Objectmon> getTeam() {
        return Collections.unmodifiableList(player.getTeam());
    }
}
