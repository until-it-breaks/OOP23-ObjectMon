package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;

/**
 * Moves the player down by one unit.
 */
public final class MoveDown implements Command {
    @Override
    public void execute(final Model model) {
        model.getGameManager().getPlayerController().moveDown();
    }
}
