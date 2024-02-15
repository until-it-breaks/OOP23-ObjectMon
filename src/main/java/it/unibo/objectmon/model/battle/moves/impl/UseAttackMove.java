package it.unibo.objectmon.model.battle.moves.impl;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
/**
 * In the battle player and AI can use this class to execute attack move.
 */
public class UseAttackMove {
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
            return attack.action(userSkill, target);
        }
        return 0;
    }
}
