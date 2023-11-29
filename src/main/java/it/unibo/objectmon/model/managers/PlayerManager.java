package it.unibo.objectmon.model.managers;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.objectmon.api.Manager;
import it.unibo.objectmon.model.entities.Player;

public class PlayerManager implements Manager {

    private final Player player = new Player("Player1", 0, 0);

    public void start() {

    }

    public Pair<Integer, Integer> getPlayerPosition() {
        return Pair.of(player.getX(), player.getY());
    } 

    public Player getPlayer() {
        return this.player;
    }
    
}
