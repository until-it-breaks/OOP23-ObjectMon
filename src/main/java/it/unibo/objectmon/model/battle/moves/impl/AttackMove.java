package it.unibo.objectmon.model.battle.moves.impl;


import it.unibo.objectmon.model.battle.damage.DamageCalculator;
import it.unibo.objectmon.model.battle.damage.DamageCalculatorImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.Skill;

import java.util.Random;
/**
 * an attack move using a skill of pokemon. 
*/
public class AttackMove {
    private static int maxAccuracy = 100;
    private final Skill skill;
    private final Random random = new Random();
    /**
     * 
     * @param skill to be used
     */
    public AttackMove(final Skill skill) {
        this.skill = skill;
    }
    /**
     * use skill to attack the target.
     * @param objectmon use the skill
     * @param target to be attacked
     */
    public void action(final Objectmon objectmon, final Objectmon target) {
        if (this.hitSuccessful(this.skill.getAccuracy())) {
            final DamageCalculator calculator = new DamageCalculatorImpl(skill);
            final int hp = (int) calculator.damage(objectmon, target);
            target.setCurrentHp(-hp);
        }
    }
    /**
     * calculate the probability to hit the target.
     * @param accuracy the accuracy of the skill.
     * @return true if skill has hit the target
     */
    private boolean hitSuccessful(final int accuracy) {
        return random.nextInt(AttackMove.maxAccuracy) < accuracy;
    }
}
