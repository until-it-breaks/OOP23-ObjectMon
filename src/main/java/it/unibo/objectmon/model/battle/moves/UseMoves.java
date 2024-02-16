package it.unibo.objectmon.model.battle.moves;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * execute moves chosen by player or AI.
 */
public interface UseMoves {
    /**
     * exeute attack move (use the skill of index of the objectmon).
     * @param index index of skill in the list.
     * @param userSkill objectmon use the skill
     * @param target objectmon to be attcked
     * @return the damage hit to the target
     */
    double useSkill(int index, Objectmon userSkill, Objectmon target);

    /**
     * player leave the battle if is possible.
     * @return true if the enemy is a wild objectmon
     */
    boolean runAway();

    /**
     * switch objectmon when the current one is dead, which is going to be removed.
     * @param team the team that current objectmon is dead and will be removed
     */
    void removeCurrentAndSwitch(ObjectmonParty team);

    /**
     * switch the current objectmon.
     * @param index the new current objectmon
     * @param team objectmon party of player/AI
     */
    void switchObjectmon(int index, ObjectmonParty team);

    /**
     * use heal item to cure objectmon.
     * @param healHP HP to add on objectmon.
     * @param objectmon objectmon to be treated.
     */
    void useHeal(int healHP, Objectmon objectmon);

    /**
     * use Ball to catch wild objectmon.
     * @param multiplier multiplier of the ball to have more probability to catch.
     * @param objectmon target to be caught.
     * @return if it is caught or not.
     */
    boolean useBall(double multiplier, Objectmon objectmon);
}
