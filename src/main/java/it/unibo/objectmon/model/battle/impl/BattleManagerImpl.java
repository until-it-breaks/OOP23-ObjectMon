package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 * an implementation of battle manager.
 */
public final class BattleManagerImpl implements BattleManager {

    private Optional<Battle> battle;
    private Optional<Result> result;
    private final Turn turn;
    private final AiTrainer aiTrainer;
    private final GameStateManager gameStateManager;

    /**
     * Constructor of BattleManagerImpl.
     * 
     * @param gameStateManager The game state manager.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Temporary")
    public BattleManagerImpl(final GameStateManager gameStateManager) {
        this.battle = Optional.empty();
        this.result = Optional.empty();
        this.turn = new TurnImpl();
        this.aiTrainer = new EasyAiTrainer();
        this.gameStateManager = gameStateManager;
    }

    @Override
    public void startBattle(final Player player, final Optional<Trainer> trainer, final Optional<Objectmon> objectMon) {
        if (this.battle.isPresent()) {
            throw new IllegalStateException("A battle is already in progress.");
        }
        trainer.ifPresentOrElse(
            t -> {
                this.battle = Optional.of(new BattleImpl(player, t));
                this.gameStateManager.setGameState(GameState.BATTLE);
            },
            () -> objectMon.ifPresentOrElse(o -> this.battle = Optional.of(new BattleImpl(player, o)), () -> {
                throw new IllegalStateException("Cannot start battle: No trainer or objectmon present.");
            })
        );
        this.setResult(Result.IN_BATTLE);
        this.turn.setTurn(StatTurn.IS_WAITING_MOVE);
    }

    private void startTurn(final Move type, final int index) {
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
                    if (this.battle.isPresent()) {
                        executePlayerTurn(type, index);
                    }
                    break;
                case PLAYER_TURN :
                    executePlayerTurn(type, index);
                    if (this.battle.isPresent()) {
                        executeAiTurn(this.battle.get().getEnemyMove(), aiIndex);
                    }
                    break;
                default :
                    throw new IllegalArgumentException();
            }
        this.endTurnAction();
    }

    /**
     * 
     * @param type type of move.
     * @param index index of skill or objectmon to switch
     */
    private void executeAiTurn(final Move type, final int index) {
        switch (type) {
            case ATTACK :
                if (this.isDead(this.battle.get().getEnemyObjectmon())) {
                    this.battle.get().getTrainerTeam().ifPresent(
                        t -> {
                            if (t.getParty().size() > 1) {
                                this.removeCurrentAndSwitch(this.battle.get().getTrainerTeam().get());
                            }
                        }
                    );
                } else {
                    useSkill(index, this.battle.get().getEnemyObjectmon(), this.battle.get().getCurrentObjectmon());
                }
                break;
            case SWITCH_OBJECTMON :
                this.removeCurrentAndSwitch(this.battle.get().getTrainerTeam().get());
                break;
            default :
                break;
        }
    }

    /**
     * 
     * @param type type of move.
     * @param index index of skill or objectmon to switch
     */
    private void executePlayerTurn(final Move type, final int index) {
        if (this.isDead(this.battle.get().getCurrentObjectmon()) && !type.equals(Move.RUN_AWAY)) {
            if (this.battle.get().getPlayerTeam().getParty().size() > 1) {
                this.removeCurrentAndSwitch(this.battle.get().getPlayerTeam());
            } else {
                this.setResult(Result.LOSE);
            }
        } else {
            switch (type) {
                case ATTACK:
                        this.useSkill(index, this.battle.get().getCurrentObjectmon(), this.battle.get().getEnemyObjectmon());
                    break;
                case SWITCH_OBJECTMON:
                    if (this.battle.get().getPlayerTeam().getParty().size() > 1) {
                        this.switchPlayerObjectmon(index);
                    }
                    break;
                case RUN_AWAY:
                    this.runAway();
                    break;
                default:
                    break;
            }
        }
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

    private void runAway() {
        if (this.battle.isPresent() && this.battle.get().getTrainer().isEmpty()) {
            setResult(Result.END);
            this.endBattleAction();
        }
    }

    /**
     * 
     * @param index index of skill in the list.
     * @param userSkill objectmon use the skill
     * @param target objectmon to be attacked
     */
    private void useSkill(final int index, final Objectmon userSkill, final Objectmon target) {
        final AttackMove attack = new AttackMove(userSkill.getSkills().get(index));
        attack.action(userSkill, target);
    }

    private void switchPlayerObjectmon(final int index) {
        final var team = this.battle.get().getPlayerTeam().getParty();
        this.battle.get().getPlayerTeam().switchPosition(team.get(0), team.get(index));
    }

    /**
     * switch objectmon when the current one is dead, which is going to be removed.
     * @param team the team that current objectmon is dead and will be removed
     */
    private void removeCurrentAndSwitch(final ObjectmonParty team) {
        if (this.isDead(team.getParty().get(0))) {
            team.remove(team.getParty().get(0));
        }
    }

    @Override
    public void bufferCommand(final Move type, final int index) {
        if (this.battle.isPresent()
            && this.turn.getStat().equals(StatTurn.IS_WAITING_MOVE) 
            && isCommandValid(type, index)) {
            this.turn.setTurn(StatTurn.TURN_STARTED);
            this.startTurn(type, index);
        }
    }

    private boolean isCommandValid(final Move type, final int index) {
        switch (type) {
            case RUN_AWAY:
                return this.battle.isPresent() && this.battle.get().getTrainer().isEmpty();
            case ATTACK:
                return index >= 0 && index < this.battle.get().getCurrentObjectmon().getSkills().size();
            case SWITCH_OBJECTMON:
                return index > 0 && index < this.battle.get().getPlayerTeam().getParty().size()
                    && this.battle.get().getPlayerTeam().getParty().size() > 1;
            default:
                return false;
        }
    }
    /**
     * set AI move.
     * @return index of skill or position to use
     */
    private int chooseAiMove() {
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

    private boolean isDead(final Objectmon objectmon) {
        return objectmon.getCurrentHp() <= 0;
    }

    private void endTurnAction() {
        if (this.battle.get().isWin()) {
            this.setResult(Result.WIN);
            this.endBattleAction();
        } else if (this.battle.get().isLose()) {
            this.setResult(Result.LOSE);
            this.endBattleAction();
        } else {
            this.turn.setTurn(StatTurn.IS_WAITING_MOVE);
        }
    }

    private void endBattleAction() {
        if (this.isOver()) {
            switch (this.result.get()) {
                case WIN:
                    break;
                case LOSE:
                    break;
                default:
                    break;
            }
            gameStateManager.setGameState(GameState.EXPLORATION);
            this.battle = Optional.empty();
        }
    }

    @Override
    public Optional<Battle> getBattleStats() {
        return this.battle.isPresent()
            ? Optional.of(new ReadOnlyBattle(this.battle.get()))
            : Optional.empty();
    }
}
