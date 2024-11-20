package it.unibo.objectmon.model.data.api.objectmon;

import it.unibo.objectmon.model.data.api.elementalType.ElementalType;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.statistics.ActualStats;
import java.util.List;
import java.util.UUID;

/**
 * The interface of Objectmon.
 * An Objectmon can use Skills, and have changes to their Stats.
 */
public interface Objectmon {

    /**
     * Getter of an Objectmon's Stats.
     * 
     * @return Returns a copy of stats.
     */
    ActualStats getStats();

    /**
     * Getter of an Objectmon's uuid.
     * 
     * @return Return the Objectmon's uuid.
     */
    UUID getUuid();

    /**
     * Getter of an Objectmon's name.
     * 
     * @return Returns the Objectmon's name.
     */
    String getName();

    /**
     * Getter of an Objectmon's level.
     * 
     * @return Returns the Objectmon's level.
     */
    int getLevel();

    /**
     * Getter of an Objectmon's Aspects.
     * 
     * @return Returns the Objectmon's Aspects.
     */
    List<ElementalType> getElementalTypes();
    /**
     * Getter of an Objectmon's Skill.
     * 
     * @return Returns the skill with associated id.
     */
    List<Skill> getSkills();

    /**
     * Getter of an Objectmon's exp.
     * 
     * @return Returns the exp that the Objectmon has.
     */
    int getExp();

    /**
     *  Method that calculates the exp of an Objectmon.
     *  After adding gainedExp, checks if exp is >= 100
     *  and if it is, calls levelUp and removes 100 exp.
     *  Otherwise it just adds exp.
     * 
     *  @param gainedExp Exp gained after defeating an Objectmon.
     */
    void calcExp(int gainedExp);

    /**
     * Getter of the currentHp of the Objectmon.
     * 
     * @return Returns the currentHp of the Objectmon.
     */
    int getCurrentHp();

    /**
     * Setter of the currentHp of the Objectmon.
     * 
     * @param quantity Quantity of the Hp to be added to currentHp.
     */
    void setCurrentHp(int quantity);
}
