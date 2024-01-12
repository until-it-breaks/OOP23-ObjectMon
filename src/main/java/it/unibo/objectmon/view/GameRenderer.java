package it.unibo.objectmon.view;

import it.unibo.objectmon.controller.GameController;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameRenderer extends JPanel {
    private static final int BLOCKSIZE = 48;
    private final Renderer worldView;
    private final Renderer playerView;

    public GameRenderer(final GameController controller) {
        this.setBackground(Color.BLACK);
        //this.setDoubleBuffered(true); experimental settings
        //this.setFocusable(true);
        this.worldView = new WorldRenderer(controller.getWorld(), BLOCKSIZE);
        this.playerView = new PlayerRenderer(controller.getPlayer(), BLOCKSIZE);
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics g2 = (Graphics2D) g;
        worldView.draw(g2);
        playerView.draw(g2);
        g2.dispose();
    }

    public int getBlocksize() {
        return BLOCKSIZE;
    }

    public Renderer getWorldView() {
        return worldView;
    }
}
