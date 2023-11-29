package it.unibo.objectmon.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameView {
    private static final String GAME_NAME = "Objectmon";
    private final JFrame frame = new JFrame(GAME_NAME);

    public GameView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        JPanel gameMainScreen = new MainScreen();
        frame.add(gameMainScreen);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
