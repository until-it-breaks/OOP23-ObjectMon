package it.unibo.objectmon.model;

import java.util.Set;

import it.unibo.objectmon.model.entities.Entity;
import it.unibo.objectmon.model.entities.Player;
import it.unibo.objectmon.model.entities.PlayerImpl;
import it.unibo.objectmon.model.world.World;

public class GameState {
    private World world;
    private Set<Entity> entities;
    private Player player;

    public GameState() {
        init();
    }

    private void init() {
        this.world = new World();
        this.player = new PlayerImpl("Player1", 0, 0);
    }

    public World getWorld() {
        return world;
    }

    public Set<Entity> getEntities() {
        return entities;
    }

    public Player getPlayer() {
        return player;
    }
}
