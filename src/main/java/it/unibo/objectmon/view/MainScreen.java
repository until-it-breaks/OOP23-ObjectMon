package it.unibo.objectmon.view;

import it.unibo.objectmon.controller.GameController;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

public class MainScreen extends JPanel {
    private static final int BLOCKSIZE = 48;
    private final Renderer worldView;
    private final Renderer playerView;
    private final KeyListener playerControls;

    public MainScreen(final GameController controller) {
        this.setBackground(Color.BLACK);
        //this.setDoubleBuffered(true); experimental settings
        this.worldView = new WorldRenderer(controller.getWorld(), BLOCKSIZE);
        this.playerView = new PlayerRenderer(controller.getPlayer(), BLOCKSIZE);
        this.playerControls = new PlayerControls();
        this.addKeyListener(playerControls);
        //THe following two seem to help with controls
        this.setFocusable(true);
        this.requestFocusInWindow();
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
