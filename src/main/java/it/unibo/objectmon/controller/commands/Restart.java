package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 *  Calls to restart the game.
 */
public final class Restart implements Command {

    @Override
    public void execute(final Model model) {
        //TEMPORARY
        model.setGameState(GameState.EXPLORATION);
    }

}
