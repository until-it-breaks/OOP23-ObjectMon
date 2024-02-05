package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.api.Trainer;
/**
 * an implementation of battle manager.
 */
public class BattleManagerImpl implements BattleManager {
    @SuppressFBWarnings
    private Battle battle;
    private Result result = Result.IN_BATTLE;

    @Override
    public final void startBattle(final Player player, final Optional<Trainer> enemy, final Optional<Objectmon> objectMon) {
        if (enemy.isEmpty()) {
            this.battle = new BattleImpl(player, objectMon.get());
        }
        if (objectMon.isEmpty()) {
            this.battle = new BattleImpl(player, enemy.get());
        }
    }

    @Override
    public final void startTurn() {
    }

    @Override
    public final Result getResult() {
        return this.result;
    }

    @Override
    public final void setResult(final Result result) {
        this.result = result;
    }

    @Override
    public final boolean isOver() {
        return !this.result.equals(Result.IN_BATTLE);
    }

    @Override
    public void runAway() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runAway'");
    }

    @Override
    public void useSkill(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useSkill'");
    }

    @Override
    public void switchObjectmon(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchObjectmon'");
    }
}
