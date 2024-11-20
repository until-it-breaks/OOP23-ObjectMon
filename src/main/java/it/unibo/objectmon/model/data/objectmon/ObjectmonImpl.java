package it.unibo.objectmon.model.data.objectmon;

import java.util.List;
import java.util.UUID;

import it.unibo.objectmon.model.data.api.elementalType.Aspect;
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

    private final UUID uuid;
    private final String name;
    private final List<Aspect> aspects;
    private final List<Skill> skills;
    private ActualStats stats;
    private int currentHp;
    private int level;
    private int exp;
    private static final int MAX_EXP = 100;

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
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.aspects = List.copyOf(aspects);
        this.skills = List.copyOf(skills);
        this.stats = new ActualStats(stats);
        this.currentHp = this.stats.getSingleStat(StatId.HP);
        this.level = level;
        this.exp = 0;
    }

    /**
     * Constructor of the class ObjectmonImpl with a ObjectmonEnum.
     *
     * @param objEnum The ObjectmonEnum.
     * @param level The Objectmon's level.
     */
    public ObjectmonImpl(final ObjectmonEnum objEnum, final int level) {
        this.uuid = UUID.randomUUID();
        this.name = objEnum.getName();
        this.aspects = List.copyOf(objEnum.getAspects());
        this.skills = List.copyOf(objEnum.getSkills());
        this.stats = objEnum.getStats();
        this.currentHp = this.stats.getSingleStat(StatId.HP);
        this.level = level;
        this.exp = 0;
    }

    /**
     * Constructor of the class ObjectmonImpl with Objectmon.
     *
     *
     * @param objectmon The Objectmon.
     */
    public ObjectmonImpl(final Objectmon objectmon) {
        this.uuid = UUID.randomUUID();
        this.name = objectmon.getName();
        this.aspects = List.copyOf(objectmon.getElementalTypes());
        this.skills = List.copyOf(objectmon.getSkills());
        this.level = objectmon.getLevel();
        this.stats = objectmon.getStats().calcNewStats(level);
        this.exp = 0;
    }

    @Override
    public ActualStats getStats() {
        return this.stats;
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
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
    public List<Aspect> getElementalTypes() {
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

    @Override
    public void calcExp(final int gainedExp) {
        setExp(gainedExp);
        while (getExp() >= MAX_EXP) {
            setExp(getExp() - MAX_EXP);
            levelUp();
        }
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

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ObjectmonImpl other = (ObjectmonImpl) obj;
        return uuid == null ? other.uuid == null : uuid.equals(other.uuid);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
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
     *
     * @param exp New quantity of exp.
     */
    private void setExp(final int exp) {
        this.exp = exp;
    }

    /**
     * Method that levels up an Objectmon and grows its stats.
     * It's an utility method.
     * Should only be called by calcExp.
     */
    private void levelUp() {
        addLevel();
        final ActualStats newStats = getStats().calcNewStats(1);
        final int growth = newStats.getSingleStat(StatId.HP) - this.stats.getSingleStat(StatId.HP);
        this.stats = newStats;
        setCurrentHp(growth);
    }

}
