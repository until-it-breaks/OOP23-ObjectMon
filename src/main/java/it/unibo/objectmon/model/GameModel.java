package it.unibo.objectmon.model;

import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.model.world.WorldLoader;

public class GameModel {
    private World world;

    public GameModel() {
        init();
    }

    private void init() {
        WorldLoader wl = new WorldLoader();
        this.world = wl.getWorld();
    }

    public World getWorld() {
        return this.world;
    }
}
