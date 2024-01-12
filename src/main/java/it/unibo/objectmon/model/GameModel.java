package it.unibo.objectmon.model;

import it.unibo.objectmon.model.entities.Player;
import it.unibo.objectmon.model.entities.PlayerImpl;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.model.world.WorldLoader;

public class GameModel {
    private World world;
    private Player player;

    public GameModel() {
        player = new PlayerImpl("Spy", 0, 0);
        init();
    }

    private void init() {
        WorldLoader wl = new WorldLoader();
        this.world = wl.getWorld();
    }

    public World getWorld() {
        return this.world;
    }

    public Player getPlayer() {
        return this.player;
    }
}
