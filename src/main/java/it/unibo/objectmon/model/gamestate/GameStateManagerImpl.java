package it.unibo.objectmon.model.gamestate;

import java.util.ArrayList;
import java.util.List;

/**
 * A class responsible for managing the game state.
 */
public final class GameStateManagerImpl implements GameStateManager {

    private GameState gameState;
    private final List<Observer> observers;

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
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(final Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update();
        }
    }
}
