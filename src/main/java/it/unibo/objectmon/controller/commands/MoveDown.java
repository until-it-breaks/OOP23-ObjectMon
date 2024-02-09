package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.entities.api.Direction;

/**
 * Attempts to move the player down by one unit.
 */
public final class MoveDown implements Command {
    @Override
    public void execute(final Model model) {
        model.getGameContext().getPlayer().move(Direction.DOWN, model.getCollisionChecker());
    }
}
