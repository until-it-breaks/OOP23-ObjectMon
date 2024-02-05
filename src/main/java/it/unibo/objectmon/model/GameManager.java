package it.unibo.objectmon.model;

import java.util.Collections;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.collision.CollisionCheckerImpl;
import it.unibo.objectmon.model.collision.api.CollisionChecker;
import it.unibo.objectmon.model.entity.NpcManager;
import it.unibo.objectmon.model.entity.PlayerManager;
import it.unibo.objectmon.model.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.World;

/**
 * Manages the model logic.
 */
public final class GameManager {
    private final World world;
    private final PlayerManager playerManager;
    private final NpcManager npcManager;
    private final InteractionManager interactionManager;
    private final CollisionChecker collisionManager;
    private final BattleManager battleManager;

    /**
     * Creates a world with entities and environment.
     */
    public GameManager() {
        this.world = new World();
        this.playerManager = new PlayerManager(this);
        this.npcManager = new NpcManager();
        this.interactionManager = new InteractionManagerImpl();
        this.collisionManager = new CollisionCheckerImpl(world, Collections.unmodifiableSet(npcManager.getNpcs()));
        this.battleManager = new BattleManagerImpl();
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
    @SuppressFBWarnings("EI_EXPOSE_REP") //TEMPORARY!!!!!
    public PlayerManager getPlayerController() {
        return this.playerManager;
    }

    /**
     * 
     * @return an immutable set of all the current npcs.
     */
    public NpcManager getNpcManager() {
        return this.npcManager;
    }

    /**
     * 
     * @return the interaction manager.
     */
    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }

    /**
     * 
     * @return the collision checker.
     */
    public CollisionChecker getCollisionManager() {
        return collisionManager;
    }

    /**
     * 
     * @return the battle manager
     */
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public BattleManager getBattleManager() {
        return this.battleManager;
    }
}
