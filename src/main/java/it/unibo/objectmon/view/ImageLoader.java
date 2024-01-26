package it.unibo.objectmon.view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Models a caching image loader.
 */
public final class ImageLoader {
    private final Map<String, BufferedImage> images;
    private final Logger logger = Logger.getLogger(ImageLoader.class.getName());
    /**
     * Creates a new texture loader.
     */
    public ImageLoader() {
        this.images = new HashMap<>();
    }
    /**
     * 
     * @param path the path of the image to be loaded.
     * @return the corresponding image.
     */
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
