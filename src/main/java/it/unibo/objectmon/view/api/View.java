package it.unibo.objectmon.view.api;

import it.unibo.objectmon.controller.Controller;

/**
 * Represents the main GUI of the game.
 */
public interface View {

    /**
     * Requests the child panels to render information based on the model's state.
     * This method triggers the repaint mechanism to update the GUI components 
     * according to the latest data from the underlying model.
     */
    void render();

    /**
     * Constructs and adds the necessary panels to the view for rendering game content.
     * 
     * @param controller the controller responsible for handling user inputs and game data retrieval.
     */
    void build(Controller controller);

    /**
     * Disposes off the view.
     */
    void destroy();
}
