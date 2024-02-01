package it.unibo.objectmon.model.battle.impl;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * a simple objecmon party.
 */
public final class ObjectmonPartyImpl implements ObjectmonParty {
    private static final int MAX_SIZE = 6;
    private final List<Objectmon> party;
    /**
     * constructor of Objectmon party.
     */
    public ObjectmonPartyImpl() {
        this.party = new ArrayList<>();
    }
    @Override
    public boolean add(final Objectmon objectmon) {
        if (this.party.size() < ObjectmonPartyImpl.MAX_SIZE) {
           this.party.add(objectmon);
        }
        return false; 
    }

    @Override
    public boolean remove(final Objectmon objectmon) {
        return this.party.remove(objectmon);
    }

    @Override
    public void switchPosition(final Objectmon objectmon1, final Objectmon objectmon2) {
        if (!party.contains(objectmon2) || !party.contains(objectmon1)) {
            throw new NoSuchElementException();
        }
        Collections.swap(party, party.indexOf(objectmon2), party.indexOf(objectmon1));
    }
}
