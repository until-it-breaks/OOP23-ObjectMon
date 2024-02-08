package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.entity.api.Direction;

/**
 * Attempts to move the player left by one unit.
 */
public final class MoveLeft implements Command {
    @Override
    public void execute(final Model model) {
        model.getPlayer().move(Direction.LEFT, model.getCollisionChecker());
    }
}
