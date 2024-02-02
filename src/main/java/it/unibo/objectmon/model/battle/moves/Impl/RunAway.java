package it.unibo.objectmon.model.battle.moves.impl;

import java.util.Optional;

import it.unibo.objectmon.model.battle.api.Battle;

/**
 * Player leave the battle.
 */
public class RunAway {
    /**
     * method to leave the battle.
     * @param battle battle to leave
     */
    public void action(final Battle battle) {
    }
    /**
     * if player can run away.
     * @param battle 
     * @return true if there is no trainer in the battle.
     */
    public boolean runnable(final Battle battle) {
        return battle.getTrainer().equals(Optional.empty());
    }
}
