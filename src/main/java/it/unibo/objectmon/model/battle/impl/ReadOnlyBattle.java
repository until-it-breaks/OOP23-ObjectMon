package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.entities.player.ReadOnlyPlayer;
/**
 * Represents a read-only view of a {@link Battle} instance.
 * This class wraps a {@link Battle} object and provides read-only access to its properties,
 * while preventing modifications to its state.
 */
public final class ReadOnlyBattle implements Battle {
    @SuppressFBWarnings(
    value = "EI_EXPOSE_REP2", 
    justification = "This read-only view does not expose the internal state of Battle."
                    + "It is designed to provide only read-only access to Battle information, "
                    + "ensuring that the battle's state remains immutable."
    )
    private final Battle battle;

    /**
     * Constructs a new read-only player instance that wraps the given {@link Battle} object.
     *
     * @param battle The player instance to wrap.
     */
    public ReadOnlyBattle(final Battle battle) {
        this.battle = battle;
    }

    @Override
    public boolean isWin() {
        return this.battle.isWin();
    }

    @Override
    public boolean isLose() {
        return this.battle.isLose();
    }

    @Override
    public Move getPlayerMove() {
        return this.battle.getPlayerMove();
    }

    @Deprecated
    @Override
    public void setPlayerMove(final Move move) {
        throw new UnsupportedOperationException("Unimplemented method 'setDirection'");
    }

    @Deprecated
    @Override
    public void setEnemyMove(final Move move) {
        throw new UnsupportedOperationException("Unimplemented method 'setEnemyMove'");
    }

    @Override
    public Move getEnemyMove() {
        return this.battle.getEnemyMove();
    }

    @Override
    public Objectmon getCurrentObjectmon() {
        return this.battle.getCurrentObjectmon();
    }

    @Override
    public Objectmon getEnemyObjectmon() {
        return this.battle.getEnemyObjectmon();
    }

    @Override
    public Optional<Trainer> getTrainer() {
        return this.battle.getTrainer();
    }

    @Override
    public Player getPlayer() {
        return new ReadOnlyPlayer(this.battle.getPlayer());
    }

    @Override
    public ObjectmonParty getPlayerTeam() {
        return this.battle.getPlayerTeam();
    }

    @Override
    public Optional<ObjectmonParty> getTrainerTeam() {
        return this.battle.getTrainerTeam();
    }
}
