package it.unibo.objectmon.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.view.utility.RenderingUtils;
import it.unibo.objectmon.controller.commands.EndGame;
import it.unibo.objectmon.model.gamestate.api.GameState;

/**
 * Represents the main GUI frame of the game.
 * This class serves as the main container
 * for displaying various panels.
 */
public final class SwingViewImpl implements View {
    private static final String GAME_NAME = "Objectmon";
    private static final String GAME_ICON = "/icon/cheesecake.png";
    private final JFrame frame;
    private final Controller controller;

    /**
     * Constructs a new {@link JFrame}.
     * The {@link JFrame} is initialized with default settings.
     *
     * @param controller The {@link Controller} that will be passed to the child panels.
     */
    public SwingViewImpl(final Controller controller) {
        this.controller = controller;
        this.frame = new JFrame(GAME_NAME);
        final ImageIcon icon = new ImageIcon(this.getClass().getResource(GAME_ICON));
        frame.setIconImage(icon.getImage());
        this.frame.setPreferredSize(RenderingUtils.getPreferredResolution());
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationByPlatform(true);
        this.frame.pack();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                final int choice = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    controller.shutdown();
                }
            }
        });
        this.frame.setVisible(true);
    }

    @Override
    public void render() {
        frame.repaint();
    }

    @Override
    public void setCurrentPanel(final JPanel panel) {
        SwingUtilities.invokeLater(() -> {
            this.frame.getContentPane().removeAll();
            this.frame.getContentPane().add(panel);
            this.frame.setVisible(true);
            frame.revalidate();
            frame.repaint();
            // Very important, otherwise the panel's keyListener won't work.
            panel.requestFocusInWindow();
        });
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
            case TRADE:
                setCurrentPanel(new ShopPanel(controller));
                break;
            case PAUSE:
                showResumeDialog();
                break;
            case ENDING:
                setCurrentPanel(new EndPanel(controller));
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private void showResumeDialog() {
        JOptionPane.showConfirmDialog(frame,
                "Battle is over",
                "Game Paused",
                JOptionPane.PLAIN_MESSAGE);
        setCurrentPanel(new OverWorldPanel(controller));
        // Check if the game has ended.
        if (controller.gameLost() || controller.gameWon()) {
            controller.notifyCommand(new EndGame());
        }
    }
}
