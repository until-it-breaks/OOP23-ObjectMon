package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.PlayerManager;
import it.unibo.objectmon.model.interaction.api.InteractionHandler;
import java.util.logging.Logger;
/**
 * Models the behaviour of a trader npc.
 */
public final class TradeHandler implements InteractionHandler {
    private final Logger logger = Logger.getLogger(TradeHandler.class.getName());
    @Override
    public void handleInteraction(final PlayerManager player) {
        logger.info("Trade started with " + player.getName());
    }
}
