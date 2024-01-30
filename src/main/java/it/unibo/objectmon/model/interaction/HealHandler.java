package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.PlayerManager;
import it.unibo.objectmon.model.interaction.api.InteractionHandler;
import java.util.logging.Logger;
/**
 * Models the behaviour of a healer npc.
 */
public final class HealHandler implements InteractionHandler {
    private final Logger logger = Logger.getLogger(HealHandler.class.getName());
    @Override
    public void handleInteraction(final PlayerManager player) {
        logger.info(player.getName() + "'s team has been healed");
    }
}
