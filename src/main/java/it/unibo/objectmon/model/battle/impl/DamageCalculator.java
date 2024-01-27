package it.unibo.objectmon.model.battle.impl;


import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.skill.PotencyChart;
import it.unibo.objectmon.api.data.skill.Skill;
import it.unibo.objectmon.api.data.skill.SkillCategory;
import it.unibo.objectmon.api.data.statistics.StatId;

/**
 * A Calculator that given a skill, it calculate the damage to the target, 
 * considering statics of Objectmon.
 */
public class DamageCalculator {
    private final Skill skill;
    /**
     * Constructor of DamageCalculator.
     * @param skill skill to be used
     */
    public DamageCalculator(final Skill skill) {
        this.skill = skill;
    }
    /**
     * calculate the damage.
     * @param myObjectmon objectmon that use the skill
     * @param target objectmon that will be attacked by myObjectmon
     * @return the damage made to the target
     */
    public double damage(final Objectmon myObjectmon, final Objectmon target) {
        final PotencyChart potencyChart = PotencyChart.getChart(this.skill.getAspect().getAspectId());
        final double multiplier = potencyChart.potencyMultiplier(target.getAspect());
        if (skill.getCategory().equals(SkillCategory.PHYS)) {
            return calculateDamage(
                multiplier, 
                myObjectmon.getStats().getSingleStat(StatId.ATK), 
                target.getStats().getSingleStat(StatId.DEF)
            );
        } else if (skill.getCategory().equals(SkillCategory.SPEC)) {
            return calculateDamage(
                multiplier, 
                myObjectmon.getStats().getSingleStat(StatId.SPATK),
                target.getStats().getSingleStat(StatId.SPDEF));
        }
        return 0;
    }

    private double calculateDamage(final double multiplier, final int attack, final int defense) {
        return attack + (multiplier * skill.getBasePower()) - defense;
    }
}
