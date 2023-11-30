package it.unibo.objectmon.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import it.unibo.objectmon.controller.GameController;

public class MainScreen extends JPanel {
    private static final int PROPORTION = 5;
    private final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    private final KeyHandler keyhandler = new KeyHandler();
    private GameController controller;

    public MainScreen(GameController controller) {
        this.setSize((int)screenDimension.getWidth()/PROPORTION, (int)screenDimension.getHeight()/PROPORTION);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyhandler);
        this.setFocusable(true);

        this.controller = controller;
    }

    public KeyHandler getKeyHandler() {
        return this.keyhandler;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.fillRect(controller.getPlayerX(), controller.getPlayerY(), 48, 48);
        g2.dispose();
    }
}
