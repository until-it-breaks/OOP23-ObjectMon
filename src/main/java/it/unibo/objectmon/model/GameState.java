package it.unibo.objectmon.model;

import it.unibo.objectmon.model.entities.Player;
import it.unibo.objectmon.model.entities.PlayerImpl;
import it.unibo.objectmon.model.world.World;
/**
 * Models the status of the game details.
 */
public final class GameState {
    private World world;
    private Player player;
    /**
     * Creates a world with entities and environment.
     */
    public GameState() {
        init();
    }

    private void init() {
        this.world = new World();
        this.player = new PlayerImpl("Player1", 0, 0);
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
