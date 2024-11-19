package it.unibo.objectmon.view.battleview;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import it.unibo.objectmon.model.data.api.aspect.ElementalType;

/**
 * A utility class used to determine the {@link Color} corresponding to an {@link ElementalType}.
 */
public final class AspectColorMap {

    private static final Map<ElementalType, Color> ASPECT_COLOR_MAP = new HashMap<>();

    private AspectColorMap() {
    }

    static {
        ASPECT_COLOR_MAP.put(ElementalType.NORMAL, Color.LIGHT_GRAY);
        ASPECT_COLOR_MAP.put(ElementalType.GRASS, Color.GREEN);
        ASPECT_COLOR_MAP.put(ElementalType.FIRE, Color.ORANGE);
        ASPECT_COLOR_MAP.put(ElementalType.WATER, Color.BLUE.brighter());
        ASPECT_COLOR_MAP.put(ElementalType.FLYING, Color.CYAN);
        ASPECT_COLOR_MAP.put(ElementalType.POISON, Color.MAGENTA.darker());
        ASPECT_COLOR_MAP.put(ElementalType.GROUND, Color.YELLOW.darker());
        ASPECT_COLOR_MAP.put(ElementalType.ROCK, Color.decode("#b9770e"));
        ASPECT_COLOR_MAP.put(ElementalType.FIGHTING, Color.RED.darker());
        ASPECT_COLOR_MAP.put(ElementalType.BUG, Color.GREEN.darker());
    }

    /**
     * Retrieves the color corresponding to a specific {@link ElementalType}.
     * 
     * @param aspect The aspect of which color is sought.
     * @return The correponding color.
     */
    public static Color getColor(final ElementalType aspect) {
        return ASPECT_COLOR_MAP.get(aspect);
    }
}
