package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.world.Coord;

public class EntityImpl implements Entity {

    private final String name;
    private Coord position;
    private Direction facingDirection;
    /**
     * Builds a basic player character.
     * 
     * @param name the player's name
     * @param x the player's x position
     * @param y the player's y position
     */
    public EntityImpl(final String name, final Coord coord) {
        this.name = name;
        this.position = coord;
        this.facingDirection = Direction.DOWN;
    }
    @Override
    public void setPosition(final Coord coord) {
        this.position = coord;
    }
    @Override
    public Coord getPosition() {
        return this.position;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public Direction getFacingDirection() {
        return facingDirection;
    }
    @Override
    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }
}