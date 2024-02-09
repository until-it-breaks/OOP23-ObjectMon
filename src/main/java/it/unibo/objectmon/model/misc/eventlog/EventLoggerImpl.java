package it.unibo.objectmon.model.misc.eventlog;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.misc.eventlog.api.EventLogger;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * A singleton that represents a class able to log messages and return a number of them on demand.
 */
public final class EventLoggerImpl implements EventLogger {

    /**
     * The maximum amount of messages the logger can hold.
     */
    public static final int LIMIT = 4;
    private final Queue<String> events;

    /**
     * Constructs a logger with limits.
     */
    public EventLoggerImpl() {
        this.events = new ArrayBlockingQueue<>(LIMIT);
    }

    @Override
    @SuppressFBWarnings(value = "RV_RETURN_VALUE_IGNORED", 
    justification = "Ignoring return value as it is not needed for this specific use case")
    public void log(final String string) {
        if (events.size() >= LIMIT) {
            this.events.poll();
        }
        this.events.add(string);
    }

    @Override
    public void clear() {
        this.events.clear();
    }

    @Override
    public List<String> getMessages() {
        return events.stream().collect(Collectors.toUnmodifiableList());
    }
}
