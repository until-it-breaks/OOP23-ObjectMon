package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import it.unibo.objectmon.model.ai.EasyAiTrainer;
import it.unibo.objectmon.model.ai.api.AiTrainer;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.impl.AttackMove;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.StatTurn;
import it.unibo.objectmon.model.battle.turn.Turn;
import it.unibo.objectmon.model.battle.turn.TurnImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.npc.Trainer;

/**
 * an implementation of battle manager.
 */
public final class BattleManagerImpl implements BattleManager {

    private Optional<Battle> battle;
    private Optional<Result> result;
    private final Turn turn;
    private final AiTrainer aiTrainer;
    /**
     * Constructor of BattleManagerImpl.
     */
    public BattleManagerImpl() {
        this.battle = Optional.empty();
        this.result = Optional.empty();
        this.turn = new TurnImpl();
        this.aiTrainer = new EasyAiTrainer();
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
        this.turn.setTurn(StatTurn.TURN_STARTED);
        final int aiIndex = chooseAiMove();
        this.battle.get().setPlayerMove(type);
        switch (this.turn.whichFirst(
            this.battle.get().getEnemyMove(),
            this.battle.get().getPlayerMove(), 
            this.battle.get().getCurrentObjectmon(), 
            this.battle.get().getEnemyObjectmon()
        )) {
            case AI_TURN :
                executeAiTurn(this.battle.get().getEnemyMove(), aiIndex);
                executePlayerTurn(type, index);
                break;
            case PLAYER_TURN :
                executePlayerTurn(type, index);
                executeAiTurn(this.battle.get().getEnemyMove(), aiIndex);
                break;
            default :
                throw new IllegalArgumentException();
        }
        this.turn.setTurn(StatTurn.IS_WAITING_MOVE);
    }
    /**
     * 
     * @param type type of move.
     * @param index index of skill or objectmon to switch
     */
    public void executeAiTurn(final Move type, final int index) {
    }
    /**
     * 
     * @param type type of move.
     * @param index index of skill or objectmon to switch
     */
    public void executePlayerTurn(final Move type, final int index) {
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
     * switch objectmon when the current one is dead, which is going to be removed.
     * @param team the team that current objectmon is dead and will be removed
     */
    public void switchObjectmon(final ObjectmonParty team) {
        if (team.getParty().get(0).getCurrentHp() == 0) {
            team.remove(team.getParty().get(0));
        }
    }

    @Override
    public void bufferCommand(final Move type, final int index) {
        if (this.turn.getStat().equals(StatTurn.IS_WAITING_MOVE)) {
            this.startTurn(type, index);
        }
    }
    /**
     * set AI move.
     * @return index of skill or position to use
     */
    public int chooseAiMove() {
        if (this.battle.get().getTrainer().isPresent()) {
            final Trainer trainer = this.battle.get().getTrainer().get();
            if (trainer.getObjectmonParty().getParty().get(0).getCurrentHp() <= 0) {
                this.battle.get().setEnemyMove(Move.SWITCH_OBJECTMON);
                return this.aiTrainer.switchObjectmon(trainer.getObjectmonParty());
            }
        }
        this.battle.get().setEnemyMove(Move.ATTACK);
        return this.aiTrainer.useSkill(this.battle.get().getEnemyObjectmon());
    }
}
