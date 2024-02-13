package it.unibo.objectmon.model.data.objectmon;

import java.util.List;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.statistics.ActualStats;

/**
 * Read only wrapper of Onbjectmon, to limit who can access.
 */
public class ObjectmonReadOnly implements Objectmon {

    private final Objectmon objectmon;

    /**
     * Constructor of the class ObjectmonReadOnly.
     * @param objectmon the Objectmon that needs to become read only.
     */
    public ObjectmonReadOnly(final Objectmon objectmon) {
        this.objectmon = new ObjectmonImpl(objectmon);
    }
    @Override
    public final ActualStats getStats() {
        return this.objectmon.getStats();
    }

    @Override
    public final String getName() {
        return this.objectmon.getName();
    }

    @Override
    public final int getLevel() {
        return this.objectmon.getLevel();
    }

    @Override
    public final List<Aspect> getAspects() {
        return this.objectmon.getAspects();
    }
    @Override
    public final List<Skill> getSkills() {
        return this.objectmon.getSkills();
    }

    @Override
    public final int getExp() {
        return this.objectmon.getExp();
    }

    @Override
    public final void calcExp(final int gainedExp) {
        throw new UnsupportedOperationException("ObjectmonReadOnly can't be modified");
    }

    @Override
    public final int getCurrentHp() {
        return this.objectmon.getCurrentHp();
    }

    @Override
    public final void setCurrentHp(final int quantity) {
        throw new UnsupportedOperationException("ObjectmonReadOnly can't be modified");
    }
}
