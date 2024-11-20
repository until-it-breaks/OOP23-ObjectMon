package it.unibo.objectmon.model.gamestate.api;

/**
 * Models a game state manager.
 */
public interface GameStateManager {

    /**
     * Retrieves the current game state.
     *
     * @return The current {@link GameState}.
     */
    GameState getGameState();

    /**
     * Updated the current game state.
     *
     * @param gameState The new game state.
     */
    void setGameState(GameState gameState);

    /**
     * Registers a new observer.
     *
     * @param observer The observer to be notified.
     */
    void registerObserver(PlayerObserver observer);

    /**
     * Unregisters an observer.
     *
     * @param observer The observer to be unregistered.
     */
    void unregisterObserver(PlayerObserver observer);

    /**
     * Notifies all the observers.
     */
    void notifyObservers();
}
