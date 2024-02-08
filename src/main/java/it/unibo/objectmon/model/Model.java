package it.unibo.objectmon.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.NpcManager;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.misc.collision.CollisionCheckerImpl;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;
import it.unibo.objectmon.model.misc.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.model.world.Worlds;

/**
 * Manages the model logic.
 */
public final class Model {
    private World world;
    private Player player;
    private NpcManager npcManager;
    private InteractionManager interactionManager;
    private CollisionChecker collisionChecker;
    private BattleManager battleManager;

    /**
     * Creates a world with entities and environment.
     */
    public Model() {
        initialize();
    }

    /**
     * Initializes the game model.
     */
    public void initialize() {
        this.world = new World(Worlds.DEMO);
        this.npcManager = new NpcManager();
        this.collisionChecker = new CollisionCheckerImpl(this.world, npcManager.getNpcs());
        this.interactionManager = new InteractionManagerImpl();
        this.player = new PlayerImpl("Player", world.getStartingPosition(), ObjectmonFactory.createObjectmon());
        this.battleManager = new BattleManagerImpl();
    }

    /**
     * 
     * @return the world.
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * Returns an object responsible for controlling the {@link Player}.
     * @return The {@link PlayerManager}
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "TEMPORARY")
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Retrieves the NPC manager.
     * @return An NPC manager.
     */
    public NpcManager getNpcManager() {
        return this.npcManager;
    }

    /**
     * Retrieves the interaction manager.
     * @return The interaction manager.
     */
    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }

    /**
     * Retrieves the collision checker.
     * @return The collision checker.
     */
    public CollisionChecker getCollisionChecker() {
        return this.collisionChecker;
    }

    /**
     * Retrieves the battle manager.
     * @return the battle manager.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Temporary")
    public BattleManager getBattleManager() {
        return this.battleManager;
    }
}
