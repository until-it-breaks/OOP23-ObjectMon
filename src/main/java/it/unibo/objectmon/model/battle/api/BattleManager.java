package it.unibo.objectmon.model.battle.api;
import java.util.Optional;

import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;

/**
 * A manager of battle which can start a battle between the player and a fighter.
 */
public interface BattleManager {
    /**
     * Enum representing the result of a battle.
     * It can be either WIN or LOSE.
     */
    enum Result {
        /**
         * Represents the result of winning the battle.
         */
        WIN, 
        /**
         * Represents the result of losing the battle.
         */
        LOSE,
        /**
         * Represents the battle has not finished.
         */
        IN_BATTLE
    }

    /**
     * this method should start battle.
     * @param player should not be null, if is null the method should throw IllegalArgumentException.
     * @param enemy it is enemy because if the player meet a wild ObjectMon, the  enemy should be empty
     * @param objectMon it is wild objectMon, if player meet a fighter, then objectMon should be empty
     */
    void startBattle(Player player, Optional<Trainer> enemy, Optional<Objectmon> objectMon);
    /**
     * start a new turn.
     * @param type type of move
     * @param index index of the e-th element in the list.
     */
    void startTurn(Move type, int index);
    /**
     * @return the result of the battle
     */
    Result getResult();
    /**
     * 
     * @param result set the result of the battle.
     */
    void setResult(Result result);
    /**
     * @return true if the battle isOver
     */
    boolean isOver();
    /**
     * receive commands from player and give it to turn when it is necessary.
     * @param type type of move
     * @param index index of the e-th element in the list.
     */
    void bufferCommand(Move type, int index);
}
