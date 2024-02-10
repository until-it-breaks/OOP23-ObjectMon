package it.unibo.objectmon.model.data.api.objectmon;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.statistics.ActualStats;
import java.util.List;
/**
 * The interface of Objectmon.
 * An Objectmon can use Skills, and have changes to their Stats.
 */
    public interface Objectmon {
    /**
     * Getter of an Objectmon's Stats.
     * @return Returns a copy of stats.
     */
    ActualStats getStats();
    /**
     * Getter of an Objectmon's id.
     * @return Return the Objectmon's id.
     */
    int getId();
    /**
     * Getter of an Objectmon's name.
     * @return Returns the Objectmon's name.
     */
    String getName();
    /**
     * Getter of an Objectmon's level.
     * @return Returns the Objectmon's level.
     */
    int getLevel();
    /**
     * Getter of an Objectmon's Aspects.
     * @return Returns the Objectmon's Aspects.
     */
    List<Aspect> getAspect();
    /**
     * Getter of an Objectmon's Skill.
     * @param skillId The id of the skill
     * @return Returns the skill with associated id.
     */
    Skill getSkill(int skillId);
    /**
     * Getter of an Objectmon's exp.
     * @return Returns the exp that the Objectmon has.
     */
    int getExp();
    /**
     *  Method that calculates the exp of an Objectmon.
     *  After adding gainedExp, checks if exp is >= 100
     *  and if it is, calls levelUp and removes 100 exp.
     *  Otherwise it just adds exp.
     *  @param gainedExp Exp gained after defeating an Objectmon.
     */
    void calcExp(int gainedExp);
}
