package it.unibo.objectmon.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import it.unibo.objectmon.view.api.View;

/**
 * Models a Swing frame.
 */
public final class MainViewImpl implements View {
    private static final String GAME_NAME = "Objectmon";
    private static final Dimension DEFAULT_RES = new Dimension(1280, 720);
    private final JFrame frame = new JFrame(GAME_NAME);

    /**
     * Creates a view with a frame.
     */
    public MainViewImpl() {
        this.frame.setPreferredSize(DEFAULT_RES);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationByPlatform(true);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    @Override
    public void render() {
        //repaint something
    }
}
