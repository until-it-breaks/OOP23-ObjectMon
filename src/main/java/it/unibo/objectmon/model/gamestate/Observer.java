package it.unibo.objectmon.model.gamestate;

/**
 * A basic observer interface.
 */
public interface Observer {

    /**
     * The reaction of the notified object.
     */
    void update();
}
