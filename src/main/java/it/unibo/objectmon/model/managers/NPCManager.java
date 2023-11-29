package it.unibo.objectmon.model.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.objectmon.api.Entity;
import it.unibo.objectmon.api.Manager;
import it.unibo.objectmon.model.entities.NPC;

public class NPCManager implements Manager {
    private final List<NPC> entities = new ArrayList<>();

    public void start() {
        entities.add(new NPC("Fisherman", 0, 0));
        entities.add(new NPC("Trainer", 0, 1));
        entities.add(new NPC("Fisherman", 0, 2));
    }

    public Pair<Integer, Integer> getNPCPosition(String name) {
        for (Entity entity : entities) {
            if (entity.getName().equals(name)) {
                return Pair.of(entity.getX(), entity.getY());
            }
        }
        return null;
    }

    public List<NPC> getEntities() {
        return Collections.unmodifiableList(this.entities);
    }

    public int getNPCCount() {
        return this.entities.size();
    }
}
