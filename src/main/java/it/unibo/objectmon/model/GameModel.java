package it.unibo.objectmon.model;

import java.util.ArrayList;
import java.util.List;

import it.unibo.objectmon.api.Manager;

public class GameModel {
    private final List<Manager> managers = new ArrayList<>();
    private final EntityManager entityManager = new EntityManager();

    public GameModel() {
        managers.add(entityManager);
        for (Manager manager : managers) {
            manager.start();
        }
    }

    public int getPlayerX() {
        return entityManager.getEntityPosition("Player").getLeft();
    }

    public int getPlayerY() {
        return entityManager.getEntityPosition("Player").getRight();
    }
}
