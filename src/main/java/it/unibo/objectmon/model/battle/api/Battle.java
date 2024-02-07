package it.unibo.objectmon.model.battle.api;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
/**
 * A battle between a player and a npc fighter or wild ObjectMon.
 * @param <T> is an entity of fighter.
 */
public interface Battle<T> { 
    /**
     * 
     * @return if player win the battle or not.
     */
    boolean isWin();

    /**
     * 
     * @return get the last move of the battle
     */
    Move getMove();
    /**
     * @param fighter a fighter who execute the move
     * @param move a move that going to be executed.
     */
    void setMove(T fighter, Move move);
    /**
     * 
     * @return get current objectmon 
     */
    Objectmon getCurrentObjectmon();
    /**
     * 
     * @return get current enemy objectmon 
     */
    Objectmon getEnemyObjectmon();
}
