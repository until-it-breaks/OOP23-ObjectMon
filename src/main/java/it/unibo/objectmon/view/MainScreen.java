package it.unibo.objectmon.view;

import it.unibo.objectmon.controller.GameController;
import it.unibo.objectmon.view.api.Renderer;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

public final class MainScreen extends JPanel {
    private static final int BLOCKSIZE = 48;
    private final Renderer worldView;
    private final Renderer playerView;
    private final KeyListener playerControls;
    private final GameController controller;

    public MainScreen(final GameController controller) {
        this.controller = controller;
        this.setBackground(Color.BLACK);
        //this.setDoubleBuffered(true); experimental settings
        this.worldView = new WorldRenderer(controller.gameState().getWorld(), BLOCKSIZE);
        this.playerView = new PlayerRenderer(controller.gameState().getPlayer());
        this.playerControls = new PlayerControls(controller);
        this.addKeyListener(playerControls);
        //The following two seem to help with controls
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
