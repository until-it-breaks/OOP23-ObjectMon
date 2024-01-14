package it.unibo.objectmon.view;

import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.World;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

public final class WorldRenderer extends JPanel implements Renderer {
    private final World world;
    private final TextureLoader textureLoader;
    private final int blocksize;

    public WorldRenderer(final World world, final int blocksize) {
        this.world = world;
        this.blocksize = blocksize;
        textureLoader = new TextureLoader();
    }

    @Override
    public void draw(final Graphics g) {
        super.paintComponent(g);
        final Graphics g2 = (Graphics2D) g;
        for (final Coord coord : world.getTiles().keySet()) {
            final int scaledX = coord.x() * blocksize;
            final int scaledY = coord.y() * blocksize;
            Image img;
            switch (world.getTiles().get(coord).getType()) {
                case WATER:
                    img = textureLoader.getTexture("/textures/water.png");
                    g2.drawImage(img, scaledY, scaledX, null);
                    break;
                case GRASS:
                    img = textureLoader.getTexture("/textures/grass.png");
                    g2.drawImage(img, scaledY, scaledX, null);
                    break;
                case STONE:
                img = textureLoader.getTexture("/textures/stone.png");
                g2.drawImage(img, scaledY, scaledX, null);
                break;
                default:
                    break;
            }
        }
    }

}
