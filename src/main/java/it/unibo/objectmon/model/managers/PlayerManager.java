package it.unibo.objectmon.model.managers;

import it.unibo.objectmon.model.entities.Player;

public class PlayerManager {

    private Player player;

    public void start() {
        player = new Player("Player1", 0, 0);
    }

    public Player getPlayer() {
        return this.player;
    }
    
}
