package it.unibo.objectmon.model.battle.turn;

import it.unibo.objectmon.model.battle.moves.type.Move;
/**
 * an entity like player, trainer or wildObjectmon will implement this interface to execute a move in a turn.
 */
public interface ExecuteTurn {
    /**
     * execute the move.
     * @param type type of move to execute.
     * @param index index of that type of move.
     */
    void execute(Move type, int index);
}
