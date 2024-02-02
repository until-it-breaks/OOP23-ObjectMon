package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.statistics.StatId;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.api.Move;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.api.Trainer;

public class BattleImpl implements Battle {
    private final Player player;
    private final Optional<Trainer> trainer;
    private final Optional<Objectmon> objectmon;
    /**
     * constructor of battle between the player and trainer.
     * @param player player in the battle
     * @param trainer trainer to be defeated by player
     */
    public BattleImpl(Player player, Trainer trainer) {
        this.player = player;
        this.trainer = Optional.of(trainer);
        this.objectmon = Optional.empty();
    }
    /**
     * constructor of battle between the player and wild objectmon.
     * @param player player in the battle 
     * @param objectmon wild objectmon
     */
    public BattleImpl(Player player, Objectmon objectmon) {
        this.player = player;
        this.objectmon = Optional.of(objectmon);
        this.trainer = Optional.empty();
    }

    @Override
    public boolean isWin() {
        return this.trainer.get().isDefeated() && !this.player.isDefeated() ||
            this.objectmon.get().getStats().getSingleStat(StatId.HP) <= 0;
    }

    @Override
    public Move getPlayerMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerMove'");
    }

    @Override
    public void setPlayerMove(Player player, Move move) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPlayerMove'");
    }

    @Override
    public void setEnemyMove(Optional<Trainer> enemy, Move move) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEnemyMove'");
    }

    @Override
    public Move getEnemyMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEnemyMove'");
    }

    @Override
    public Objectmon getCurrentObjectmon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentObjectmon'");
    }

    @Override
    public Objectmon getEnemyObjectmon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEnemyObjectmon'");
    }
    
}
