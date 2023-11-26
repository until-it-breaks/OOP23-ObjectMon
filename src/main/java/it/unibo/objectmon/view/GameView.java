package it.unibo.objectmon.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.objectmon.controller.GameController;

public class GameView {
    private static final String GAME_NAME = "Objectmon";
    private final JFrame frame = new JFrame(GAME_NAME);
    private GameController controller;

    public GameView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        JPanel gameMainScreen = new GameMainScreen();
        frame.add(gameMainScreen);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public void setController(final GameController controller) {
        this.controller = controller;
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
