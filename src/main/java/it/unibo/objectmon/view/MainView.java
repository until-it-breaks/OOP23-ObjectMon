package it.unibo.objectmon.view;

import java.awt.Dimension;
import javax.swing.JFrame;

public final class MainView {
    private static final String GAME_NAME = "Objectmon";
    private final JFrame frame = new JFrame(GAME_NAME);

    public MainView() {
        this.frame.setPreferredSize(new Dimension(1280, 720));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationByPlatform(true);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void render() {
        //repaint something
    }
}
