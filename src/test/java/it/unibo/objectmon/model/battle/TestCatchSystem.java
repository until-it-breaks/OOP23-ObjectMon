package it.unibo.objectmon.model.battle;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.battle.catchsystem.CatchSystem;
import it.unibo.objectmon.model.battle.catchsystem.CatchSystemImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Test catch system.
 */
class TestCatchSystem {
    private final Objectmon obj;
    /**
     * constructor.
     */
    TestCatchSystem() {
        obj = ObjectmonFactory.createObjectmon(ObjectmonEnum.ANORITH, 0);
    }
    /**
     * make sure that in extreme case it will work correctly.
     */
    @Test
    void testCatch() {
        final CatchSystem catchSystem = new CatchSystemImpl();
        assertFalse(catchSystem.isCaught(1, obj));
        obj.setCurrentHp(-obj.getCurrentHp() + 1);
        assertTrue(catchSystem.isCaught(1, obj));
    }
}
