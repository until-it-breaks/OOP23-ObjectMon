package it.unibo.objectmon.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GameMainScreen extends JPanel {
    private static final int PROPORTION = 5;
    final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public GameMainScreen() {
        this.setSize((int)screenDimension.getWidth()/PROPORTION, (int)screenDimension.getHeight()/PROPORTION);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.fillRect(0, 0, 40, 40);
        g2.dispose();
    }
}
