package it.unibo.objectmon.model.gamestate;

/**
 * A basic observer interface.
 */
public interface Observer {

    /**
     * Reaction of the notified object.
     */
    void update();
}
