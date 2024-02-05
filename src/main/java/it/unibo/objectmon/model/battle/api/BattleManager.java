package it.unibo.objectmon.model.battle.api;
import java.util.Optional;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.api.Trainer;
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
     */
    void startTurn();
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
     * leave the battle.
     */
    void runAway();
    /**
     * use a skill of objectmon given an index.
     * @param index index of the skill of objectmon.
     */
    void useSkill(int index);
    /**
     * switch current objectmon with given index.
     * @param index index of the objectmon in the team
     */
    void switchObjectmon(int index);
}
