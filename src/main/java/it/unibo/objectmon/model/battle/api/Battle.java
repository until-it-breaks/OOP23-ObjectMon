package it.unibo.objectmon.model.battle.api;

import java.util.Optional;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.battle.moves.type.Move;

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
     * @return if player has no more objectmon.
     */
    boolean isLose();
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
     * set enemy move by AI.
     * @param move type of move
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
    ObjectmonParty getPlayerTeam();
    /**
     * 
     * @return get trainer team if trainer is present.
     */
    Optional<ObjectmonParty> getTrainerTeam();
}
