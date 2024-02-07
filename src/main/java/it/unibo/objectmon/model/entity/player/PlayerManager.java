package it.unibo.objectmon.model.entity.player;

import java.util.List;

import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.world.Coord;

/**
 * Encapsulates the behavior of a player within the game environment.
 * This class handles player movement and provides access to player information such as position and direction.
 */
public final class PlayerManager {

    private final Model model;
    private final Player player;

    /**
     * Creates a new {@link PlayerManager}.
     * @param model The gameManager that it will be attached to.
     */
    public PlayerManager(final Model model) {
        this.model = model;
        this.player = new PlayerImpl("Player", new Coord(model.getWorld().getStartingPosition().x(),
        model.getWorld().getStartingPosition().y()), List.of());
    }

    /**
     * Moves up.
     */
    public void moveUp() {
        final Coord nextPosition = new Coord(getPosition().x(), getPosition().y() - 1);
        if (this.model.getCollisionChecker().isCollision(nextPosition)) {
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
        if (this.model.getCollisionChecker().isCollision(nextPosition)) {
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
        if (this.model.getCollisionChecker().isCollision(nextPosition)) {
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
        if (this.model.getCollisionChecker().isCollision(nextPosition)) {
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
    public ObjectmonParty getObjectmonParty() {
        return this.player.getObjectmonParty();
    }
}
