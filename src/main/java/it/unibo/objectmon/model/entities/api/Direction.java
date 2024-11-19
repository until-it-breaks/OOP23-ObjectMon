package it.unibo.objectmon.model.entities.api;

/**
 * Enum representing direction an entity can be facing.
 */
public enum Direction {

    /**
     * Represents upward direction.
     */
    UP(0, -1),

    /**
     * Represent eastward direction.
     */
    LEFT(-1, 0),

    /**
     * Represents downward direction.
     */
    DOWN(0, 1),

    /**
     * Represents westward direction.
     */
    RIGHT(1, 0);

    private final int x;
    private final int y;

    Direction(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the x offset of the direction.
     * 
     * @return An int representing the x offset.
     */
    public int getX() {
        return x;
    }

    /**
     * Retrieves the y offset of the direction.
     * 
     * @return An int representing the y offset.
     */
    public int getY() {
        return y;
    }
}
