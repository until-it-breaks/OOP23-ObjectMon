package it.unibo.objectmon.model.entity.npc;

import java.util.Set;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;
import it.unibo.objectmon.model.world.Coord;
import java.util.HashSet;
import java.util.List;

/**
 * A factory of NPC sets.
 */
public final class NPCFactory {
    private static final Coord POSITION_1 = new Coord(5, 5);
    private static final Coord POSITION_2 = new Coord(44, 5);
    private static final Coord POSITION_3 = new Coord(5, 44);
    private static final Coord POSITION_4 = new Coord(44, 44);
    private static final Coord POSITION_5 = new Coord(24, 20);
    private static final Coord POSITION_6 = new Coord(25, 20);

    private NPCFactory() {
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createDemoNPCs() {
        final Set<AbstractNPC> npcs = new HashSet<>();
        npcs.addAll(createJustTrainers());
        npcs.addAll(createSupportNPCsOnly());
        return npcs;
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createJustTrainers() {
        final Set<AbstractNPC> npcs = new HashSet<>();
        final List<Objectmon> objList = ObjectmonFactory.createObjectmon();
        npcs.add(new TrainerNpc("Trainer Bob", POSITION_1, List.of(objList.get(0), objList.get(1))));
        npcs.add(new TrainerNpc("Trainer Alex", POSITION_2, List.of(objList.get(1), objList.get(1))));
        npcs.add(new TrainerNpc("Trainer Delta", POSITION_3, List.of(objList.get(3), objList.get(1), objList.get(4))));
        npcs.add(new TrainerNpc("Trainer Alpha", POSITION_4, List.of(objList.get(2), objList.get(1))));
        return npcs;
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createSupportNPCsOnly() {
        final Set<AbstractNPC> npcs = new HashSet<>();
        npcs.add(new HealerNPC("Doctor Madness", POSITION_5));
        npcs.add(new SellerNPC("Street Vendor", POSITION_6));
        return npcs;
    }
}
