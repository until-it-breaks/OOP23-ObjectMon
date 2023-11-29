package it.unibo.objectmon.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.objectmon.api.Entity;
import it.unibo.objectmon.api.Manager;
import it.unibo.objectmon.model.entities.NPC;
import it.unibo.objectmon.model.entities.Player;

public class EntityManager implements Manager {
    private final List<Entity> entities = new ArrayList<>();

    public void start() {
        entities.add(new Player("Player", 0, 0));
        entities.add(new NPC("Fisherman", 2, 4));
        entities.add(new NPC("Doctor", 5, 6));
        entities.add(new NPC("Trainer", 4, 3));
    }

    public Pair<Integer, Integer> getEntityPosition(String name) {
        for (Entity entity : entities) {
            if (entity.getName().equals(name)) {
                return Pair.of(entity.getX(), entity.getY());
            }
        }
        return null;
    } 
}
