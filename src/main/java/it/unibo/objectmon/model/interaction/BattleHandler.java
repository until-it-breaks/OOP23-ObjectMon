package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.PlayerController;
import it.unibo.objectmon.model.interaction.api.InteractionHandler;
import java.util.logging.Logger;
/**
 * Models the behaviour of a trainer npc.
 */
public final class BattleHandler implements InteractionHandler {
    private final Logger logger = Logger.getLogger(BattleHandler.class.getName());
    @Override
    public void handleInteraction(final PlayerController player) {
        logger.info("Battle starts for " + player.getName());
    }
}
