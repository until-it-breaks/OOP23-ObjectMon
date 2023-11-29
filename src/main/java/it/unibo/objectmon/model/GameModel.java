package it.unibo.objectmon.model;

import java.util.ArrayList;
import java.util.List;

import it.unibo.objectmon.api.Manager;
import it.unibo.objectmon.model.managers.NPCManager;
import it.unibo.objectmon.model.managers.PlayerManager;

public class GameModel {
    /*Only handles the player. For now.... */
    private final List<Manager> managers = new ArrayList<>();
    private final NPCManager entityManager = new NPCManager();
    private final PlayerManager playerManager = new PlayerManager();

    public GameModel() {
        managers.add(playerManager);
        managers.add(entityManager);
        playerManager.start();
    }

    public PlayerManager getPlayerManager() {
        return this.playerManager;
    }
}
