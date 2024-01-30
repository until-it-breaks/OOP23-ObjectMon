package it.unibo.objectmon.model.collision;

import java.util.Set;

import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.Tile;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.model.entity.api.Npc;

public class CollisionChecker {
    private World world;
    private Set<Npc> npcs;

    public CollisionChecker(World world, Set<Npc> npcs) {
        this.world = world;
        this.npcs = npcs;
    }

    public boolean isCollision(Coord position) {
        return isNPCCollision(position) || isTileCollision(position);
    }

    private boolean isTileCollision(Coord position) {
        Tile tile = world.getMap().get(position);
        System.out.println(position);
        if (tile == null || !tile.isPassable()) {
            return true;
        }
        return false;
    }

    private boolean isNPCCollision(Coord position) {
        for (Npc npc : npcs) {
            if (npc.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}
