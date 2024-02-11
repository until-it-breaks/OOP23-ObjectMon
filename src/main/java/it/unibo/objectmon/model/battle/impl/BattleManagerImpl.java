package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import it.unibo.objectmon.controller.commands.SwitchObjectmon;
import it.unibo.objectmon.controller.commands.UseSkill;
import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.ModelImpl;
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
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.npc.Trainer;
import it.unibo.objectmon.model.entities.npc.TrainerNPCImpl;
import it.unibo.objectmon.model.entities.player.PlayerImpl;
import it.unibo.objectmon.model.world.api.Coord;

import java.util.List;
import java.util.ArrayList;
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
    public void startBattle(final Player player, final Optional<Trainer> trainer, final Optional<Objectmon> objectMon) {
        if (this.battle.isPresent()) {
            throw new IllegalStateException("A battle is already in progress.");
        }
        trainer.ifPresentOrElse(
            t -> this.battle = Optional.of(new BattleImpl(player, t)), 
            () -> objectMon.ifPresentOrElse(o -> this.battle = Optional.of(new BattleImpl(player, o)), () -> {
                throw new IllegalStateException("Cannot start battle: No trainer or objectmon present.");
            })
        );
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
                    this.battle.get().getTrainerTeam().ifPresentOrElse(
                        t -> {
                            if (t.getParty().size() > 1) {
                                this.removeCurrentAndSwitch(this.battle.get().getTrainerTeam().get());
                            }
                            setResult(Result.WIN);
                        },
                        () -> setResult(Result.WIN)
                    );
                }
                useSkill(index, this.battle.get().getEnemyObjectmon(), this.battle.get().getCurrentObjectmon());
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
        switch (type) {
            case ATTACK:
                if (this.isDead(this.battle.get().getCurrentObjectmon())) {
                    this.removeCurrentAndSwitch(this.battle.get().getPlayerTeam());
                }
                this.useSkill(index, this.battle.get().getCurrentObjectmon(), this.battle.get().getEnemyObjectmon());
                break;
            case SWITCH_OBJECTMON:
                this.switchPlayerObjectmon(index);
                break;
            case RUN_AWAY:
                this.runAway();
                break;
            default:
                break;
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
            setResult(Result.LOSE);
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
        if (this.turn.getStat().equals(StatTurn.IS_WAITING_MOVE)) {
            this.turn.setTurn(StatTurn.TURN_STARTED);
            this.startTurn(type, index);
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
        }
        if (this.battle.get().isLose()) {
            this.setResult(Result.LOSE);
            this.endBattleAction();
        }
        this.turn.setTurn(StatTurn.IS_WAITING_MOVE);
    }

    private void endBattleAction() {
        if (this.isOver()) {
            switch (this.result.get()) {
                case WIN:
                    this.battle.get().getTrainer().ifPresent(t -> t.setDefeated(true));
                    break;
                case LOSE:
                    this.battle.get().getPlayer().setDefeated(true);
                    break;
                default:
                    break;
            }
            this.setfieldsEmpty();
        }
    }

    private void setfieldsEmpty() {
        this.battle = Optional.empty();
        this.result = Optional.empty();
    }
        /**
     * test.
     * @param args
     */
    public static void main(final String[] args) {
        final Coord POSITION_1 = new Coord(5, 5);
        Trainer trainer = new TrainerNPCImpl("Trainer Bob", 
            POSITION_1, 
            new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
                ObjectmonEnum.ILLUMISE,
                ObjectmonEnum.LILEEP),
                1)));
        Player player = new PlayerImpl("yous",
            new Coord(5, 6), 
            new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
                ObjectmonEnum.ANORITH,
                ObjectmonEnum.KECLEON,
                ObjectmonEnum.MUDKIP
            ), 2))
        );
        final Model model = new ModelImpl();
        model.initialize();
        final BattleManager battleManager = model.getBattleManager();
        model.getBattleManager().startBattle(player, Optional.of(trainer), Optional.empty());
        Command useSkill0 = new UseSkill(0);
        battleManager.printInfo();
        useSkill0.execute(model);
        battleManager.printInfo();
        useSkill0.execute(model);
        battleManager.printInfo();
        useSkill0.execute(model);
        battleManager.printInfo();
        Command switchObj = new SwitchObjectmon(1);
        switchObj.execute(model);
        battleManager.printInfo();
        useSkill0.execute(model);
        battleManager.printInfo();
    }

    public void printInfo() {
        System.out.println(this.battle.get().getCurrentObjectmon().getName() 
        + this.battle.get().getCurrentObjectmon().getCurrentHp()
        );
        System.out.println(this.battle.get().getEnemyObjectmon().getName()
            + this.battle.get().getEnemyObjectmon().getCurrentHp());
    } 
}
