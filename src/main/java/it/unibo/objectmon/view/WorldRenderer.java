package it.unibo.objectmon.view;

import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.model.world.TileSetLoader.Tile;
import it.unibo.objectmon.model.world.TileSetLoader.TileSet;
import it.unibo.objectmon.view.api.Renderer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

public final class WorldRenderer extends JPanel implements Renderer {
    private final World world;
    private MainScreen mainPanel;
    private TextureLoader textureLoader;

    public WorldRenderer(final MainScreen mainPanel, final World world) {
        this.mainPanel = mainPanel;
        this.world = world;
        this.textureLoader = new TextureLoader();
    }

    @Override
    public void draw(final Graphics g) {
        super.paintComponent(g);
        final Graphics g2 = (Graphics2D) g;
        TileSet tileSet = mainPanel.getController().getModel().getTileSet();


        for (final var entry : world.getTiles().entrySet()) {
            int tileId = entry.getValue().getId();
            Coord tileTexturePosition = tileSet.getTexturePositions().get(tileId);

            final Image img = textureLoader.getTexture("/textures/grass.png");

            final int scaledX = entry.getKey().x() * 48;
            final int scaledY = entry.getKey().y() * 48;
            
            final int sourceX = tileTexturePosition.x() * tileSet.getTileWidth();
            final int sourceY = tileTexturePosition.x() * tileSet.getTileWidth();

            g2.drawImage(img, scaledX, scaledY, null);
            //g2.drawImage(img, scaledX, scaledY, scaledX + 64, scaledY + 64, sourceX, sourceY, sourceX + 64, sourceY + 64, null);
        }
    }
}
