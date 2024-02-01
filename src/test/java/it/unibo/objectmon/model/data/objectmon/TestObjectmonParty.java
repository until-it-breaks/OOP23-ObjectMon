package it.unibo.objectmon.model.data.objectmon;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.battle.impl.ObjectmonParty;
import it.unibo.objectmon.model.battle.impl.ObjectmonPartyImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
/**
 * test of objectmon party
 */
class TestObjectmonParty {
    private ObjectmonParty party;

	public void init() {
		party = new ObjectmonPartyImpl();
	}
    /**
     * test add Method
     */
    @Test
    public void testAdd() {
        Objectmon pikatchu = new ObjectmonImpl(0, "p", null, null, null, 0);
        Objectmon alfa = new ObjectmonImpl(1, "a", null, null, null, 0);
        Objectmon beta = new ObjectmonImpl(2, "b", null, null, null, 0);
        Objectmon gamma = new ObjectmonImpl(3, "g", null, null, null, 0);
        Objectmon delta = new ObjectmonImpl(4, "d", null, null, null, 0);
        Objectmon yipsilon = new ObjectmonImpl(5, "yi", null, null, null, 0);
        Objectmon yota = new ObjectmonImpl(6, "yo", null, null, null, 0);
        assertTrue(party.add(pikatchu));
        assertFalse(party.add(pikatchu));
        assertTrue(party.add(alfa));
        assertTrue(party.add(beta));
        assertTrue(party.add(gamma));
        assertTrue(party.add(delta));
        assertTrue(party.add(yipsilon));
        assertFalse(party.add(yota));
    }
    /**
     * test remove pokemon from party
     */
    @Test
    public void testRemoveObjecmon() {
        assertTrue(party.remove(new ObjectmonImpl(0, "p", null, null, null, 0)));
        assertFalse(party.remove(new ObjectmonImpl(8, "aaa", null, null, null, 0)));
    }
    /**
     * test switch position
     */
    @Test
    public void testSwitchPosition() {
        
    }
}
