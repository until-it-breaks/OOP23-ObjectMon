package it.unibo.objectmon.model.battle.api;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.battle.moves.api.Move;

/**
 * A battle between a player and a npc trainer or wild ObjectMon.
 */
public interface Battle { 
    /**
     * 
     * @return if player win the battle or not.
     */
    boolean isWin();
    /**
     * 
     * @return get the move of player
     */
    Move getPlayerMove();
    /**
     * @param move a move that going to be executed.
     */
    void setPlayerMove(Move move);
    /**
     * @param move a move that going to be executed.
     */
    void setEnemyMove(Move move);
    /**
     * 
     * @return get the move of player
     */
    Move getEnemyMove();
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
