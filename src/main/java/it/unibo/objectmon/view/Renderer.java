package it.unibo.objectmon.view;

import java.awt.Graphics;

/**
 * Models a generic renderer.
 */
public interface Renderer {
    /**
     * Draws a layer of the overall GUI.
     * 
     * @param g a graphics class.
     */
    void draw(Graphics g);
}
