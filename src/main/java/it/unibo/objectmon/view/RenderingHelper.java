package it.unibo.objectmon.view;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * A helper class providing methods for rendering tasks.
 */
public final class RenderingHelper {
    private RenderingHelper() {
    }
    /**
     * Retrieves the resolution of the default screen.
     * This method returns a Dimension object representing the width and height of the default screen in pixels.
     * @return a Dimension object representing the width and height of the default screen.
     */
    public static Dimension getResolution() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    /**
     * Retrieves the center coordinates of the default screen.
     * 
     * @return A Dimension object representing the center coordinates of the default screen.
     */
    public static Dimension getScreenCenter() {
        final Dimension dimension = getResolution();
        return new Dimension((int) dimension.getWidth() / 2, (int) dimension.getHeight() / 2);
    }
}
