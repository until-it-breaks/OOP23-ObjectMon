package it.unibo.objectmon.model.world;

/**
 * A basic representation of a two dimensional coordinate.
 * @param x The x coordinate.
 * @param y The y coordinate.
 */
public record Coord(int x, int y) {

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Coord) {
            final Coord other = (Coord) obj;
            return x == other.x && y == other.y;
        }
        return false;
    }
}
