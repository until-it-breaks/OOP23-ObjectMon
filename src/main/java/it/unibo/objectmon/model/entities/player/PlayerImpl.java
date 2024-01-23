package it.unibo.objectmon.model.entities.player;

import it.unibo.objectmon.model.entities.EntityImpl;
import it.unibo.objectmon.model.world.Coord;

/**
 * This will be the implementation of {@link Player}.
 */
public final class PlayerImpl extends EntityImpl implements Player {

    public PlayerImpl(String name, Coord coord) {
        super(name, coord);
    }
    @Override
    public void moveUp() {
        super.setPosition(new Coord(super.getPosition().x() - 1, super.getPosition().y()));
    }
    @Override
    public void moveDown() {
        super.setPosition(new Coord(super.getPosition().x() + 1, super.getPosition().y()));
    }
    @Override
    public void moveLeft() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() - 1));
    }
    @Override
    public void moveRight() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() + 1));
    }
    @Override
    public boolean interact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }
}
