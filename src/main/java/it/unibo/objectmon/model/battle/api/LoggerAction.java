package it.unibo.objectmon.model.battle.api;
/**
 * a functional interface which to log the BattleLogger.
 */
public interface LoggerAction {
    /**
     * log message to another log.
     * @param message to be sent.
     */
    void log(String message);
}
