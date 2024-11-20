package it.unibo.objectmon.view;

import javax.swing.JPanel;

import it.unibo.objectmon.model.gamestate.api.PlayerObserver;

/**
 * Represents the main GUI of the game.
 */
public interface View extends PlayerObserver {

    /**
     * Triggers the painting mechanism that updates the GUI components
     * with the latest data retrieved from the underlying model.
     */
    void render();

    /**
     * Sets up the necessary panels in the view,
     * to render the game content.
     *
     * @param panel The panel to be shown.
     */
    void setCurrentPanel(JPanel panel);

    /**
     * Disposes of the view.
     */
    void destroy();
}
