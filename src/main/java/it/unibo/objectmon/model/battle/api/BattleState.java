package it.unibo.objectmon.model.battle.api;
import java.util.Optional;
/**
 * current state of the battle.
 * @param <T> is an entity of fighter
 * @param <O> is an ObjectMon 
 */
public interface BattleState<T, O> {
    /**
     * @return current stats of the player.
     */
    T getPlayerStats();
    /**
     * get objectmon actualstats in fight.
     * @return current stats of the objectmon in fight of player
     */
    O getPlayerObjctmonStats();
    /**
     * 
     * @return current stats of trainer.
     */
    Optional<T> getTrainerStats();
    /**
     * 
     * @return current stats of the objectmon as enemy.
     */
    O getEnemyObjectmonStats();
}
