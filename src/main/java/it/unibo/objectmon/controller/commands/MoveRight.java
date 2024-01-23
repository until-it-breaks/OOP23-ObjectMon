package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.entities.player.Player;

/**
 * Moves the player right by one unit.
 */
public final class MoveRight implements Command {
    @Override
    public void execute(final Model model) {
        final Player player = model.getPlayer();
        player.moveRight();
    }
}
