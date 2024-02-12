package it.unibo.objectmon.model.misc.battlelog.api;
/**
 * Interface defining the behavior of a battle logger observer.
 */
public interface BattleLogObserver {
    /**
     * Method called when the battle logger updates the log with a new message.
     * @param logEntry The new message added to the battle log.
     */
    void update(String logEntry);
}
