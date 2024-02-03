package it.unibo.objectmon.model.eventlog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class EventLoggerTest {

    @Test
    void testLoggerCapacity() {
        EventLogger.getLogger().log("test1");
        EventLogger.getLogger().log("test2");
        EventLogger.getLogger().log("test3");
        EventLogger.getLogger().log("test4");
        EventLogger.getLogger().log("test5");
        assertEquals(EventLogger.LIMIT, EventLogger.getLogger().getMessages().size());
    }

    @Test
    void testEmptyLogger() {
        assertEquals(0, EventLogger.getLogger().getMessages().size());
        assertEquals(List.of(), EventLogger.getLogger().getMessages());
    }

    @Test
    void testLoggerOrder() {
        EventLogger.getLogger().log("test1");
        EventLogger.getLogger().log("test2");
        EventLogger.getLogger().log("test3");
        EventLogger.getLogger().log("test4");
        EventLogger.getLogger().log("test5");
        assertEquals(List.of("test2", "test3", "test4", "test5"), EventLogger.getLogger().getMessages());
        EventLogger.getLogger().log("test6");
        assertEquals(List.of("test3", "test4", "test5", "test6"), EventLogger.getLogger().getMessages());
    }
}
