package it.unibo.objectmon.model.battle.api;
import java.util.Optional;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.TrainerNpc;
/**
 * current state of the battle.
 */
public interface BattleState {
    /**
     * @return current stats of the player.
     */
    Player getPlayerStats();
    /**
     * get objectmon actualstats in fight.
     * @return current stats of the objectmon in fight of player
     */
    Objectmon getPlayerObjectmonStats();
    /**
     * 
     * @return current stats of trainer.
     */
    Optional<TrainerNpc> getTrainerStats();
    /**
     * 
     * @return current stats of the objectmon as enemy.
     */
    Objectmon getEnemyObjectmonStats();
}
