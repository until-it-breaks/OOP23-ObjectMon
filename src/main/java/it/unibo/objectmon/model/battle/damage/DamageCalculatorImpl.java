package it.unibo.objectmon.model.battle.damage;


import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.PotencyChart;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;
import it.unibo.objectmon.model.data.api.statistics.StatId;
/**
 * a damage calculator calculate the damage in a simple way.
 */
public class DamageCalculatorImpl implements DamageCalculator {
    private static final int LEVEL_MULTIPLIER = 2;
    private static final int ATTACK_DIVISOR = 5;
    private static final int BASE_DAMAGE_ADDITION = 2;
    private static final int DAMAGE_DIVISOR = 50;
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
        final PotencyChart potencyChart = PotencyChart.getChart(this.skill.getAspect());
        final double multiplier = potencyChart.potencyMultiplier(myObjectmon.getAspect(), target.getAspect());
        if (skill.getCategory().equals(SkillCategory.PHYS)) {
            return calculateDamage(
                multiplier,
                myObjectmon.getStats().getSingleStat(StatId.ATK),
                target.getStats().getSingleStat(StatId.DEF),
                myObjectmon
            );
        } else if (skill.getCategory().equals(SkillCategory.SPEC)) {
            return calculateDamage(
                multiplier,
                myObjectmon.getStats().getSingleStat(StatId.SPATK),
                target.getStats().getSingleStat(StatId.SPDEF),
                myObjectmon);
        }
        return 0;
    }

    private double calculateDamage(final double multiplier, final int attack, final int defense, final Objectmon objectmon) {
        return (
            (LEVEL_MULTIPLIER * objectmon.getLevel() / ATTACK_DIVISOR + BASE_DAMAGE_ADDITION) 
            * (double) this.skill.getBasePower() * ((double) attack / defense)) / DAMAGE_DIVISOR * multiplier;
    }
}
