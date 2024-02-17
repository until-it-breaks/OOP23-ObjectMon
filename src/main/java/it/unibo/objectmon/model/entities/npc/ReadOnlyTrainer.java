package it.unibo.objectmon.model.entities.npc;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.objectmon.ObjectmonPartyReadOnly;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import it.unibo.objectmon.model.world.api.Coord;
/**
 * read only: Models an NPC capable of battling.
 */
public final class ReadOnlyTrainer extends AbstractNPC implements Trainer {
    private final Trainer trainer;

    /**
     * constructs with a given trainer.
     * @param trainer the trainer to be wrapped
     */
    public ReadOnlyTrainer(final Trainer trainer) {
        this(trainer.getName(), trainer.getPosition(), trainer);
    }

    /**
     * super constructor.
     * @param name name of trainer.
     * @param coord coord of trainer.
     * @param trainer existing trainer.
     */
    public ReadOnlyTrainer(final String name, final Coord coord, final Trainer trainer) {
        super(name, coord);
        this.trainer = trainer;
    }

    @Override
    public boolean isDefeated() {
        return this.trainer.isDefeated();
    }

    @Override
    public ObjectmonParty getObjectmonParty() {
        return new ObjectmonPartyReadOnly(this.trainer.getObjectmonParty());
    }

    @Override
    public void handleInteraction(final Player player, final InteractionLogger logger) {
        throw new UnsupportedOperationException("this is read only class, cannot execute this method");
    }
}
