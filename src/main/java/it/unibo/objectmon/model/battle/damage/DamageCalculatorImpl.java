package it.unibo.objectmon.model.battle.damage;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.skill.PotencyChart;
import it.unibo.objectmon.api.data.skill.Skill;
import it.unibo.objectmon.api.data.skill.SkillCategory;
import it.unibo.objectmon.api.data.statistics.StatId;
/**
 * a damage calculator calculate the damage in a simple way.
 */
public class DamageCalculatorImpl implements DamageCalculator {
    private final Skill skill;
    /**
     * Constructor of DamageCalculator.
     * @param skill skill to be used
     */
    public DamageCalculatorImpl(final Skill skill) {
        this.skill = skill;
    }

    @Override
    public final double damage(final Objectmon myObjectmon, final Objectmon target) {
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
