package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.Reward;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.impl.UseMovesImpl;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.StatTurn;
import it.unibo.objectmon.model.battle.turn.TurnImpl;
import it.unibo.objectmon.model.battle.turn.api.Turn;
import it.unibo.objectmon.model.battle.turn.api.TurnManager;
import it.unibo.objectmon.model.battle.turn.impl.TurnManagerImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 * an implementation of battle manager.
 */
public final class BattleManagerImpl implements BattleManager {

    private Optional<Battle> battle;
    private Optional<Result> result;
    private final Turn turn;
    private final GameStateManager gameStateManager;
    private final BattleLogger logger;
    private UseMoves useMoves;
    private final TurnManager turnManager;
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
        this.gameStateManager = gameStateManager;
        this.logger = new BattleLogger();
        this.turnManager = new TurnManagerImpl(turn);
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
                this.logger.log("battle started with trainer: " + t.getName());
            },
            () -> objectMon.ifPresentOrElse(o -> {
                    this.battle = Optional.of(new BattleImpl(player, o));
                    this.logger.log("battle started with " + o.getName());
                }, 
                () -> {
                    throw new IllegalStateException("Cannot start battle: No trainer or objectmon present.");
                }
            )
        );
        this.gameStateManager.setGameState(GameState.BATTLE);
        this.useMoves = new UseMovesImpl(this.battle.get(), (message) -> { logger.log(message); });
        this.setResult(Result.IN_BATTLE);
        this.turn.setTurn(StatTurn.IS_WAITING_MOVE);
        this.count = 0;
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
            turnManager.startTurn(type, index, this, useMoves, (message) -> { logger.log(message); }, ++count);
        }
    }

    private boolean isCommandValid(final Move type, final int index) {
        switch (type) {
            case RUN_AWAY:
                return this.battle.isPresent() && this.battle.get().getTrainer().isEmpty();
            case ATTACK:
                return index >= 0 && index < this.battle.get().getCurrentObjectmon().getSkills().size()
                    && this.battle.get().getCurrentObjectmon().getCurrentHp() > 0
                    && this.battle.get().getCurrentObjectmon().getSkills().get(index).getCurrentUses() > 0;
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

    @Override
    public void endBattleAction() {
        if (this.isOver()) {
            switch (this.result.get()) {
                case WIN:
                    rewardIfWin();
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

    private void rewardIfWin() {
        if (getResult().equals(Result.WIN)) {
            final Reward reward = new RewardImpl();
            this.battle.get().getPlayerTeam().getParty()
                .stream().forEach(o -> o.calcExp(
                    this.battle.get().getTrainer().isPresent() 
                    ? reward.upgradeEXP(this.battle.get().getPlayerTeam()) 
                    : reward.upgradeEXP()
                ));
                System.out.println(reward.upgradeEXP(this.battle.get().getPlayerTeam()));
            if (this.battle.get().getTrainer().isPresent()) {
                this.battle.get().getPlayer().getInventory().addCredits(reward.getCredits());
            }
        }
    }

    @Override
    public Optional<Battle> getBattleStats() {
        return this.battle;
    }

    @Override
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Temporary")
    public BattleLogger getLogger() { 
        return this.logger;
    }
}
