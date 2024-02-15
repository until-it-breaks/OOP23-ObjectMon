package it.unibo.objectmon.model.battle.turn.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.impl.ReadOnlyBattle;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.battle.turn.api.ExecuteTurn;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
/**
 * execute move of ai.
 */
public final class AiTurn implements ExecuteTurn {

    private final ReadOnlyBattle battle;

    /**
     * constructor of ai turn.
     * @param battle current battle.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "managed by manager to execute specifically some tasks.")
    public AiTurn(final ReadOnlyBattle battle) {
        this.battle = battle;
    }

    @Override
    public void execute(final Move type, final int index, final UseMoves useMoves) {
        switch (type) {
            case ATTACK :
                if (this.isDead(this.battle.getEnemyObjectmon())) {
                    this.battle.getTrainerTeam().ifPresent(
                        t -> {
                            if (t.getParty().size() > 1) {
                                useMoves.removeCurrentAndSwitch(this.battle.getTrainerTeam().get());
                            } else {
                                remove(t);
                            }
                        }
                    );
                } else {
                    useMoves.useSkill(index, this.battle.getEnemyObjectmon(), this.battle.getCurrentObjectmon());
                    if (this.isDead(this.battle.getCurrentObjectmon()) 
                        && this.battle.getPlayerTeam().getParty().size() <= 1
                    ) {
                            this.remove(this.battle.getPlayerTeam());
                    }
                }
                break;
            case SWITCH_OBJECTMON :
                if (this.battle.getTrainerTeam().get().getParty().size() > 1) {
                    useMoves.switchObjectmon(index, this.battle.getTrainerTeam().get());
                }
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
