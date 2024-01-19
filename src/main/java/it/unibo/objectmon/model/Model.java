package it.unibo.objectmon.model;

import it.unibo.objectmon.model.entities.Player;
import it.unibo.objectmon.model.entities.PlayerImpl;
import it.unibo.objectmon.model.world.World;

/**
 * Models the master model of the application.
 */
public final class Model {
    private World world;
    private Player player;
    /**
     * Creates a world with entities and environment.
     */
    public Model() {
        init();
    }

    private void init() {
        this.world = new World();
        this.player = new PlayerImpl("Player", world.getWidth() / 2, world.getHeight() / 2);
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
    public Player getPlayer() {
        return player;
    }

}
