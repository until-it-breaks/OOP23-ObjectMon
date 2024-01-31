package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.world.Coord;

/**
 * A basic implementation of a game entity.
 */
public class EntityImpl implements Entity {

    private final String name;
    private Coord position;
    private Direction facingDirection;

    /**
     * Builds a simple entity.
     * @param name the name of the entity.
     * @param coord the starting position of the entity.
     */
    public EntityImpl(final String name, final Coord coord) {
        this.name = name;
        this.position = coord;
        this.facingDirection = Direction.DOWN;
    }

    @Override
    public final void setPosition(final Coord coord) {
        this.position = coord;
    }

    @Override
    public final Coord getPosition() {
        return this.position;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final Direction getDirection() {
        return facingDirection;
    }

    @Override
    public final void setDirection(final Direction facingDirection) {
        this.facingDirection = facingDirection;
    }
}
