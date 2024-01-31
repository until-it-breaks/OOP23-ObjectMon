package it.unibo.objectmon.model.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import it.unibo.objectmon.model.entity.npc.AbstractNPC;
import it.unibo.objectmon.model.entity.npc.HealerNPC;
import it.unibo.objectmon.model.entity.npc.SellerNPC;
import it.unibo.objectmon.model.entity.npc.TrainerNpc;
import it.unibo.objectmon.model.world.Coord;

/**
 * A manager that handles all the NPCs in game.
 */
public final class NpcManager {
    private final Set<AbstractNPC> npcs;

    private static final Coord TRAINER1_COORD = new Coord(10, 5);
    private static final Coord TRAINER2_COORD = new Coord(15, 5);
    private static final Coord TRAINER3_COORD = new Coord(20, 5);
    private static final Coord TRAINER4_COORD = new Coord(30, 5);
    private static final Coord TRAINER5_COORD = new Coord(35, 5);
    private static final Coord TRAINER6_COORD = new Coord(40, 5);
    private static final Coord HEALER1_COORD = new Coord(10, 20);
    private static final Coord SELLER1_COORD = new Coord(10, 25);

    /**
     * Initializes the manager and creates the in game NPCs.
     */
    public NpcManager() {
        this.npcs = new HashSet<>();
        this.npcs.add(new TrainerNpc("Trainer1", TRAINER1_COORD, Set.of()));
        this.npcs.add(new TrainerNpc("Trainer2", TRAINER2_COORD, Set.of()));
        this.npcs.add(new TrainerNpc("Trainer3", TRAINER3_COORD, Set.of()));
        this.npcs.add(new TrainerNpc("Trainer4", TRAINER4_COORD, Set.of()));
        this.npcs.add(new TrainerNpc("Trainer5", TRAINER5_COORD, Set.of()));
        this.npcs.add(new TrainerNpc("Trainer6", TRAINER6_COORD, Set.of()));
        this.npcs.add(new HealerNPC("Healer1", HEALER1_COORD));
        this.npcs.add(new SellerNPC("Seller1", SELLER1_COORD, Set.of()));
    }

    /**
     * Retrieves an immutable set of current NPCs.
     * @return An immutable set of current NPCs.
     */
    public Set<AbstractNPC> getNpcs() {
        return Collections.unmodifiableSet(npcs);
    }
}
