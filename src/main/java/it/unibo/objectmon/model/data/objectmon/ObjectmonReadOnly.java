package it.unibo.objectmon.model.data.objectmon;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.data.api.elementalType.Aspect;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.skill.SkillReadOnly;
import it.unibo.objectmon.model.data.statistics.ActualStats;

/**
 * Read only wrapper of Objectmon, to limit view access.
 */
@SuppressFBWarnings(
    value = "EI_EXPOSE_REP2",
    justification = "By design this provides read-only information outside of the model."
)
public class ObjectmonReadOnly implements Objectmon {

    private final Objectmon objectmon;

    /**
     * Constructor of the class ObjectmonReadOnly.
     * 
     * @param objectmon the Objectmon that needs to become read only.
     */
    public ObjectmonReadOnly(final Objectmon objectmon) {
        this.objectmon = objectmon;
    }

    @Override
    public final ActualStats getStats() {
        return this.objectmon.getStats();
    }

    @Override
    public final UUID getUuid() {
        return this.objectmon.getUuid();
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
    public final List<Aspect> getElementalTypes() {
        return this.objectmon.getElementalTypes();
    }

    @Override
    public final List<Skill> getSkills() {
        final List<Skill> out = new ArrayList<>();
        for (final Skill skill : this.objectmon.getSkills()) {
            out.add(new SkillReadOnly(skill));
        }
        return out;
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
