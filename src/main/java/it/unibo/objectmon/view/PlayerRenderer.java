package it.unibo.objectmon.view;

import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Image;

import it.unibo.objectmon.model.entities.Player;
import it.unibo.objectmon.view.api.Renderer;

public final class PlayerRenderer extends JPanel implements Renderer {
    private final Player player;
    private TextureLoader textureLoader;

    public PlayerRenderer(final Player player) {
        this.player = player;
        this.textureLoader = new TextureLoader();
    }
    @Override
    public void draw(final Graphics g) {
        super.paintComponent(g);
        final Graphics g2 = (Graphics2D) g;

        final Image img = textureLoader.getTexture("/textures/spy.png");

        g2.drawImage(img, player.getPosition().y(), player.getPosition().x(), null);
    }
}
