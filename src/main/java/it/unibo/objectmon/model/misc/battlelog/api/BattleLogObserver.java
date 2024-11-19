package it.unibo.objectmon.model.misc.battlelog.api;

/**
 * Battle log observer interface.
 */
public interface BattleLogObserver {
    /**
     * A method called when the battle logger updates the log with a new message.
     * 
     * @param logEntry The message to be added to the battle log.
     */
    void update(String logEntry);
}
