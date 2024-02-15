package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 * End game Command.
 */
public final class EndGame implements Command {

    @Override
    public void execute(final Model model) {
        if (model.getGameState().equals(GameState.PAUSE)) {
           model.getEndGameManager().startEnd();
        }
    }
}
