package it.unibo.objectmon.model.misc.eventlog;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Models a logger able to log messages and return a number of them on demand.
 */
public final class InteractionLoggerImpl implements InteractionLogger {

    /**
     * The maximum amount of messages the logger can hold.
     */
    public static final int LIMIT = 4;
    private final Queue<String> messages;

    /**
     * Constructs a logger with limits.
     */
    public InteractionLoggerImpl() {
        this.messages = new ArrayBlockingQueue<>(LIMIT);
    }

    @Override
    @SuppressFBWarnings(value = "RV_RETURN_VALUE_IGNORED", 
    justification = "Ignoring return value as it is not needed for this specific use case")
    public void log(final String string) {
        if (messages.size() >= LIMIT) {
            this.messages.poll();
        }
        this.messages.add(string);
    }

    @Override
    public void clear() {
        this.messages.clear();
    }

    @Override
    public List<String> getMessages() {
        return messages.stream().collect(Collectors.toUnmodifiableList());
    }
}
