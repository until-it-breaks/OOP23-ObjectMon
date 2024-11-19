package it.unibo.objectmon.model.misc.battlelog.api;

import java.util.List;
import java.util.ArrayList;

/**
 * A battle logger used to store information related to battles.
 */
public class BattleLogger {
    private final List<BattleLogObserver> observers;

    /**
     * Creates a new battle logger.
     */
    public BattleLogger() {
        this.observers = new ArrayList<>();
    }

    /**
     * Adds an observer to the battle logger.
     * 
     * @param observer The observer to be added.
     */
    public void addObserver(final BattleLogObserver observer) {
        this.observers.add(observer);
    }

    /**
     * Adds a new message in the battle log and notifies the observers.
     * 
     * @param message The message to be added to the battle log.
     */
    public void log(final String message) {
        notifyObservers(message + "\n");
    }

    private void notifyObservers(final String message) {
        this.observers.stream().forEach(o -> o.update(message));
    }
}
