package it.unibo.objectmon.model.battle.damageCalculator;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
/**
 * A Calculator that given a skill, it calculate the damage to the target, 
 * considering statics of Objectmon.
 */
public interface DamageCalculator {
    /**
     * calculate the damage.
     * @param myObjectmon objectmon that use the skill
     * @param target objectmon that will be attacked by
     * @return the damage made to the target
     */
    double damage(Objectmon myObjectmon, Objectmon target);
} 
