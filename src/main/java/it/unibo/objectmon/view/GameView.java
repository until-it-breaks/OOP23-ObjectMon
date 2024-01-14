package it.unibo.objectmon.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import it.unibo.objectmon.controller.GameController;

public final class GameView {
    private static final String GAME_NAME = "Objectmon";
    private final JFrame frame = new JFrame(GAME_NAME);
    private GameController controller;
    private MainScreen mainScreen;
    private final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public GameView() {
        this.frame.setPreferredSize(screenDimension);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationByPlatform(true);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void setController(final GameController controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        this.mainScreen = new MainScreen(controller);
        this.frame.add(mainScreen);
    }

    public MainScreen getMainScreen() {
        return this.mainScreen;
    }

    public void render() {
        this.mainScreen.repaint();
    }
}
