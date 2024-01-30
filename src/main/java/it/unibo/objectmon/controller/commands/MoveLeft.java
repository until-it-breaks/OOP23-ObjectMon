package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;

/**
 * Moves the player left by one unit.
 */
public final class MoveLeft implements Command {
    @Override
    public void execute(final Model model) {
        model.getGameManager().getPlayerManager().moveLeft();
    }
}
