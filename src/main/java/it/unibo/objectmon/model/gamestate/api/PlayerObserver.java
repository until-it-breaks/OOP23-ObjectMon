package it.unibo.objectmon.model.gamestate.api;

/**
 * A basic observer interface.
 */
public interface PlayerObserver {

    /**
     * Reaction of the notified object.
     */
    void update();
}
