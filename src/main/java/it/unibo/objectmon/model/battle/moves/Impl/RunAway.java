package it.unibo.objectmon.model.battle.moves.impl;

import java.util.Optional;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.api.Move;

/**
 * Player leave the battle.
 */
public class RunAway implements Move {
    private final Battle battle;
    /**
     * constructor that RunAway has to use battleManager to end the battle
     * @param battleManager
     */
    public RunAway(Battle battle) {
        this.battle = battle;
    }
    @Override
    public void action() {
        
    }
    /**
     * the player can leave the battle only if the enemy is wild objectmon.
     * @return true if there is no trainer in the battle
     */
    public boolean runnable() {
        return this.battle.getTrainer().equals(Optional.empty());
    }
}
