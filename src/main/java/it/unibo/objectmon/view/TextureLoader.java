package it.unibo.objectmon.view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class TextureLoader {
    private final Map<String, BufferedImage> textures;
    private final Logger logger = Logger.getLogger("TextureLoader");
    public TextureLoader() {
        this.textures = new HashMap<>();
    }

    public BufferedImage getTexture(final String path) {
        if (textures.containsKey(path)) {
            return textures.get(path);
        } else {
            try {
                final BufferedImage texture = ImageIO.read(getClass().getResourceAsStream(path));
                textures.put(path, texture);
                return texture;
            } catch (final IOException e) {
                logger.log(Level.SEVERE, e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }
}
