package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameState;
import it.unibo.objectmon.model.entities.Player;

public class MoveDown implements Command {

    @Override
    public void execute(final GameState gameState) {
        Player player = gameState.getPlayer();
        player.moveDown();
    }
    
}
