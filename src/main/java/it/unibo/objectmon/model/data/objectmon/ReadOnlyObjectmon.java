package it.unibo.objectmon.model.data.objectmon;

import java.util.List;
import java.util.UUID;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.data.api.elementalType.Aspect;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.statistics.ActualStats;

/**
 * read only objectmon, cannot set or modify any informations of objectmon.
 */
public final class ReadOnlyObjectmon implements Objectmon {
    private final Objectmon objectmon;

    /**
     * constructs a read only objectmon.
     * @param objectmon the objectmon to be wrapped
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "take the objectmon just for read, this class garantee no modification on objectmon")
    public ReadOnlyObjectmon(final Objectmon objectmon) {
        this.objectmon = objectmon;
    }

    @Override
    public ActualStats getStats() {
        return this.objectmon.getStats();
    }

    @Override
    public UUID getUuid() {
        return this.objectmon.getUuid();
    }

    @Override
    public String getName() {
        return this.objectmon.getName();
    }

    @Override
    public int getLevel() {
        return this.objectmon.getLevel();
    }

    @Override
    public List<Aspect> getElementalTypes() {
        return this.objectmon.getElementalTypes();
    }

    @Override
    public List<Skill> getSkills() {
        return this.objectmon.getSkills();
    }

    @Override
    public int getExp() {
        return this.objectmon.getExp();
    }

    @Override
    public void calcExp(final int gainedExp) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCurrentHp() {
        return this.objectmon.getCurrentHp();
    }

    @Override
    public void setCurrentHp(final int quantity) {
        throw new UnsupportedOperationException();
    }
}
