package it.unibo.objectmon.model.entities;

import it.unibo.objectmon.model.world.Coord;

/**
 * This will be the implementation of {@link Player}.
 */
public final class PlayerImpl implements Player {
    private final String name;
    private Coord position;
    /**
     * Builds a basic player character.
     * 
     * @param name the player's name
     * @param x the player's x position
     * @param y the player's y position
     */
    public PlayerImpl(final String name, final int x, final int y) {
        this.name = name;
        this.position = new Coord(x, y);
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
    public void moveUp() {
        this.position = new Coord(this.position.x(), this.position.y() + 1);
    }
    @Override
    public void moveDown() {
        this.position = new Coord(this.position.x(), this.position.y() - 1);
    }
    @Override
    public void moveLeft() {
        this.position = new Coord(this.position.x() - 1, this.position.y());
    }
    @Override
    public void moveRight() {
        this.position = new Coord(this.position.x() + 1, this.position.y());
    }


}
