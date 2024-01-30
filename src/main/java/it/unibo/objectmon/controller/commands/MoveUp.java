package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;

/**
 * Moves the player up by one unit.
 */
public final class MoveUp implements Command {
    @Override
    public void execute(final Model model) {
        model.getGameManager().getPlayerController().moveUp();
    }
}
