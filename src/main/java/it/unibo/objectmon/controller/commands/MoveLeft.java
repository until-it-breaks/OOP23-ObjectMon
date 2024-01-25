package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.entity.api.Player;

/**
 * Moves the player left by one unit.
 */
public final class MoveLeft implements Command {
    @Override
    public void execute(final Model model) {
        final Player player = model.getPlayer();
        player.moveLeft();
    }
}
