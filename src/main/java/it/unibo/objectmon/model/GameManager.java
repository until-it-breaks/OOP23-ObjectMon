package it.unibo.objectmon.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

import it.unibo.objectmon.model.collision.CollisionChecker;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.entity.api.NpcType;
import it.unibo.objectmon.model.entity.npc.NpcImpl;
import it.unibo.objectmon.model.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.World;
/**
 * Manages the model logic.
 */
public class GameManager {
    private World world;
    private PlayerController playerManager;
    private Set<Npc> npcs;
    private InteractionManager interactionManager;
    private CollisionChecker collisionManager;

    private static final Coord TRADER_POSITION = new Coord(5, 5);
    private static final Coord HEALER_POSITION = new Coord(8, 8);
    private static final Coord TRAINER_POSITION = new Coord(1, 1);
    private static final Coord GENERIC_POSITION = new Coord(1, 2);

    /**
     * Creates a world with entities and environment.
     */
    public GameManager() {
        this.world = new World();
        this.playerManager = new PlayerController(this);
        this.npcs = new HashSet<>();
        this.npcs.add(new NpcImpl("Bob", TRADER_POSITION, NpcType.TRADER));
        this.npcs.add(new NpcImpl("Madness", HEALER_POSITION, NpcType.HEALER));
        this.npcs.add(new NpcImpl("Frenchman", TRAINER_POSITION, NpcType.TRAINER));
        this.npcs.add(new NpcImpl("Mr.Generic", GENERIC_POSITION, NpcType.GENERIC));
        this.interactionManager = new InteractionManagerImpl();
        this.collisionManager = new CollisionChecker(world, npcs);
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
    public PlayerController getPlayerController() {
        return this.playerManager;
    }
    /**
     * 
     * @return an immutable set of all the current npcs.
     */
    public Set<Npc> getNpcs() {
        return Collections.unmodifiableSet(this.npcs);
    }
    /**
     * 
     * @return the interaction manager.
     */
    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }

    public CollisionChecker getCollisionManager() {
        return collisionManager;
    }
}
