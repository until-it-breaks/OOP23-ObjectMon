package it.unibo.objectmon.model.data.objectmon;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import it.unibo.objectmon.model.data.api.elementalType.ElementalType;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.statistics.StatEnum;
import it.unibo.objectmon.model.data.statistics.ActualStats;
import it.unibo.objectmon.model.data.statistics.BaseStats;
import it.unibo.objectmon.model.data.skill.SkillFactory;

/**
 * Enum of Objectmon in the game.
 */
public enum ObjectmonEnum {

    /**
     * Information of the Objectmon Zigzagoon.
     */
    ZIGZAGOON(
        "Zigzagoon",
        List.of(ElementalType.NORMAL),
        new BaseStats(
            Map.of(
                StatEnum.HP, 38,
                StatEnum.ATK, 30,
                StatEnum.DEF, 41,
                StatEnum.SPATK, 30,
                StatEnum.SPDEF, 41,
                StatEnum.SPD, 60
            )
        )
    ),

    /**
     * Information of the Objectmon Tailow.
     */
    TAILLOW(
        "Taillow",
        List.of(ElementalType.NORMAL, ElementalType.FLYING),
        new BaseStats(
            Map.of(
                StatEnum.HP, 40,
                StatEnum.ATK, 55,
                StatEnum.DEF, 30,
                StatEnum.SPATK, 30,
                StatEnum.SPDEF, 30,
                StatEnum.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Oddish.
     */
    ODDISH(
        "Oddish",
        List.of(ElementalType.GRASS, ElementalType.POISON),
        new BaseStats(
            Map.of(
                StatEnum.HP, 45,
                StatEnum.ATK, 50,
                StatEnum.DEF, 55,
                StatEnum.SPATK, 75,
                StatEnum.SPDEF, 65,
                StatEnum.SPD, 30
            )
        )
    ),

    /**
     * Information of the Objectmon Kecleon.
     */
    KECLEON(
        "Kecleon",
        List.of(ElementalType.NORMAL),
        new BaseStats(
            Map.of(
                StatEnum.HP, 60,
                StatEnum.ATK, 90,
                StatEnum.DEF, 70,
                StatEnum.SPATK, 60,
                StatEnum.SPDEF, 120,
                StatEnum.SPD, 40
            )
        )
    ),

    /**
     * Information of the Objectmon Treeko.
     */
    TREECKO(
        "Treecko",
        List.of(ElementalType.GRASS),
        new BaseStats(
            Map.of(
            StatEnum.HP, 40,
            StatEnum.ATK, 45,
            StatEnum.DEF, 35,
            StatEnum.SPATK, 65,
            StatEnum.SPDEF, 55,
            StatEnum.SPD, 70
            )
        )
    ),

    /**
     * Information of the Objectmon Shroomish.
     */
    SHROOMISH(
        "Shroomish",
        List.of(ElementalType.GRASS),
        new BaseStats(
            Map.of(
                StatEnum.HP, 60,
                StatEnum.ATK, 40,
                StatEnum.DEF, 60,
                StatEnum.SPATK, 40,
                StatEnum.SPDEF, 60,
                StatEnum.SPD, 35
            )
        )
    ),

    /**
     * Information of the Objectmon Volbeat.
     */
    VOLBEAT(
        "Volbeat",
        List.of(ElementalType.BUG),
        new BaseStats(
            Map.of(
                StatEnum.HP, 65,
                StatEnum.ATK, 73,
                StatEnum.DEF, 55,
                StatEnum.SPATK, 47,
                StatEnum.SPDEF, 75,
                StatEnum.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Illumise.
     */
    ILLUMISE(
        "Illumise",
        List.of(ElementalType.BUG),
        new BaseStats(
            Map.of(
                StatEnum.HP, 65,
                StatEnum.ATK, 47,
                StatEnum.DEF, 55,
                StatEnum.SPATK, 73,
                StatEnum.SPDEF, 75,
                StatEnum.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Tropius.
     */
    TROPIUS(
        "Tropius",
        List.of(ElementalType.GRASS, ElementalType.FLYING),
        new BaseStats(
            Map.of(
                StatEnum.HP, 99,
                StatEnum.ATK, 68,
                StatEnum.DEF, 83,
                StatEnum.SPATK, 72,
                StatEnum.SPDEF, 87,
                StatEnum.SPD, 51
            )
        )
    ),

    /**
     * Information of the Objectmon Mudkip.
     */
    MUDKIP(
        "Mudkip",
        List.of(ElementalType.WATER, ElementalType.GROUND),
        new BaseStats(
            Map.of(
                StatEnum.HP, 50,
                StatEnum.ATK, 70,
                StatEnum.DEF, 50,
                StatEnum.SPATK, 50,
                StatEnum.SPDEF, 50,
                StatEnum.SPD, 40
            )
        )
    ),

    /**
     * Information of the Objectmon Goldeen.
     */
    GOLDEEN(
        "Goldeen",
        List.of(ElementalType.WATER),
        new BaseStats(
            Map.of(
                StatEnum.HP, 45,
                StatEnum.ATK, 67,
                StatEnum.DEF, 60,
                StatEnum.SPATK, 35,
                StatEnum.SPDEF, 50,
                StatEnum.SPD, 63
            )
        )
    ),

    /**
     * Information of the Objectmon Staryu.
     */
    STARYU(
        "Staryu",
        List.of(ElementalType.WATER),
        new BaseStats(
            Map.of(
                StatEnum.HP, 35,
                StatEnum.ATK, 45,
                StatEnum.DEF, 55,
                StatEnum.SPATK, 70,
                StatEnum.SPDEF, 55,
                StatEnum.SPD, 85
            )
        )
    ),

    /**
     * Information of the Objectmon Relicant.
     */
    RELICANTH(
        "Relicanth",
        List.of(ElementalType.WATER, ElementalType.ROCK),
        new BaseStats(
            Map.of(
                StatEnum.HP, 100,
                StatEnum.ATK, 90,
                StatEnum.DEF, 130,
                StatEnum.SPATK, 45,
                StatEnum.SPDEF, 65,
                StatEnum.SPD, 55
            )
        )
    ),

    /**
     * Information of the Objectmon Torchic.
     */
    TORCHIC(
        "Torchic",
        List.of(ElementalType.FIRE),
        new BaseStats(
            Map.of(
                StatEnum.HP, 45,
                StatEnum.ATK, 60,
                StatEnum.DEF, 40,
                StatEnum.SPATK, 70,
                StatEnum.SPDEF, 50,
                StatEnum.SPD, 45
            )
        )
    ),

    /**
     * Information of the Objectmon Slugma.
     */
    SLUGMA(
        "Slugma",
        List.of(ElementalType.FIRE),
        new BaseStats(
            Map.of(
                StatEnum.HP, 40,
                StatEnum.ATK, 40,
                StatEnum.DEF, 40,
                StatEnum.SPATK, 70,
                StatEnum.SPDEF, 40,
                StatEnum.SPD, 20
            )
        )
    ),

    /**
     * Information of the Objectmon Numel.
     */
    NUMEL(
        "Numel",
        List.of(ElementalType.FIRE, ElementalType.GROUND),
        new BaseStats(
            Map.of(
                StatEnum.HP, 60,
                StatEnum.ATK, 60,
                StatEnum.DEF, 40,
                StatEnum.SPATK, 65,
                StatEnum.SPDEF, 45,
                StatEnum.SPD, 35
            )
        )
    ),

    /**
     * Information of the Objectmon Torkoal.
     */
    TORKOAL(
        "Torkoal",
        List.of(ElementalType.FIRE),
        new BaseStats(
            Map.of(
                StatEnum.HP, 70,
                StatEnum.ATK, 85,
                StatEnum.DEF, 140,
                StatEnum.SPATK, 85,
                StatEnum.SPDEF, 70,
                StatEnum.SPD, 20
            )
        )
    ),

    /**
     * Information of the Objectmon Geodude.
     */
    GEODUDE(
        "Geodude",
        List.of(ElementalType.ROCK, ElementalType.GROUND),
        new BaseStats(
            Map.of(
                StatEnum.HP, 40,
                StatEnum.ATK, 80,
                StatEnum.DEF, 100,
                StatEnum.SPATK, 30,
                StatEnum.SPDEF, 30,
                StatEnum.SPD, 20
            )
        )
    ),

    /**
     * Information of the Objectmon Lileep.
     */
    LILEEP(
        "Lileep",
        List.of(ElementalType.ROCK, ElementalType.GRASS),
        new BaseStats(
            Map.of(
                StatEnum.HP, 66,
                StatEnum.ATK, 41,
                StatEnum.DEF, 77,
                StatEnum.SPATK, 61,
                StatEnum.SPDEF, 87,
                StatEnum.SPD, 23
            )
        )
    ),

    /**
     * Information of the Objectmon Anorith.
     */
    ANORITH(
        "Anorith",
        List.of(ElementalType.ROCK, ElementalType.BUG),
        new BaseStats(
            Map.of(
                StatEnum.HP, 45,
                StatEnum.ATK, 95,
                StatEnum.DEF, 50,
                StatEnum.SPATK, 40,
                StatEnum.SPDEF, 50,
                StatEnum.SPD, 75
            )
        )
    ),

    /**
     * Information of the Objectmon Sandshrew.
     */
    SANDSHREW(
        "Sandshrew",
        List.of(ElementalType.GROUND),
        new BaseStats(
            Map.of(
                StatEnum.HP, 50,
                StatEnum.ATK, 75,
                StatEnum.DEF, 85,
                StatEnum.SPATK, 20,
                StatEnum.SPDEF, 30,
                StatEnum.SPD, 40
            )
        )
    ),

    /**
     * Information of the Objectmon Nosepass.
     */
    NOSEPASS(
        "Nosepass",
        List.of(ElementalType.ROCK),
        new BaseStats(
            Map.of(
                StatEnum.HP, 30,
                StatEnum.ATK, 45,
                StatEnum.DEF, 135,
                StatEnum.SPATK, 45,
                StatEnum.SPDEF, 90,
                StatEnum.SPD, 30
            )
        )
    );

    private final String name;
    private final List<ElementalType> elementalTypes;
    private final List<Skill> skills;
    private final ActualStats stats;

    /**
     * Constructor of ObjectmonEnum.
     * 
     * @param name Name of the Objectmon
     * @param elementalTypes Aspects of the Objectmon.
     * @param stats Stats of the Objectmon.
     */
    ObjectmonEnum(final String name, final List<ElementalType> elementalTypes, final BaseStats stats) {
        this.name = name;
        this.elementalTypes = List.copyOf(elementalTypes);

        final List<Skill> skills = SkillFactory.createSkills().stream()
        .filter(skill -> skill.getElementalType().sameAspect(elementalTypes))
        .toList();

        if (elementalTypes.size() > 1) {
            final int firstAspectIndex = 2;
            final int lastAspectIndex = 6;
            this.skills = skills.subList(firstAspectIndex, lastAspectIndex);
        } else {
            this.skills = skills;
        }
        this.stats = new ActualStats(stats);
    }

    /**
     * Getter of name.
     * 
     * @return Returns the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of Aspects.
     * 
     * @return Returns the Aspects.
     */
    public List<ElementalType> getElementalTypes() {
        return Collections.unmodifiableList(this.elementalTypes);
    }

    /**
     * Getter of Stats.
     * 
     * @return Returns the Stats.
     */
    public ActualStats getStats() {
        return this.stats;
    }

    /**
     * Getter of Skills.
     * 
     * @return Returns the Skills.
     */
    public List<Skill> getSkills() {
        return Collections.unmodifiableList(this.skills);
    }
}
