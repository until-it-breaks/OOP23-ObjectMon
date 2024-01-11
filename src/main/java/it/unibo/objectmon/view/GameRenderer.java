package it.unibo.objectmon.view;

import javax.swing.JPanel;

import it.unibo.objectmon.model.world.World;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameRenderer extends JPanel {
    private WorldRenderer worldView;

    public GameRenderer(World world) {
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.worldView = new WorldRenderer(world);
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        worldView.draw(g2);
    }
}
