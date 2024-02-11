package it.unibo.objectmon.view.battleview;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import it.unibo.objectmon.model.data.api.aspect.Aspect;

public final class AspectColorMap {
    private static final Map<Aspect, Color> aspectColorMap = new HashMap<>();

    static {
        // Populate the map with color mappings
        aspectColorMap.put(Aspect.NORMAL, Color.LIGHT_GRAY);
        aspectColorMap.put(Aspect.GRASS, Color.GREEN);
        aspectColorMap.put(Aspect.FIRE, Color.ORANGE);
        aspectColorMap.put(Aspect.WATER, Color.BLUE);
        aspectColorMap.put(Aspect.FLYING, Color.CYAN);
        aspectColorMap.put(Aspect.POISON, Color.MAGENTA.darker());
        aspectColorMap.put(Aspect.GROUND, Color.YELLOW);
        aspectColorMap.put(Aspect.ROCK, Color.BLACK.brighter());
        aspectColorMap.put(Aspect.FIGHTING, Color.RED.darker());
        aspectColorMap.put(Aspect.BUG, Color.GREEN.darker());
    }

    public static Color getColorForAspect(Aspect aspect) {
        return aspectColorMap.get(aspect);
    }
}
