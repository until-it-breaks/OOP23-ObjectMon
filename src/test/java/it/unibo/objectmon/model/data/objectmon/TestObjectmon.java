package it.unibo.objectmon.model.data.objectmon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.PotencyChart;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.skill.SkillImpl;
import it.unibo.objectmon.model.data.statistics.BaseStats;
/**
 *  Test of the Objectmon package.
 */
class TestObjectmon {

    /**
     *  Test of an Objectmon.
     */
    @Test
    void testObjectmon() {
        final List<SkillImpl> skills = new ArrayList<>();
        final int skill0BasePower = 40;
        final int skill0MaxUses = 35;
        skills.add(new SkillImpl("Tackle", 0, Aspect.NORMAL, skill0BasePower, 100, skill0MaxUses, SkillCategory.PHYS));
        final int sKill1BasePower = 120;
        final int skill1MaxUses = 8;
        skills.add(new SkillImpl("Close Combat", 1, Aspect.FIGHTING, sKill1BasePower, 100, skill1MaxUses, SkillCategory.PHYS));
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
        final Objectmon  objectmon = new ObjectmonImpl(0, "Zigzagoon", List.of(Aspect.NORMAL), skills, stats, level);

        assertTrue(Aspect.NORMAL.sameAspect(objectmon.getAspect()));
        final int skillid = 1;
        assertEquals("Close Combat", objectmon.getSkills().get(skillid).getName());

        // Attacking another Objectmon that's the same.
        final double multi = 2.00;
        final PotencyChart potency = PotencyChart.getChart(objectmon.getSkills().get(skillid).getAspect());
        assertEquals(multi, potency.potencyMultiplier(objectmon.getAspect(), objectmon.getAspect()));
    }

    /**
     *  Test of the ObjectmonReadOnly.
     */
    @Test
    void testObjectmonReadOnly() {
        final int oldLevel = 5;
        final Objectmon objectmon = ObjectmonFactory.createObjectmon(ObjectmonEnum.KECLEON, oldLevel);

        final int gainedExp = 1000;
        objectmon.calcExp(gainedExp);
        final int newLevel = 15;
        assertEquals(newLevel, objectmon.getLevel());

        final Objectmon readonly = new ObjectmonReadOnly(objectmon);
        boolean canNotModify = false;
        try {
            readonly.calcExp(gainedExp);
        } catch (UnsupportedOperationException e) {
            canNotModify = true;
        }
        assertTrue(canNotModify);
        canNotModify = false;
        try {
            final int gainedHp = 100;
            readonly.setCurrentHp(gainedHp);
        } catch (UnsupportedOperationException e) {
            canNotModify = true;
        }
        assertTrue(canNotModify);
    }
}
