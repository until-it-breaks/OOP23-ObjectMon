package it.unibo.objectmon.model.misc.eventlog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.misc.eventlog.api.EventLogger;

/**
 * Unit tests for the {@link EventLoggerImpl} class.
 * These tests cover various aspects of the EventLogger functionality.
 */
class EventLoggerTest {

    private EventLogger logger;

    @BeforeEach
    void init() {
        logger = new EventLoggerImpl();
    }

    @Test
    void testEmptyLogger() {
        logger.clear();
        assertEquals(List.of(), logger.getMessages());
    }

    @Test
    void testLoggerCapacity() {
        logger.log("test1");
        logger.log("test2");
        logger.log("test3");
        logger.log("test4");
        logger.log("test5");
        assertEquals(EventLoggerImpl.LIMIT, logger.getMessages().size());
    }

    @Test
    void testLoggerOrder() {
        logger.log("test11");
        logger.log("test22");
        logger.log("test33");
        logger.log("test44");
        logger.log("test55");
        assertEquals(List.of("test22", "test33", "test44", "test55"), logger.getMessages());
        logger.log("test66");
        assertEquals(List.of("test33", "test44", "test55", "test66"), logger.getMessages());
    }
}
