package it.unibo.objectmon.model.data.objectmon;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * A simple objectmon party.
 */
public final class ObjectmonPartyImpl implements ObjectmonParty {
    private static final int MAX_PARTY_SIZE = 6;
    private final List<Objectmon> party;

    /**
     * Constructor of Objectmon party.
     */
    public ObjectmonPartyImpl() {
        this.party = new ArrayList<>();
    }

    /**
     * Constructor which has party already stabilished.
     * 
     * @param party The list of Objectmons to be used.
     */
    public ObjectmonPartyImpl(final List<Objectmon> party) {
        this.party = new ArrayList<>(party);
    }

    @Override
    public boolean add(final Objectmon objectmon) {
        if (this.party.size() < ObjectmonPartyImpl.MAX_PARTY_SIZE) {
           this.party.add(objectmon);
           return true;
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
    public List<Objectmon> getParty() {
        return Collections.unmodifiableList(this.party);
    }
}
