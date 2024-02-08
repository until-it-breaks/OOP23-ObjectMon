package it.unibo.objectmon.model.eventlog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.misc.eventlog.EventLogger;

/**
 * Unit tests for the {@link EventLogger} class.
 * These tests cover various aspects of the EventLogger functionality.
 */
class EventLoggerTest {

    @BeforeEach
    void setUp() {
        EventLogger.getLogger().clear();
    }

    @Test
    void testEmptyLogger() {
        EventLogger.getLogger().clear();
        assertEquals(List.of(), EventLogger.getLogger().getMessages());
    }

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
    void testLoggerOrder() {
        EventLogger.getLogger().log("test11");
        EventLogger.getLogger().log("test22");
        EventLogger.getLogger().log("test33");
        EventLogger.getLogger().log("test44");
        EventLogger.getLogger().log("test55");
        assertEquals(List.of("test22", "test33", "test44", "test55"), EventLogger.getLogger().getMessages());
        EventLogger.getLogger().log("test66");
        assertEquals(List.of("test33", "test44", "test55", "test66"), EventLogger.getLogger().getMessages());
    }
}
