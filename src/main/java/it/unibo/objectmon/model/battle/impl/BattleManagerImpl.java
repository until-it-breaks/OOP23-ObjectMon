package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.ai.EasyAiTrainer;
import it.unibo.objectmon.model.ai.api.AiTrainer;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.impl.UseMovesImpl;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.StatTurn;
import it.unibo.objectmon.model.battle.turn.Turn;
import it.unibo.objectmon.model.battle.turn.TurnImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.item.api.BallItem;
import it.unibo.objectmon.model.item.api.HealItem;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 * an implementation of battle manager.
 */
public final class BattleManagerImpl implements BattleManager {

    private Optional<Battle> battle;
    private Optional<Result> result;
    private UseMoves useMoves;
    private final Turn turn;
    private final AiTrainer aiTrainer;
    private final GameStateManager gameStateManager;
    private final BattleLogger logger;
    private int count;

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
        this.logger = new BattleLogger();
        this.count = 0;
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
                this.useMoves = new UseMovesImpl(this.battle.get(), this.logger);
                this.logger.log("battle started with trainer: " + t.getName());
            },
            () -> objectMon.ifPresentOrElse(o -> {
                    this.battle = Optional.of(new BattleImpl(player, o));
                    this.gameStateManager.setGameState(GameState.BATTLE);
                    this.useMoves = new UseMovesImpl(this.battle.get(), this.logger);
                    this.logger.log("battle started with " + o.getName());
                }, 
                () -> {
                    throw new IllegalStateException("Cannot start battle: No trainer or objectmon present.");
                })
        );
        this.count = 0;
        this.setResult(Result.IN_BATTLE);
        this.turn.setTurn(StatTurn.IS_WAITING_MOVE);
    }

    private void startTurn(final Move type, final int index) {
        this.turn.setTurn(StatTurn.TURN_STARTED);
        final int aiIndex = chooseAiMove();
        this.battle.get().setPlayerMove(type);
        this.logger.log("turn " + (++this.count) + "started");
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
                                this.useMoves.removeCurrentAndSwitch(this.battle.get().getTrainerTeam().get());
                            } else {
                                remove(t);
                                this.setResult(Result.WIN);
                                endBattleAction();
                            }
                        }
                    );
                } else {
                    this.useMoves.useSkill(index, this.battle.get().getEnemyObjectmon(), this.battle.get().getCurrentObjectmon());
                    if (this.isDead(this.battle.get().getCurrentObjectmon()) 
                            && this.battle.get().getPlayerTeam().getParty().size() <= 1
                        ) {
                            this.remove(this.battle.get().getPlayerTeam());
                            setResult(Result.LOSE);
                            endBattleAction();
                    }
                }
                break;
            case SWITCH_OBJECTMON :
                this.useMoves.removeCurrentAndSwitch(this.battle.get().getTrainerTeam().get());
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
                this.useMoves.removeCurrentAndSwitch(this.battle.get().getPlayerTeam());
            } else {
                this.remove(this.battle.get().getPlayerTeam());
                setResult(Result.LOSE);
                endBattleAction();
            }
        } else {
            switch (type) {
                case ATTACK:
                        this.useMoves.useSkill(
                            index, this.battle.get().getCurrentObjectmon(), 
                            this.battle.get().getEnemyObjectmon()
                        );
                    break;
                case SWITCH_OBJECTMON:
                    if (this.battle.get().getPlayerTeam().getParty().size() > 1) {
                        this.useMoves.switchObjectmon(index, this.battle.get().getPlayerTeam());
                    }
                    break;
                case RUN_AWAY:
                    if (this.useMoves.runAway()) {
                        endBattleAction();
                    }
                    break;
                case USE_HEAL:
                    this.useMoves.useHeal(getHeal(index).getHealPoints(), this.battle.get().getCurrentObjectmon());
                    this.useItem(index);
                    break;
                case USE_BALL:
                    useItem(index);
                    if (this.useMoves.useBall(getBall(index).getCatchMultiplier(), this.battle.get().getEnemyObjectmon())) {
                        this.setResult(Result.WIN);
                        this.endBattleAction();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void useItem(final int index) {
        this.battle.get().getPlayer().getInventory().useItem(this.getItem(index));
    }

    private void remove(final ObjectmonParty team) {
        team.remove(team.getParty().get(0));
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
                return index >= 0 && index < this.battle.get().getCurrentObjectmon().getSkills().size()
                    && this.battle.get().getCurrentObjectmon().getCurrentHp() > 0;
            case SWITCH_OBJECTMON:
                return index > 0 && index < this.battle.get().getPlayerTeam().getParty().size()
                    && this.battle.get().getPlayerTeam().getParty().size() > 1;
            case USE_HEAL:
            case USE_BALL:
                return this.battle.get().getPlayer().getInventory().getItems().get(getItem(index)) > 0
                    && (type == Move.USE_HEAL || this.battle.get().getTrainer().isEmpty());
            default:
                return false;
        }
    }

    private Item getItem(final int index) {
        return this.battle.get().getPlayer().getInventory().getItems()
            .keySet().stream().skip(index).findFirst().get();
    }

    private HealItem getHeal(final int index) {
        if (getItem(index) instanceof HealItem) {
            return (HealItem) getItem(index);
        }
        throw new IllegalStateException();
    }

    private BallItem getBall(final int index) {
        if (getItem(index) instanceof BallItem) {
            return (BallItem) getItem(index);
        }
        throw new IllegalStateException();
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
        if (this.battle.isPresent()) {
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
    }

    private void endBattleAction() {
        if (this.isOver()) {
            switch (this.result.get()) {
                case WIN:
                    this.battle.get().getPlayerTeam().getParty()
                        .stream().forEach(o -> o.calcExp(this.battle.get().upgradeEXP()));
                    this.logger.log("YOU WIN");
                    break;
                case LOSE:
                    this.logger.log("YOU LOSE");
                    break;
                default:
                    break;
            }
            gameStateManager.setGameState(GameState.PAUSE);
            this.battle = Optional.empty();
        }
    }

    @Override
    public Optional<Battle> getBattleStats() {
        return this.battle.isPresent()
            ? Optional.of(new ReadOnlyBattle(this.battle.get()))
            : Optional.empty();
    }

    @Override
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Temporary")
    public BattleLogger getLogger() { 
        return this.logger;
    }
}
