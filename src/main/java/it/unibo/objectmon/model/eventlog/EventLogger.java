package it.unibo.objectmon.model.eventlog;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.concurrent.ArrayBlockingQueue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * A singleton that represents a class able to log messages and return a number of them on demand.
 */
public final class EventLogger {
    private static final EventLogger LOGGER = new EventLogger();
    private final Queue<String> events;
    public static final int LIMIT = 4;

    private EventLogger() {
        this.events = new ArrayBlockingQueue<>(LIMIT);
    }

    /**
     * Returns the only instance of {@link EventLogger}.
     * @return The instance of {@link EventLogger}.
     */
    public static EventLogger getLogger() {
        return LOGGER;
    }

    /**
     * Logs a {@link String} into a {@link Queue}, if the number of strings logged exceed 4 the first one logged is removed.
     * @param string The string to be logged into the {@link Queue}.
     */
    @SuppressFBWarnings(value = "RV_RETURN_VALUE_IGNORED", 
    justification = "Ignoring return value as it is not needed for this specific use case")
    public void log(final String string) {
        if (events.size() >= LIMIT) {
            this.events.poll();
        }
        this.events.add(string);

    }
    /**
     * Returns a list-like representation of the latest {@link EventLogger#LIMIT} strings logged.
     * @return An unmodifiable list of string.
     */
    public List<String> getMessages() {
        return events.stream().collect(Collectors.toUnmodifiableList());
    }
}
