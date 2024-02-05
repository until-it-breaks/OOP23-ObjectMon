package it.unibo.objectmon.api.data.objectmon;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.commons.collections4.list.UnmodifiableList;
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
    /**
     * constructor which has party already stabilished.
     * @param party a undifiableList party with objectmon
     */
    public ObjectmonPartyImpl(final UnmodifiableList<Objectmon> party) {
        this.party = List.copyOf(party);
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

    @Override
    public UnmodifiableList<Objectmon> getParty() {
        return new UnmodifiableList<>(this.party);
    }
}
