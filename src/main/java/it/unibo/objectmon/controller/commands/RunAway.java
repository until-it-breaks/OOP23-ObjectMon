package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.battle.moves.type.Move;
/**
 * Attemps to run away from the battle.
 */
public final class RunAway implements Command {

    @Override
    public void execute(final Model model) {
        model.bufferCommand(Move.RUN_AWAY, 0);
    }
}
