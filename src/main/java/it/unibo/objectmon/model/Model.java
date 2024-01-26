package it.unibo.objectmon.model;

import java.util.HashSet;
import java.util.Set;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Collections;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.entity.api.NpcType;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.NpcImpl;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.World;

/**
 * Models the master model of the application.
 */
public final class Model {
    private World world;
    private PlayerImpl player;
    private Set<Npc> npcs;
    private InteractionManager interactionManager;

    private static final Coord TRADER_POSITION = new Coord(5, 5);
    private static final Coord HEALER_POSITION = new Coord(8, 8);
    private static final Coord TRAINER_POSITION = new Coord(1, 1);
    private static final Coord GENERIC_POSITION = new Coord(1, 2);

    /**
     * Creates a world with entities and environment.
     */
    public Model() {
        init();
    }
    private void init() {
        this.world = new World();
        this.player = new PlayerImpl("Player", new Coord(world.getWidth() / 2, world.getHeight() / 2));
        this.npcs = new HashSet<>();
        this.npcs.add(new NpcImpl("Bob", TRADER_POSITION, NpcType.TRADER));
        this.npcs.add(new NpcImpl("Madness", HEALER_POSITION, NpcType.HEALER));
        this.npcs.add(new NpcImpl("Frenchman", TRAINER_POSITION, NpcType.TRAINER));
        this.npcs.add(new NpcImpl("Mr.Generic", GENERIC_POSITION, NpcType.GENERIC));
        this.interactionManager = new InteractionManagerImpl();
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
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "No internal representation exposed")
    public Player getPlayer() {
        return player;
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
}
