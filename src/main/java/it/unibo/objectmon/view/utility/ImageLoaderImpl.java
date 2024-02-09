package it.unibo.objectmon.view.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class modeling a caching image loader.
 */
public final class ImageLoaderImpl implements ImageLoader {
    private final Map<String, BufferedImage> images;
    private final Logger logger = Logger.getLogger(ImageLoaderImpl.class.getName());

    /**
     * Creates a new texture loader.
     */
    public ImageLoaderImpl() {
        this.images = new HashMap<>();
    }

    /**
     * Retrieves an image from the cache or loads it from the resource folder.
     * 
     * @param path The path of the image file to be loaded.
     * @return The loaded image if successful, or null if the image could not be loaded.
     */
    @Override
    public BufferedImage getImage(final String path) {
        if (images.containsKey(path)) {
            return images.get(path);
        } else {
            try {
                final BufferedImage texture = ImageIO.read(getClass().getResourceAsStream(path));
                images.put(path, texture);
                return texture;
            } catch (final IOException e) {
                logger.log(Level.FINE, e.getMessage(), e);
            }
        }
        return null;
    }
}
