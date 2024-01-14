package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.model.GameState;
import it.unibo.objectmon.model.entities.Player;

public class MoveUp implements Command {

    @Override
    public void execute(final GameState gameState) {
        Player player = gameState.getPlayer();
        player.moveUp();
    }
    
}
