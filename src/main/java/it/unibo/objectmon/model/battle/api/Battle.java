package it.unibo.objectmon.model.battle.api;

import java.util.Optional;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.entity.npc.api.Trainer;

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
    /**
     * get enemy trainer.
     * @return optional of trainer
     */
    Optional<Trainer> getTrainer();
    /**
     * 
     * @return team of player
     */
    ObjectmonParty getTeam();
    /**
     * 
     * @return HP of our current objectmon.
     */
    int getObjectmonHP();
    /**
     * 
     * @return HP of enemy current objectmon.
     */
    int getEnemyHP();
    /**
     * set our current Objectmon HP.
     * @param hp HP to set of current objectmon
     */
    void setObjectomHP(int hp);
    /**
     * set enemy current objectom HP.
     * @param hp HP to set of current objectmon
     */
    void setEnemyHP(int hp);
}
