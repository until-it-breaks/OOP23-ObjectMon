package it.unibo.objectmon.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MainScreen extends JPanel {
    private static final int PROPORTION = 5;
    final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public MainScreen() {
        this.setSize((int)screenDimension.getWidth()/PROPORTION, (int)screenDimension.getHeight()/PROPORTION);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        /*TODO*/
        g2.dispose();
    }
}
