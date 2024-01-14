package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.model.entities.Player;

public class MoveLeft implements Command{

    @Override
    public void execute(final GameModel model) {
        Player player = model.getPlayer();
        player.moveLeft();
    }
    
}
