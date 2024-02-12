package it.unibo.objectmon.view.utility;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * A utility class containing useful rendering methods.
 */
public final class RenderingUtils {

    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;

    private RenderingUtils() {
    }

    /**
     * Configure the graphics context to favor quality and enables anti-aliasing.
     * 
     * @param g the Graphics2d context to be affected.
     */
    public static void configureRenderingHints(final Graphics2D g) {
        final RenderingHints renderingHints = new RenderingHints(
            RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
        //Fixes those font jaggies.
        renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHints(renderingHints);
    }

    /**
     * Retrieves the default game resolution.
     * 
     * @return A default resolution.
     */
    public static Dimension getPreferredResolution() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
