package it.unibo.objectmon.model.battle.turn.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.api.ExecuteTurn;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.item.api.BallItem;
import it.unibo.objectmon.model.item.api.HealItem;
import it.unibo.objectmon.model.item.api.Item;
/**
 * execute move of player.
 */
public final class PlayerTurn implements ExecuteTurn {

    private final Battle battle;

    /**
     * constructor of ai turn.
     * @param battle current battle.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "managed by manager to execute specifically some tasks in the battle.")
    public PlayerTurn(final Battle battle) {
        this.battle = battle;
    }

    @Override
    public void execute(final Move type, final int index, final UseMoves useMoves, final BattleManager battleManager) {
        if (this.isDead(this.battle.getCurrentObjectmon()) && !type.equals(Move.RUN_AWAY)) {
            actionAfterDead(useMoves, battleManager);
        } else {
            switch (type) {
                case ATTACK:
                        useMoves.useSkill(
                            index, this.battle.getCurrentObjectmon(), 
                            this.battle.getEnemyObjectmon()
                        );
                    break;
                case SWITCH_OBJECTMON:
                    if (this.battle.getPlayerTeam().getParty().size() > 1) {
                        useMoves.switchObjectmon(index, this.battle.getPlayerTeam());
                    }
                    break;
                case USE_HEAL:
                    useMoves.useHeal(getHeal(index).getHealPoints(), this.battle.getCurrentObjectmon());
                    this.useItem(index);
                    break;
                case USE_BALL:
                    useItem(index);
                    if (useMoves.useBall(getBall(index).getCatchMultiplier(), this.battle.getEnemyObjectmon())) {
                        battleManager.setResult(BattleManager.Result.WIN);
                        battleManager.endBattleAction();
                    }
                    break;
                case RUN_AWAY:
                    if (useMoves.runAway()) {
                        battleManager.setResult(BattleManager.Result.LOSE);
                        battleManager.endBattleAction();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void actionAfterDead(final UseMoves useMoves, final BattleManager battleManager) {
        if (this.battle.getPlayerTeam().getParty().size() > 1) {
            useMoves.removeCurrentAndSwitch(this.battle.getPlayerTeam());
        } else {
            this.remove(this.battle.getPlayerTeam());
            battleManager.setResult(BattleManager.Result.LOSE);
            battleManager.endBattleAction();
        }
    }

    private void remove(final ObjectmonParty team) {
        team.remove(team.getParty().get(0));
    }

    private boolean isDead(final Objectmon objectmon) {
        return objectmon.getCurrentHp() <= 0;
    }

    private void useItem(final int index) {
        this.battle.getPlayer().getInventory().useItem(this.getItem(index));
    }

    private Item getItem(final int index) {
        return this.battle.getPlayer().getInventory().getItems()
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
}
