package it.unibo.objectmon.model.battle.moves.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.catchsystem.CatchSystem;
import it.unibo.objectmon.model.battle.catchsystem.CatchSystemImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
/**
 * execute moves chosen by player or AI.
 */

public class UseMoves {
    private final Battle battle;
    private final BattleLogger logger;

    /**
     * constructor of UseMoves.
     * @param battle the current battle.
     * @param logger logger to comunicate to view.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "using dependency injection")
    public UseMoves(final Battle battle, final BattleLogger logger) {
        this.battle = battle;
        this.logger = logger;
    }

    /**
     * exeute attack move (use the skill of index of the objectmon).
     * @param index index of skill in the list.
     * @param userSkill objectmon use the skill
     * @param target objectmon to be attacked
     * @return the damage hit to the target
     */
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

    /**
     * player leave the battle if is possible.
     * @return true if the enemy is a wild objectmon
     */
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

    /**
     * switch objectmon when the current one is dead, which is going to be removed.
     * @param team the team that current objectmon is dead and will be removed
     */
    public void removeCurrentAndSwitch(final ObjectmonParty team) {
        if (this.isDead(team.getParty().get(0))) {
            this.logger.log(
                team.getParty().get(0).getName() + " is dead " 
                + "\n next pokemon will be " + team.getParty().get(1).getName()
            );
            this.remove(team);
        }
    }

    /**
     * switch the current objectmon.
     * @param index the new current objectmon
     * @param team objectmon party of player/AI
     */
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

    /**
     * use heal item to cure objectmon.
     * @param healHP HP to add on objectmon.
     * @param objectmon objectmon to be treated.
     */
    public void useHeal(final int healHP, final Objectmon objectmon) {
        objectmon.setCurrentHp(healHP);
        this.logger.log(objectmon.getName() + " heals with " + healHP + "HP");
    }

    /**
     * use Ball to catch wild objectmon.
     * @param multiplier multiplier of the ball to have more probability to catch.
     * @param objectmon target to be caught.
     * @return if it is caught or not.
     */
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
