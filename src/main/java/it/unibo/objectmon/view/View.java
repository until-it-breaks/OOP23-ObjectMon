package it.unibo.objectmon.view;

import javax.swing.JPanel;

import it.unibo.objectmon.model.gamestate.Observer;

/**
 * Represents the main GUI of the game.
 */
public interface View extends Observer {

    /**
     * This method makes a request to the child panel,
     * in order to render based on the model's state.
     * Triggers the repaint mechanism to update the GUI components
     * according to the latest data from the underlying model.
     */
    void render();

    /**
     * Builds and adds the necessary panels to the view,
     * to render the game content.
     *
     * @param panel the new panel to be attached.
     */
    void setCurrentPanel(JPanel panel);

    /**
     * Disposes the view.
     */
    void destroy();
}
