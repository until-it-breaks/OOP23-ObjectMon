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
public final class BattleManagerImpl implements BattleManager {
    @SuppressFBWarnings
    private Optional<Battle> battle;
    private Optional<Result> result;
    /**
     * Constructor of BattleManagerImpl.
     */
    public BattleManagerImpl() {
        this.battle = Optional.empty();
        this.result = Optional.empty();
    }

    @Override
    public void startBattle(final Player player, final Optional<Trainer> enemy, final Optional<Objectmon> objectMon) {
        if (enemy.isEmpty()) {
            this.battle = Optional.of(new BattleImpl(player, objectMon.get()));
        }
        if (objectMon.isEmpty()) {
            this.battle = Optional.of(new BattleImpl(player, enemy.get()));
        }
    }

    @Override
    public void startTurn() {
    }

    @Override
    public Result getResult() {
        return this.result.get();
    }

    @Override
    public void setResult(final Result result) {
        this.result = Optional.of(result);
    }

    @Override
    public boolean isOver() {
        return !this.result.get().equals(Result.IN_BATTLE);
    }

    @Override
    public void runAway() {
        if (this.battle.isPresent() && this.battle.get().getTrainer().isEmpty()) {
            setResult(Result.LOSE);
        }
    }

    @Override
    public void useSkill(final int index) {
    }

    @Override
    public void switchObjectmon(final int index) {
    }
}
