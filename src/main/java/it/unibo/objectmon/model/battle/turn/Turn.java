package it.unibo.objectmon.model.battle.turn;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;

/**
 * turn should choose in the battle who has the priority to use an move.
 */
public interface Turn {
    /**
     * 
     * @param moveAI type move of AI
     * @param movePLayer type move of player
     * @param playerObjectmon current objectmon of player
     * @param aiObjectmon current objectmon of ai
     * @return who has the first turn.
     */
    StatTurn whichFirst(Move moveAI, Move movePLayer, Objectmon playerObjectmon, Objectmon aiObjectmon);
    /**
     * 
     * @return get Stat turn.
     */
    StatTurn getStat();
    /**
     * 
     * @param statTurn current stat turn.
     */
    void setTurn(StatTurn statTurn);
}
