package it.unibo.objectmon.controller.moves_controller;
/**
 * view through this controller to choose which move to act.
 */
public interface BattleController {
    /**
     * when player choose run away the battle.
     * @return if player can run away or not.
     */
    boolean handleRunAway();
}
