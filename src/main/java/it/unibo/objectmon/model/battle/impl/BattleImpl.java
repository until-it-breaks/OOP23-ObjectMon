package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.Move;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.TrainerNpc;

public class BattleImpl implements Battle {

    @Override
    public boolean isWin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isWin'");
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
    public void setEnemyMove(Optional<TrainerNpc> enemy, Move move) {
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
