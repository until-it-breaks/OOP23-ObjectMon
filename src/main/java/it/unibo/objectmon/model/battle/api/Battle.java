package it.unibo.objectmon.model.battle.api;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.TrainerNpc;
import java.util.Optional;
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
     * @param player player set the move.
     * @param move a move that going to be executed.
     */
    void setPlayerMove(Player player, Move move);
    /**
     * @param enemy enemy (trainer or wild Objectmon) set the move.
     * @param move a move that going to be executed.
     */
    void setEnemyMove(Optional<TrainerNpc> enemy, Move move);
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
