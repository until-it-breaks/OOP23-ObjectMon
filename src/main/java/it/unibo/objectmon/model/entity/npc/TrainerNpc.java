package it.unibo.objectmon.model.entity.npc;

import java.util.List;
import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.objectmon.ObjectmonParty;
import it.unibo.objectmon.api.data.objectmon.ObjectmonPartyImpl;
import it.unibo.objectmon.model.entity.PlayerManager;
import it.unibo.objectmon.model.entity.npc.api.Trainer;
import it.unibo.objectmon.model.world.Coord;

/**
 * Models an NPC capable of fighting.
 */
public final class TrainerNpc extends AbstractNPC implements Trainer {
    private final ObjectmonParty team;
    private boolean isDefeated;

    /**
     * Constructs a new Trainer.
     * @param name The name of the Trainer.
     * @param coord The starting position of the Trainer.
     * @param team The team of Objectmons of the Trainer.
     */
    public TrainerNpc(final String name, final Coord coord, final List<Objectmon> team) {
        super(name, coord);
        this.team = new ObjectmonPartyImpl(team);
        this.isDefeated = false;
    }

    @Override
    public void setDefeated(final boolean isDefeated) {
        this.isDefeated = isDefeated;
    }

    @Override
    public boolean isDefeated() {
        return this.isDefeated;
    }

    @Override
    public List<Objectmon> getTeam() {
        return this.team.getParty();
    }

    @Override
    public void handleInteraction(final PlayerManager player) {
        //System.out.println("I challenge you!");
        //If undefeated says "I challenge you!".
        //Calls battle manager to start battle between him and the player.
    }
}
