package it.unibo.objectmon.view.battleview;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import it.unibo.objectmon.model.data.api.aspect.Aspect;

/**
 * A utility class used to determine the {@link Color} corresponding to an {@link Aspect}.
 */
public final class AspectColorMap {

    private static final Map<Aspect, Color> ASPECT_COLOR_MAP = new HashMap<>();

    private AspectColorMap() {
    }

    static {
        ASPECT_COLOR_MAP.put(Aspect.NORMAL, Color.LIGHT_GRAY);
        ASPECT_COLOR_MAP.put(Aspect.GRASS, Color.GREEN);
        ASPECT_COLOR_MAP.put(Aspect.FIRE, Color.ORANGE);
        ASPECT_COLOR_MAP.put(Aspect.WATER, Color.BLUE.brighter());
        ASPECT_COLOR_MAP.put(Aspect.FLYING, Color.CYAN);
        ASPECT_COLOR_MAP.put(Aspect.POISON, Color.MAGENTA.darker());
        ASPECT_COLOR_MAP.put(Aspect.GROUND, Color.YELLOW.darker());
        ASPECT_COLOR_MAP.put(Aspect.ROCK, Color.decode("#b9770e"));
        ASPECT_COLOR_MAP.put(Aspect.FIGHTING, Color.RED.darker());
        ASPECT_COLOR_MAP.put(Aspect.BUG, Color.GREEN.darker());
    }

    /**
     * Retrieves the color corresponding to a specific {@link Aspect}.
     * 
     * @param aspect The aspect of which the color is sought.
     * @return The correponding color.
     */
    public static Color getColor(final Aspect aspect) {
        return ASPECT_COLOR_MAP.get(aspect);
    }
}
