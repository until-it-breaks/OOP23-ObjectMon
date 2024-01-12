package it.unibo.objectmon.view;

import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Image;

import it.unibo.objectmon.model.entities.Player;

public class PlayerRenderer extends JPanel implements Renderer {
    private final Player player;
    private final int blocksize;
    private TextureLoader textureLoader;

    public PlayerRenderer(final Player player, final int blocksize) {
        this.player = player;
        this.blocksize = blocksize;
        this.textureLoader = new TextureLoader();
    }
    @Override
    public void draw(final Graphics g) {
        super.paintComponent(g);
        final Graphics g2 = (Graphics2D) g;

        final int scaledX =player.getPosition().x() * blocksize;
        final int scaledY = player.getPosition().y() * blocksize;

        final Image img = textureLoader.getTexture("/textures/spy.png");

        g2.drawImage(img, scaledY, scaledX, null);
    }
}
