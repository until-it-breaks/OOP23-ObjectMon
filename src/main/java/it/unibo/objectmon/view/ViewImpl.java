package it.unibo.objectmon.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.view.api.View;

/**
 * Represents the main GUI frame for the game.
 * This class serves as the primary container 
 * for displaying various game components and interacting with the user.
 */
public final class ViewImpl implements View {
    private static final String GAME_NAME = "Objectmon";
    private final JFrame frame;

    /**
     * Creates a new JFrame for the game's GUI.
     * The JFrame is initialized with default settings.
     */
    public ViewImpl() {
        this.frame = new JFrame(GAME_NAME);
        this.frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationByPlatform(true);
        this.frame.pack();
    }

    @Override
    public void render() {
        frame.repaint();
    }

    @Override
    public void build(final Controller controller) {
        this.frame.add(new OverWorldPanel(controller));
        this.frame.setVisible(true);
    }
}
