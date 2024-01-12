package it.unibo.objectmon.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import it.unibo.objectmon.controller.GameController;

public class GameView {
    private static final String GAME_NAME = "Objectmon";
    private final JFrame frame = new JFrame(GAME_NAME);
    private GameController controller;
    private GameRenderer gamePanel;
    private final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public GameView() {
        frame.setPreferredSize(screenDimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public void setController(final GameController controller) {
        this.controller = controller;
        gamePanel = new GameRenderer(controller);
        frame.add(gamePanel);
    }

    public void render() {
        this.gamePanel.repaint();
    }
}