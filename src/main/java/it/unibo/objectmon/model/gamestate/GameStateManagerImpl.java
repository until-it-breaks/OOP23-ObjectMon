package it.unibo.objectmon.model.gamestate;

import java.util.ArrayList;
import java.util.List;

import it.unibo.objectmon.model.gamestate.api.GameState;
import it.unibo.objectmon.model.gamestate.api.GameStateManager;
import it.unibo.objectmon.model.gamestate.api.PlayerObserver;

/**
 * A class responsible for managing the game state.
 */
public final class GameStateManagerImpl implements GameStateManager {

    private GameState gameState;
    private final List<PlayerObserver> observers;

    /**
     * Creates a new game state manager.
     */
    public GameStateManagerImpl() {
        this.gameState = GameState.NONE;
        this.observers = new ArrayList<>();
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public void setGameState(final GameState gameState) {
        if (this.gameState != gameState) {
            this.gameState = gameState;
            notifyObservers();
        }
    }

    @Override
    public void registerObserver(final PlayerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(final PlayerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (final PlayerObserver observer : observers) {
            observer.update();
        }
    }
}
