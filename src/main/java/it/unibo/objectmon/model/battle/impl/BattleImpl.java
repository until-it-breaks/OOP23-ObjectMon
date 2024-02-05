package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.objectmon.ObjectmonParty;
import it.unibo.objectmon.api.data.objectmon.ObjectmonPartyImpl;
import it.unibo.objectmon.api.data.statistics.StatId;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.api.Move;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.api.Trainer;
/**
 * A simple battle that implements Battle.
 */
public final class BattleImpl implements Battle {
    private final Player player;
    private final Optional<Trainer> trainer;
    private final Optional<Objectmon> objectmon;
    private Move playerMove;
    private Move enemyMove;
    /**
     * constructor of battle between the player and trainer.
     * @param player player in the battle
     * @param trainer trainer to be defeated by player
     */
    public BattleImpl(final Player player, final Trainer trainer) {
        this.player = player;
        this.trainer = Optional.of(trainer);
        this.objectmon = Optional.of(trainer.getTeam().get(0));
    }
    /**
     * constructor of battle between the player and wild objectmon.
     * @param player player in the battle 
     * @param objectmon wild objectmon
     */
    public BattleImpl(final Player player, final Objectmon objectmon) {
        this.player = player;
        this.objectmon = Optional.of(objectmon);
        this.trainer = Optional.empty();
    }

    @Override
    public boolean isWin() {
        return this.trainer.get().isDefeated() && !this.player.isDefeated() 
        || this.objectmon.get().getStats().getSingleStat(StatId.HP) <= 0;
    }

    @Override
    public Move getPlayerMove() {
        return this.playerMove;
    }

    @Override
    public void setPlayerMove(final Move move) {
        this.playerMove = move;
    }

    @Override
    public void setEnemyMove(final Move move) {
        this.enemyMove = move;
    }

    @Override
    public Move getEnemyMove() {
        return this.enemyMove;
    }

    @Override
    public Objectmon getCurrentObjectmon() {
        return this.player.getTeam().get(0);
    }

    @Override
    public Objectmon getEnemyObjectmon() {
        return this.trainer.isEmpty() 
        ? this.objectmon.get() 
        : this.trainer.get().getTeam().get(0);
    }
    @Override
    public Optional<Trainer> getTrainer() {
        return this.trainer;
    }
    @Override
    public ObjectmonParty getTeam() {
        return new ObjectmonPartyImpl(this.player.getTeam());
    }
}
