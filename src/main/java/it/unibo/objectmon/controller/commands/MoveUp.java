package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.entities.api.Direction;

/**
 * Attempts to move the player up.
 */
public final class MoveUp implements Command {

    @Override
    public void execute(final Model model) {
        model.getGameContext().getPlayer().move(Direction.UP, model.getCollisionManager());
    }
}
