package it.unibo.objectmon.model.misc.collision;

import java.util.Set;
import java.util.Collections;

import it.unibo.objectmon.model.world.Tile;
import it.unibo.objectmon.model.world.api.Coord;
import it.unibo.objectmon.model.world.api.World;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;

/**
 * An implementation of the {@link CollisionManager} interface that checks for collisions
 * within a game environment.
 */
public class CollisionManagerImpl implements CollisionManager {
    private final World world;
    private final Set<AbstractNPC> npcs;

    /**
     * Creates a new {@link CollisionManagerImpl} instance with the specified world and set of NPCs.
     *
     * @param world the game world in which collisions are checked.
     * @param npcs  the set of non-player characters in the game.
     */
    public CollisionManagerImpl(final World world, final Set<AbstractNPC> npcs) {
        this.world = world;
        this.npcs = Collections.unmodifiableSet(npcs);
    }

    /**
     * Checks if a collision occurs at the specified position within the game environment.
     * A collision can occur if the position overlaps with a non-passable tile or if it
     * intersects with the position of any non-player character (NPC) in the game.
     *
     * @param position the position to check for collision.
     * @return {@code true} if a collision occurs at the specified position, {@code false} otherwise.
     */
    @Override
    public boolean isCollision(final Coord position) {
        return isNPCCollision(position) || isTileCollision(position);
    }

    private boolean isTileCollision(final Coord position) {
        final Tile tile = world.getMap().get(position);
        return tile == null || !tile.isPassable();
    }

    private boolean isNPCCollision(final Coord position) {
        for (final AbstractNPC npc : npcs) {
            if (npc.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}
