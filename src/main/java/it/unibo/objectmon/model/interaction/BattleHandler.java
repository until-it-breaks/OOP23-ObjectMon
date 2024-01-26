package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.interaction.api.InteractionHandler;
import java.util.logging.Logger;
/**
 * Models the behaviour of a trainer npc.
 */
public final class BattleHandler implements InteractionHandler {
    private final Logger logger = Logger.getLogger(BattleHandler.class.getName());
    @Override
    public void handleInteraction(final Player player) {
        logger.info("Battle starts for " + player.getName());
    }
}
