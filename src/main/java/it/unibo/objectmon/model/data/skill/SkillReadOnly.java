package it.unibo.objectmon.model.data.skill;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;

public class SkillReadOnly implements Skill {

    private Skill skill;

    public SkillReadOnly(Skill skill) {
        this.skill = skill;
    }

    @Override
    public int getId() {
        return skill.getId();
    }

    @Override
    public Aspect getAspect() {
        return skill.getAspect();
    }

    @Override
    public int getAccuracy() {
        return skill.getAccuracy();
    }

    @Override
    public int getBasePower() {
        return skill.getBasePower();
    }

    @Override
    public int getMaxUses() {
        return skill.getMaxUses();
    }

    @Override
    public String getName() {
        return skill.getName();
    }

    @Override
    public int getCurrentUses() {
        return skill.getCurrentUses();
    }

    @Override
    public SkillCategory getCategory() {
        return skill.getCategory();
    }

    @Override
    public void resetCurrentUses() {
        throw new UnsupportedOperationException("Unimplemented method 'resetCurrentUses'");
    }

    @Override
    public void subtractCurrentUses() {
        throw new UnsupportedOperationException("Unimplemented method 'subtractCurrentUses'");
    }
    
}
