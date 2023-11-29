package it.unibo.objectmon.api;

public interface Entity {
    /**
     * @return entity x position
     */
    int getX();
    /**
     * @return entity y position
     */
    int getY();

    /**
     * @return entity's name
     */
    String getName();
}
