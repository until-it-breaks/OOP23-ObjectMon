package it.unibo.objectmon.model;

import it.unibo.objectmon.model.managers.PlayerManager;

public class GameModel {
    /*Only handles the player. For now.... */
    private final PlayerManager playerManager = new PlayerManager();

    public GameModel() {
        playerManager.start();
    }

    public PlayerManager getPlayerManager() {
        return this.playerManager;
    }
}
