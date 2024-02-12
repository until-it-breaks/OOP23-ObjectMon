package it.unibo.objectmon.model.misc.battlelog.api;

import java.util.List;
import java.util.ArrayList;

/**
 * Class representing a battle logger to store information related to the battle.
 */
public class BattleLogger {
    private final List<BattleLogObserver> observers;

    /**
     * Constructor to create a new battle logger.
     */
    public BattleLogger() {
        this.observers = new ArrayList<>();
    }

    /**
     * Adds an observer to the battle logger.
     * @param observer The observer to add.
     */
    public void addObserver(final BattleLogObserver observer) {
        this.observers.add(observer);
    }

    /**
     * Records a new message in the battle log and notifies the observers.
     * @param message The message to add to the battle log.
     */
    public void log(final String message) {
        notifyObservers(message);
    }

    private void notifyObservers(final String message) {
        this.observers.stream().forEach(o -> o.update(message));
    }
}
