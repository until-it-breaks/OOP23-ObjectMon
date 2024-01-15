package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameState;
import it.unibo.objectmon.model.entities.Player;

/**
 * Moves the player right by one unit.
 */
public final class MoveRight implements Command {
    @Override
    public void execute(final GameState gameState) {
        final Player player = gameState.getPlayer();
        player.moveRight();
    }
}
