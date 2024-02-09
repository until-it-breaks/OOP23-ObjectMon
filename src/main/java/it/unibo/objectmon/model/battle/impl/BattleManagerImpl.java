package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.impl.AttackMove;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.StatTurn;
import it.unibo.objectmon.model.battle.turn.Turn;
import it.unibo.objectmon.model.battle.turn.TurnImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.api.npc.Trainer;

/**
 * an implementation of battle manager.
 */
public final class BattleManagerImpl implements BattleManager {

    private Optional<Battle> battle;
    private Optional<Result> result;
    private final Turn turn;
    /**
     * Constructor of BattleManagerImpl.
     */
    public BattleManagerImpl() {
        this.battle = Optional.empty();
        this.result = Optional.empty();
        this.turn = new TurnImpl();
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
    public void startTurn(final Move type, final int index) {
        this.battle.get().setPlayerMove(type);
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
        final AttackMove attack = new AttackMove(this.battle.get().getCurrentObjectmon().getSkill(index));
        attack.action(this.battle.get().getCurrentObjectmon(), this.battle.get().getEnemyObjectmon());
    }
    /**
     * 
     * @param index index of skill in the list.
     * @param userSkill objectmon use the skill
     * @param target objectmon to be attacked
     */
    public void useSkill(final int index, final Objectmon userSkill, final Objectmon target) {
        final AttackMove attack = new AttackMove(userSkill.getSkill(index));
        attack.action(userSkill, target);
    }

    @Override
    public void switchObjectmon(final int index) {
        final var team = this.battle.get().getPlayerTeam().getParty();
        this.battle.get().getPlayerTeam().switchPosition(team.get(0), team.get(index));
    }

    /**
     * 
     * @param index index of objectmon to be the current objectmon
     * @param team team of trainer or player.
     */
    public void switchObjectmon(final int index, final ObjectmonParty team) {
        team.switchPosition(team.getParty().get(0), team.getParty().get(index));
    }

    @Override
    public void bufferCommand(final Move type, final int index) {
        if (this.turn.getStat().equals(StatTurn.IS_WAITING_MOVE)) {
            this.startTurn(type, index);
        }
    }
}
