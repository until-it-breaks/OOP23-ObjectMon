package it.unibo.objectmon.model.battle.api;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;

/**
 * turn should choose in the battle who has the priority to use an move.
 */
public interface Turn {
    /**
     * stat turn of.
     */
    enum StatTurn {
        /**
         * waiting player choose a move.
         */
        IS_WAITING_MOVE,
        /**
         * AI (trainer or Objectmon) can start to execute his move.
         */
        AI_TURN,
        /**
         * player can start execute his move.
         */
        PLAYER_TURN,
        /**
         * when player and AI execute their moves.
         */
        TURN_COMPLETE
    }
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
