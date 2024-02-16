package it.unibo.objectmon.model.entities.factories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;

import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * A utility class for generating predefined Non-Player Characters (NPCs) in a game world.
 * NPCs include trainers, healers, and vendors.
 */
public final class NPCGenerator {

    // Predefined positions for NPCs,
    private static final Coord POSITION_1 = new Coord(5, 5);
    private static final Coord POSITION_2 = new Coord(5, 40);
    private static final Coord POSITION_3 = new Coord(44, 5);
    private static final Coord POSITION_4 = new Coord(44, 40);
    private static final Coord POSITION_5 = new Coord(44, 25);
    private static final Coord POSITION_6 = new Coord(5, 25);
    private static final Coord POSITION_7 = new Coord(24, 23);
    private static final Coord POSITION_8 = new Coord(25, 23);

    // Default level for NPC parties,
    private static final int DEFAULT_PARTY_LEVEL = 5;

    private NPCGenerator() {
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @param battleInitiator Responsible for starting battles.
     * @param tradeInitiator Responsible for starting a trade session.
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createDefaultNPCs(final BattleInitiator battleInitiator,
        final TradeInitiator tradeInitiator) {
            Objects.requireNonNull(battleInitiator, "BattleInitiator must not be null");
            Objects.requireNonNull(tradeInitiator, "TradeInitiator must not be null");
            final Set<AbstractNPC> npcs = new HashSet<>();
            final NPCFactory trainerFactory = new TrainerFactory();
            final NPCFactory healerFactory = new HealerFactory();
            final NPCFactory vendorFactory = new VendorFactory();
            npcs.add(trainerFactory.createNPC("Trainer Bob", POSITION_1,
                List.of(ObjectmonEnum.ILLUMISE, ObjectmonEnum.LILEEP, ObjectmonEnum.NOSEPASS),
                DEFAULT_PARTY_LEVEL, battleInitiator, tradeInitiator));
            npcs.add(trainerFactory.createNPC("Trainer Alex", POSITION_2,
                List.of(ObjectmonEnum.ANORITH, ObjectmonEnum.GOLDEEN),
                DEFAULT_PARTY_LEVEL + 1, battleInitiator, tradeInitiator));
            npcs.add(trainerFactory.createNPC("Trainer Delta", POSITION_3,
                List.of(ObjectmonEnum.KECLEON), DEFAULT_PARTY_LEVEL + 2, battleInitiator, tradeInitiator));
            npcs.add(trainerFactory.createNPC("Trainer Gamma", POSITION_4,
                List.of(ObjectmonEnum.RELICANTH, ObjectmonEnum.NUMEL, ObjectmonEnum.TROPIUS, ObjectmonEnum.SHROOMISH),
                DEFAULT_PARTY_LEVEL - 1, battleInitiator, tradeInitiator));
            npcs.add(trainerFactory.createNPC("Trainer Sigma", POSITION_5,
                List.of(ObjectmonEnum.SLUGMA, ObjectmonEnum.GEODUDE, ObjectmonEnum.TORKOAL, ObjectmonEnum.NOSEPASS),
                DEFAULT_PARTY_LEVEL, battleInitiator, tradeInitiator));
            npcs.add(trainerFactory.createNPC("Trainer Alpha", POSITION_6,
                List.of(ObjectmonEnum.ODDISH, ObjectmonEnum.ILLUMISE, ObjectmonEnum.GEODUDE, ObjectmonEnum.GEODUDE),
                DEFAULT_PARTY_LEVEL - 1, battleInitiator, tradeInitiator));
            //Support NPCs
            npcs.add(healerFactory.createNPC("Dr. Madness", POSITION_7, null, 0, battleInitiator, null));
            npcs.add(vendorFactory.createNPC("Item Vendor", POSITION_8, null, 0, battleInitiator, tradeInitiator));
            return npcs;
    }
}
