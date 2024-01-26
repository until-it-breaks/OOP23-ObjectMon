package it.unibo.objectmon.model.battle.api;
/**
 * A battle between a player and a npc fighter or wild ObjectMon.
 */
public interface Battle { 
    /**
     * 
     * @return if fighter win the battle or not.
     */
    boolean isWin();

    /**
     * 
     * @return get the last move of the battle
     */
    Move getMove();

    /**
     * 
     * @param move a move that going to be executed.
     */
    void setMove(Move move);
}
