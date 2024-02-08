package it.unibo.objectmon.model.data.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.data.api.aspect.Aspect;

/**
 * Test of Aspects.
 */
class TestAspect {
    /**
     * Test of all aspects.
     */
    @Test
    void testAllAspects() {
        Aspect aspect;
        for (final Aspect singleAspect : Aspect.values()) {
            aspect = singleAspect;
            assertEquals(singleAspect.getAspectName(), aspect.getAspectName());
            assertEquals(singleAspect.getAspectId(), aspect.getAspectId());
        }
        aspect = Aspect.NORMAL;
        assertTrue(aspect.sameAspect(List.of(Aspect.NORMAL)));
        assertFalse(aspect.sameAspect(List.of(Aspect.FIRE)));
    }
}
