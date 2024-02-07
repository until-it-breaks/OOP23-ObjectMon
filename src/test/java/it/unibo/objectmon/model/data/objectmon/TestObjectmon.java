package it.unibo.objectmon.model.data.objectmon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.PotencyChart;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.statistics.BaseStats;
/**
 *  Test of Objectmon.
 */
class TestObjectmon {

    /**
     *  Test of an Objectmon.
     */
    @Test
    void testSingleObjectmon() {
        final List<Skill> skills = new ArrayList<>();
        final int skill0BasePower = 40;
        final int skill0MaxUses = 35;
        skills.add(new Skill("Tackle", 0, Aspect.NORMAL, skill0BasePower, 100, skill0MaxUses, SkillCategory.PHYS));
        final int sKill1BasePower = 120;
        final int skill1MaxUses = 8;
        skills.add(new Skill("Close Combat", 1, Aspect.FIGHTING, sKill1BasePower, 100, skill1MaxUses, SkillCategory.PHYS));
        final BaseStats stats = new BaseStats(
            Map.of(
            StatId.HP, 60,
            StatId.ATK, 60,
            StatId.DEF, 60,
            StatId.SPATK, 60,
            StatId.SPDEF, 60,
            StatId.SPD, 60
            )
        );
        final int level = 5;
        final ObjectmonImpl  objectmon = new ObjectmonImpl(0, "Zigzagoon", List.of(Aspect.NORMAL), skills, stats, level);

        assertTrue(Aspect.NORMAL.sameAspect(objectmon.getAspect()));
        final int skillid = 1;
        assertEquals("Close Combat", objectmon.getSkill(skillid).getName());

        // Attacking another Objectmon that's the same.
        final double multi = 2.00;
        final PotencyChart potency = PotencyChart.getChart(objectmon.getSkill(skillid).getAspect().getAspectId());
        assertEquals(multi, potency.potencyMultiplier(objectmon.getAspect()));

    }
}
