package it.unibo.objectmon.model;

import java.util.HashSet;
import java.util.Set;

import it.unibo.objectmon.model.entities.Entity;
import it.unibo.objectmon.model.entities.medic.MedicImpl;
import it.unibo.objectmon.model.entities.player.PlayerImpl;
import it.unibo.objectmon.model.entities.trader.TraderImpl;
import it.unibo.objectmon.model.entities.trainer.TrainerImpl;
import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.World;

/**
 * Models the master model of the application.
 */
public final class Model {
    private World world;
    private PlayerImpl player;
    private Set<Entity> npcs;
    /**
     * Creates a world with entities and environment.
     */
    public Model() {
        init();
    }

    private void init() {
        this.world = new World();
        this.player = new PlayerImpl("Player", new Coord(world.getWidth() / 2, world.getHeight() / 2));
        this.npcs = new HashSet<>();
        this.npcs.add(new MedicImpl("medic1", new Coord(1, 4)));
        this.npcs.add(new TrainerImpl("trainer1", new Coord(10, 10)));
        this.npcs.add(new TraderImpl("trader1", new Coord(0, 0)));
    }
    /**
     * 
     * @return the world.
     */
    public World getWorld() {
        return world;
    }
    /**
     * 
     * @return the player.
     */
    public PlayerImpl getPlayer() {
        return player;
    }

    public Set<Entity> getEntities() {
        return this.npcs;
    }
}
