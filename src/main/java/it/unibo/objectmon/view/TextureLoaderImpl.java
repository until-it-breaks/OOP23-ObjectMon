package it.unibo.objectmon.view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import it.unibo.objectmon.view.api.TextureLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Models a caching texture loader.
 */
public final class TextureLoaderImpl implements TextureLoader {
    private final Map<String, BufferedImage> textures;
    private final Logger logger = Logger.getLogger("TextureLoader");

    /**
     * Creates a new texture loader.
     */
    public TextureLoaderImpl() {
        this.textures = new HashMap<>();
    }

    @Override
    public BufferedImage getTexture(final String path) {
        if (textures.containsKey(path)) {
            return textures.get(path);
        } else {
            try {
                final BufferedImage texture = ImageIO.read(getClass().getResourceAsStream(path));
                textures.put(path, texture);
                return texture;
            } catch (final IOException e) {
                logger.log(Level.FINE, e.getMessage(), e);
            }
        }
        return null;
    }
}
