package it.unibo.objectmon.model.misc.eventlog.api;

import java.util.List;

/**
 * A general purpose event logger.
 */
public interface InteractionLogger {

    /**
     * Stores a message.
     * @param string The message to be stored.
     */
    void log(String string);

    /**
     * Clears the current logged messages.
     */
    void clear();

    /**
     * Returns a list-like representation of the latest strings logged.
     * @return An unmodifiable list of string.
     */
    List<String> getMessages();
}
