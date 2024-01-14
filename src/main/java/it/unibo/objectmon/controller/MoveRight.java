package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.model.entities.Player;

public class MoveRight implements Command {

    @Override
    public void execute(final GameModel model) {
        Player player = model.getPlayer();
        player.moveRight();
    }
    
}
