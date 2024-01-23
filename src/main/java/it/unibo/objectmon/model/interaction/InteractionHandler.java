package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.entity.player.PlayerImpl;

public interface InteractionHandler {
    void handleInteraction(PlayerImpl player);
}
