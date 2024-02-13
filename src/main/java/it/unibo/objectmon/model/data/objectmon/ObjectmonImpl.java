package it.unibo.objectmon.model.data.objectmon;

import java.util.List;
import java.util.Objects;
import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.skill.SkillImpl;
import it.unibo.objectmon.model.data.statistics.ActualStats;
import it.unibo.objectmon.model.data.statistics.BaseStats;

/**
 * Implementation of the interface Objectmon.
 */
public final class ObjectmonImpl implements Objectmon {

    private final String name;
    private final List<Aspect> aspects;
    private final List<Skill> skills;
    private ActualStats stats;
    private int currentHp;
    private int level;
    private int exp;
    private static final int MAXEXP = 100;

    /**
     * Constructor of the class ObjectmonImpl.java.
     * 
     * @param name The name of the Objectmon.
     * @param aspects The aspects of the Objectmon.
     * @param skills The skills of the Objectmon.
     * @param stats The stats of the Objectmon.
     * @param level The level of the Objectmon.
     */
    public ObjectmonImpl(
        final String name,
        final List<Aspect> aspects,
        final List<SkillImpl> skills,
        final BaseStats stats,
        final int level
        ) {
        this.name = name;
        this.aspects = List.copyOf(aspects);
        this.skills = List.copyOf(skills);
        this.stats = new ActualStats(stats);
        this.currentHp = this.stats.getSingleStat(StatId.HP);
        this.level = level;
        this.exp = 0;
    }

    /**
     * Constructor of the class ObjectmonImpl with Objectmon.
     * 
     * @param objectmon The Objectmon.
     */
    public ObjectmonImpl(final Objectmon objectmon) {
        this.name = objectmon.getName();
        this.aspects = List.copyOf(objectmon.getAspects());
        this.skills = List.copyOf(objectmon.getSkills());
        this.level = objectmon.getLevel();
        this.stats = objectmon.getStats().calcNewStats(level);
        this.exp = 0;
    }

    /**
     * Constructor of the class ObjectmonImpl with an ObjectmonEnum and level.
     * 
     * @param objectmonEnum The ObjectmonEnum to copy.
     * @param level The level to copy.
     */
    public ObjectmonImpl(final ObjectmonEnum objectmonEnum, final int level) {
        this.name = objectmonEnum.getName();
        this.aspects = List.copyOf(objectmonEnum.getAspects());
        this.skills = List.copyOf(objectmonEnum.getSkills());
        this.level = level;
        this.stats = objectmonEnum.getStats().calcNewStats(level);
        this.exp = 0;
    }



    @Override
    public ActualStats getStats() {
        return this.stats;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public List<Aspect> getAspects() {
        return List.copyOf(this.aspects);
    }

    @Override
    public List<Skill> getSkills() {
        return List.copyOf(this.skills);
    }

    @Override
    public int getExp() {
        return this.exp;
    }

    /**
     * Method that adds a level to an Objectmon.
     * It's an utility method.
     * Should only be called by the method levelUp.
     * Adds a level to the Objectmon, max 100.
     */
    private void addLevel() {
        if (getLevel() < 100) {
            this.level++;
        }
    }

    /**
     * Setter of the Objectmon's exp.
     * @param exp New quantity of exp.
     */
    private void setExp(final int exp) {
        this.exp = exp;
    }

    @Override
    public void calcExp(final int gainedExp) {
        setExp(gainedExp);
        while (getExp() >= MAXEXP) {
            setExp(getExp() - MAXEXP);
            levelUp();
        }
    }

    /**
     * Method that levels up an Objectmon and grows its stats.
     * It's an utility method.
     * Should only be called by calcExp.
     */
    private void levelUp() {
        addLevel();
        this.stats = getStats().calcNewStats(1);
    }

    @Override
    public int getCurrentHp() {
        return this.currentHp;
    }

    @Override
    public void setCurrentHp(final int quantity) {
        final int value = this.currentHp + quantity;
        final int maxHp = getStats().getSingleStat(StatId.HP);

        if (value > maxHp) {
            this.currentHp = maxHp;
        } else if (value < 0) {
            this.currentHp = 0;
        } else {
            this.currentHp = value;
        }

    }

    /**
     * Method that compares an Objectmon with another to see if they're identical.
     * <br>If they are the same instance returns true.
     * If they have the same name and id returns true.
     * Everything else returns false.
     * @param obj Objectmon that needs to be compared.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        } else if (this == obj) {
            return true;
        }

        final ObjectmonImpl objmon = (ObjectmonImpl) obj;
        return getName().equals(objmon.getName());
    }

    /**
     * @return Returns the hash code value for Objectmon.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
