package it.unibo.objectmon.view;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.entities.Entity;
import it.unibo.objectmon.model.world.Coord;
/**
 * The panel responsible for drawing the world in exploration mode.
 */
public final class ExploreModeView extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int TILE_SIZE = 48;
    private final transient Controller controller;
    private final transient ImageLoader textureLoader;
    /**
     * Creates a new ExplorerView.
     * 
     * @param controller the controller to be attached.
     */
    public ExploreModeView(final Controller controller) {
        this.controller = controller;
        this.textureLoader = new ImageLoader();
        this.addKeyListener(new KeyboardControls(controller));
        this.setFocusable(true);
    }
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        drawWorld(g);
        drawNPCs(g);
        drawPlayer(g);
        g.dispose();
    }

    private void drawNPCs(Graphics g) {
        final BufferedImage image = textureLoader.getImage("/npc/medic.png");
        for (Entity npc : controller.getEntities()) {
            g.drawImage(image, npc.getPosition().x() * TILE_SIZE, npc.getPosition().y() * TILE_SIZE, null);
        }
    }

    private void drawPlayer(final Graphics g) {
        final BufferedImage image = textureLoader.getImage("/player/player1.png");
        final Coord playerPosition = controller.getPlayer().getPosition();
        g.drawImage(image, playerPosition.y() * TILE_SIZE, playerPosition.x() * TILE_SIZE, null);
    }

    private void drawWorld(final Graphics g) {
        for (final var entry : controller.getMap().entrySet()) {
            final BufferedImage image = textureLoader.getImage(entry.getValue().getImagePath());
            g.drawImage(image, entry.getKey().y() * TILE_SIZE, entry.getKey().x() * TILE_SIZE, null);
        }
    }
}
