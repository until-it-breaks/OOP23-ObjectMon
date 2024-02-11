package it.unibo.objectmon.model.entities.npc;

import java.util.List;
import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.objectmon.ObjectmonPartyImpl;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.misc.eventlog.api.EventLogger;
import it.unibo.objectmon.model.world.api.Coord;
import it.unibo.objectmon.model.battle.api.*;
/**
 * Models an NPC capable of fighting.
 */
public final class TrainerNPCImpl extends AbstractNPC implements Trainer {
    private final ObjectmonParty objectmonParty;
    private final BattleManager battleManager;
    /**
     * Constructs a new Trainer.
     * 
     * @param name The name of the Trainer.
     * @param coord The starting position of the Trainer.
     * @param team The team of Objectmons of the Trainer.
     */
    public TrainerNPCImpl(final String name, final Coord coord, final List<Objectmon> team, BattleManager battleManager) {
        super(name, coord);
        this.objectmonParty = new ObjectmonPartyImpl(team);
        this.battleManager = battleManager;
    }

    @Override
    public boolean isDefeated() {
        return this.objectmonParty.getParty().size() == 0;
    }

    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "TEMPORARY")
    @Override
    public ObjectmonParty getObjectmonParty() {
        return this.objectmonParty;
    }

    @Override
    public void handleInteraction(final Player player, final EventLogger logger) {
        if (!isDefeated()) {
            logger.log(this.getName() + " challenges " + player.getName());
            battleManager.startBattle(player, Optional.of(this), null);
            //Calls battle manager.
        } else {
            logger.log(this.getName() + "has already been defeated");
        }
    }
}
