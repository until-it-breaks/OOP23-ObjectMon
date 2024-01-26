package it.unibo.objectmon.model.entity.player;

import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.EntityImpl;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.world.Coord;

/**
 * This will be the implementation of {@link Player}.
 */
public final class PlayerImpl extends EntityImpl implements Player {
    /**
     * Creates a player.
     * @param name the name of the player.
     * @param coord the starting position of the player.
     */
    public PlayerImpl(final String name, final Coord coord) {
        super(name, coord);
    }
    @Override
    public void moveUp() {
        super.setPosition(new Coord(super.getPosition().x() - 1, super.getPosition().y()));
        this.setDirection(Direction.UP);
    }
    @Override
    public void moveDown() {
        super.setPosition(new Coord(super.getPosition().x() + 1, super.getPosition().y()));
        this.setDirection(Direction.DOWN);
    }
    @Override
    public void moveLeft() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() - 1));
        this.setDirection(Direction.LEFT);
    }
    @Override
    public void moveRight() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() + 1));
        this.setDirection(Direction.RIGHT);
    }
}
