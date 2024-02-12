package it.unibo.objectmon.view.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Models a caching image loader that uses a Map behind the scenes.
 */
public final class ImageLoaderImpl implements ImageLoader {
    private final Map<String, BufferedImage> images;
    private final Logger logger = Logger.getLogger(ImageLoaderImpl.class.getName());

    /**
     * Constructs a new {@code ImageLoaderImpl}.
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
                final InputStream inputStream = getClass().getResourceAsStream(path);
                if (inputStream != null) {
                    final BufferedImage texture = ImageIO.read(inputStream);
                    images.put(path, texture);
                    return texture;
                } else {
                    logger.log(Level.WARNING, "Image file not found: " + path);
                }
            } catch (final IOException e) {
                logger.log(Level.SEVERE, "Error loading image: " + path, e);
            }
        }
        return null;
    }
}
