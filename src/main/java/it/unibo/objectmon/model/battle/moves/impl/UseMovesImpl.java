package it.unibo.objectmon.model.battle.moves.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.catchsystem.CatchSystem;
import it.unibo.objectmon.model.battle.catchsystem.CatchSystemImpl;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;

/**
 * an implementation to execute moves chosen by player or AI.
 */
public final class UseMovesImpl implements UseMoves {
    private final Battle battle;
    private final BattleLogger logger;

    /**
     * constructor of UseMoves.
     * @param battle the current battle.
     * @param logger logger to comunicate to view.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "using dependency injection")
    public UseMovesImpl(final Battle battle, final BattleLogger logger) {
        this.battle = battle;
        this.logger = logger;
    }

    @Override
    public double useSkill(final int index, final Objectmon userSkill, final Objectmon target) {
        final AttackMove attack = new AttackMove(userSkill.getSkills().get(index));
        if (userSkill.getSkills().get(index).getCurrentUses() > 0) {
            final int damage = attack.action(userSkill, target);
            this.logger.log(
            userSkill.getName() + " uses " + userSkill.getSkills().get(index).getName()
            + "\n" + target.getName() + " takes " + damage + " damage."
            );
            return damage;
        }
        return 0;
    }

    @Override
    public boolean runAway() {
        if (this.battle.getTrainer().isEmpty()) {
            if (this.battle.getCurrentObjectmon().getCurrentHp() <= 0) {
                this.removeCurrentAndSwitch(battle.getPlayerTeam());
                this.logger.log("player run away");
            }
            return true;
        }
        this.logger.log("you cannot run away!");
        return false;
    }

    @Override
    public void removeCurrentAndSwitch(final ObjectmonParty team) {
        if (this.isDead(team.getParty().get(0))) {
            this.logger.log(
                team.getParty().get(0).getName() + " is dead " 
                + "\n next pokemon will be " + team.getParty().get(1).getName()
            );
            this.remove(team);
        }
    }

    @Override
    public void switchObjectmon(final int index, final ObjectmonParty team) {
        team.switchPosition(team.getParty().get(0), team.getParty().get(index));
        this.logger.log(
            (team.equals(this.battle.getPlayerTeam()) ? "Player " : "Trainer ") 
            + "change current objectmon from " 
            + team.getParty().get(index).getName() + " to " 
            + team.getParty().get(0).getName()
        );
    }

    private void remove(final ObjectmonParty team) {
        team.remove(team.getParty().get(0));
    }

    private boolean isDead(final Objectmon objectmon) {
        return objectmon.getCurrentHp() <= 0;
    }

    @Override
    public void useHeal(final int healHP, final Objectmon objectmon) {
        objectmon.setCurrentHp(healHP);
        this.logger.log(objectmon.getName() + " heals with " + healHP + "HP");
    }

    @Override
    public boolean useBall(final double multiplier, final Objectmon objectmon) {
        final CatchSystem catchObjctmon = new CatchSystemImpl();
        if (catchObjctmon.isCaught(multiplier, objectmon)) {
            this.battle.getPlayerTeam().add(objectmon);
            this.logger.log("congratulation, you catch " + objectmon.getName());
            return true;
        }
        this.logger.log("miss catching " + objectmon.getName());
        return false;
    }
}
