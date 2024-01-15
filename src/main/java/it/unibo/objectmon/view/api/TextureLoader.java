package it.unibo.objectmon.view.api;

import java.awt.image.BufferedImage;
/**
 * Models a utility class that returns an image.
 */
public interface TextureLoader {
    /**
     * 
     * @param path the classpath address of the image to be retrieved.
     * 
     * @return a cached image if it has been loaded before or else a brand new one.
     */
    BufferedImage getTexture(String path);
}
