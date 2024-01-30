package it.unibo.objectmon.view.utility;

import java.awt.image.BufferedImage;

/**
 * Defines an interface for loading images.
 */
public interface ImageLoader {

    /**
     * Retrieves an image corresponding to the specified path.
     *
     * @param path The path of the image file to be loaded.
     * @return The loaded image if successful, or null if the image could not be loaded.
     */
    BufferedImage getImage(String path);

}
