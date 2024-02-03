package it.unibo.objectmon.model.eventlog;

import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class EventLogger {
    private final Queue<String> events;
    private static final int LIMIT = 4;

    public EventLogger() {
        this.events = new ArrayDeque<>();
    }

    public void log(String string) {
        this.events.add(string);
        if (events.size() > LIMIT) {
            this.events.poll();
        }
    }

    public List<String> getContent() {
        return events.stream().collect(Collectors.toUnmodifiableList());
    }
}
