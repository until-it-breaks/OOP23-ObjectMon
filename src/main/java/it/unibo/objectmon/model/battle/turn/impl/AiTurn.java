package it.unibo.objectmon.model.battle.turn.impl;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.api.ExecuteTurn;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
/**
 * execute move of ai.
 */
public final class AiTurn implements ExecuteTurn {

    @Override
    public void execute(final Move type, final int index, final UseMoves useMoves, final BattleManager battleManager) {
        final Battle battle = battleManager.getBattleStats().get();
        switch (type) {
            case ATTACK :
                if (this.isDead(battle.getEnemyObjectmon())) {
                    battle.getTrainerTeam().ifPresent(
                        t -> {
                            if (t.getParty().size() > 1) {
                                useMoves.removeCurrentAndSwitch(battle.getTrainerTeam().get());
                            } else {
                                remove(t);
                                battleManager.setResult(BattleManager.Result.WIN);
                                battleManager.endBattleAction();
                            }
                        }
                    );
                } else {
                    useMoves.useSkill(index, battle.getEnemyObjectmon(), battle.getCurrentObjectmon());
                    if (this.isDead(battle.getCurrentObjectmon()) 
                        && battle.getPlayerTeam().getParty().size() <= 1
                    ) {
                        this.remove(battle.getPlayerTeam());
                        battleManager.setResult(BattleManager.Result.LOSE);
                        battleManager.endBattleAction();
                    }
                }
                break;
            case SWITCH_OBJECTMON :
                useMoves.removeCurrentAndSwitch(battle.getTrainerTeam().get());
                break;
            default :
                break;
        }
    }

    private void remove(final ObjectmonParty team) {
        team.remove(team.getParty().get(0));
    }

    private boolean isDead(final Objectmon objectmon) {
        return objectmon.getCurrentHp() <= 0;
    }
}
