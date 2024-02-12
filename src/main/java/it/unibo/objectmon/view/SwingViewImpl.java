package it.unibo.objectmon.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.view.utility.RenderingUtils;

/**
 * Represents the main GUI frame for the game.
 * This class serves as the primary container
 * for displaying various game components and interacting with the user.
 */
public final class SwingViewImpl implements View {
    private static final String GAME_NAME = "Objectmon";
    private static final String GAME_ICON = "/icon/cheesecake.png";
    private final JFrame frame;
    private final Controller controller;

    /**
     * Creates a new JFrame for the game's GUI.
     * The JFrame is initialized with default settings.
     *
     * @param controller The controller that will be passed to the child panels.
     */
    public SwingViewImpl(final Controller controller) {
        this.controller = controller;
        this.frame = new JFrame(GAME_NAME);
        this.frame.setPreferredSize(RenderingUtils.getPreferredResolution());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationByPlatform(true);
        final ImageIcon icon = new ImageIcon(this.getClass().getResource(GAME_ICON));
        frame.setIconImage(icon.getImage());
        this.frame.pack();
        this.frame.setVisible(true);
    }

    @Override
    public void render() {
        frame.repaint();
    }

    @Override
    public void setCurrentPanel(final JPanel panel) {
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().add(panel);
        this.frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
        //Very important, otherwise the panel's keyListener won't work no matter what
        panel.requestFocusInWindow();
    }

    @Override
    public void destroy() {
        this.frame.dispose();
    }

    @Override
    public void update() {
        final GameState gameState = controller.getGameState();
        switch (gameState) {
            case EXPLORATION:
                setCurrentPanel(new OverWorldPanel(controller));
                break;
            case BATTLE:
                setCurrentPanel(new BattlePanel(controller));
                break;
            default:
                throw new IllegalStateException();
        }
    }
}
