package it.unibo.objectmon.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import it.unibo.objectmon.controller.Controller;

/**
 * Models a Swing frame.
 */
public final class View {
    private static final String GAME_NAME = "Objectmon";
    private static final Dimension DEFAULT_RES = new Dimension(1280, 720);
    private final JFrame frame;
    /**
     * Creates a view with a JFrame.
     */
    public View() {
        this.frame = new JFrame(GAME_NAME);
        this.frame.setPreferredSize(DEFAULT_RES);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationByPlatform(true);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    /**
     * Tells the child panels to render information from the model.
     */
    public void render() {
        frame.repaint();
    }
    /**
     * Builds the view panel.
     * @param controller the controller that will receive inputs
     */
    public void build(final Controller controller) {
        this.frame.add(new OverWorldView(controller));
    }
}
