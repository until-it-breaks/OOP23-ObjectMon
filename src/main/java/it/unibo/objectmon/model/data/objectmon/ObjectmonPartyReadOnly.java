package it.unibo.objectmon.model.data.objectmon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * A {@link ObjectmonParty} wrapper that only expose getters.
 */
@SuppressFBWarnings(
    value = "EI_EXPOSE_REP2", 
    justification = "It is designed to provide read-only access to ObjectmonParty information"
                    + "ensuring that the ObjectmonParty's state remains immutable."
)
public final class ObjectmonPartyReadOnly implements ObjectmonParty {

    private final ObjectmonParty objectmonParty;

    /**
     * The {@link ObjectmonParty} to be made read-only.
     * 
     * @param objectmonParty The objectmon party to be wrapped.
     */
    public ObjectmonPartyReadOnly(final ObjectmonParty objectmonParty) {
        this.objectmonParty = objectmonParty;
    }

    @Override
    public boolean add(final Objectmon objectmon) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean remove(final Objectmon objectmon) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void switchPosition(final Objectmon objectmon1, final Objectmon objectmon2) {
        throw new UnsupportedOperationException("Unimplemented method 'switchPosition'");
    }

    @Override
    public List<Objectmon> getParty() {
        final List<Objectmon> readOnlyParty = new ArrayList<>();
        for (final Objectmon objectmon : objectmonParty.getParty()) {
            readOnlyParty.add(new ObjectmonReadOnly(objectmon));
        }
        return Collections.unmodifiableList(readOnlyParty);
    }
}
