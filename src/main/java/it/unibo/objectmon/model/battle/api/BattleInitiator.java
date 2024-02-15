package it.unibo.objectmon.model.battle.api;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import java.util.Optional;

/**
 * A functional interface used to start a battle.
 */
public interface BattleInitiator {

    /**
     * Called when a battle needs to be started.
     *
     * @param player    The player initiating the battle.
     * @param trainer   An optional Trainer involved in the battle. If present, it represents
     *                  the opponent Trainer. If empty, the battle is a wild encounter.
     * @param objectmon An optional Objectmon involved in the battle. If present, it represents
     *                  a wild encounter. If empty, the trainer has its own Objectmons.
     */
    void startBattle(Player player, Optional<Trainer> trainer, Optional<Objectmon> objectmon);
}
