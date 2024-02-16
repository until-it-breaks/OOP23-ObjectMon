package it.unibo.objectmon.model.data.objectmon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
/**
 * test objectmon party.
 */
class TestObjectmonParty {
    private static final int SIZE = 5;
    private final ObjectmonParty objectmonParty;

    /**
     * constructor.
     */
    TestObjectmonParty() {
        objectmonParty = new ObjectmonPartyImpl();
    }

    /**
     * test Objectmon Party.
     */
    @Test
    void testObjectmonParty() {
        final Objectmon obj = ObjectmonFactory.createObjectmon(ObjectmonEnum.GEODUDE, 1);
        final Objectmon src = ObjectmonFactory.createObjectmon(ObjectmonEnum.GOLDEEN, 1);
        final Objectmon dst = ObjectmonFactory.createObjectmon(ObjectmonEnum.MUDKIP, 1);
        //test add and remove
        for (int i = 0; i < SIZE - 1; i++) {
            assertTrue(objectmonParty.add(ObjectmonFactory.createObjectmon(ObjectmonEnum.ANORITH, 1)));
        }
        assertTrue(objectmonParty.add(obj));
        assertTrue(objectmonParty.add(src));
        assertFalse(objectmonParty.add(src));
        assertTrue(objectmonParty.remove(obj));
        assertTrue(objectmonParty.add(dst));
        assertEquals(SIZE + 1, objectmonParty.getParty().size());
        //test switch position
        assertEquals(SIZE, objectmonParty.getParty().indexOf(dst));
        objectmonParty.switchPosition(src, dst);
        assertEquals(SIZE - 1, objectmonParty.getParty().indexOf(dst));
        assertEquals(SIZE, objectmonParty.getParty().indexOf(src));
    }
}
