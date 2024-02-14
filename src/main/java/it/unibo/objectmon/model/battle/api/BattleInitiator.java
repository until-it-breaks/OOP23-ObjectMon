package it.unibo.objectmon.model.battle.api;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import java.util.Optional;

/**
 * A listener interface for handling events related to the start of battles.
 * Implementations of this interface can be used to receive notifications when
 * battles are initiated.
 */
public interface BattleInitiator {

    /**
     * Called when a battle is about to start.
     *
     * @param player    The player initiating the battle.
     * @param trainer   An optional Trainer involved in the battle. If present, it represents
     *                  the opponent Trainer. If empty, the battle is a wild encounter.
     * @param objectmon An optional Objectmon involved in the battle. If present, it represents
     *                  a wild encounter. If empty, the trainer has its own Objectmons.
     */
    void onStartBattle(Player player, Optional<Trainer> trainer, Optional<Objectmon> objectmon);
}
