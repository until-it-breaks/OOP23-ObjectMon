package it.unibo.objectmon.view;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextureLoader {
    private final Map<String, Image> textures;
    private final Logger logger = Logger.getLogger("TextureLoader");
    public TextureLoader() {
        this.textures = new HashMap<>();
    }

    public Image getTexture(final String path) {
        if (textures.containsKey(path)) {
            return textures.get(path);
        } else {
            try {
                final Image texture = ImageIO.read(getClass().getResourceAsStream(path));
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
