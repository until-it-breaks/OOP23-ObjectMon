package it.unibo.objectmon.model.battle.impl;


import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.skill.PotencyChart;
import it.unibo.objectmon.api.data.skill.Skill;
import it.unibo.objectmon.model.battle.api.Move;

public class AttackMove implements Move{

    private final Objectmon myObjectmon;
    private final Objectmon enemy;
    private final Skill skill;
    
    public AttackMove(Objectmon myObjectmon, Objectmon enemy, Skill skill) {
        this.myObjectmon = myObjectmon;
        this.enemy = enemy;
        this.skill = skill;
    }

    @Override
    public void action() {
    }

    
    
}
