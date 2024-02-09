package it.unibo.objectmon.view.battleview;

import java.awt.Graphics;
import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;

/**
 * A panel that is used to display the flow of the battle.
 */
@SuppressWarnings("PMD")
public class CombatPanel extends JPanel {
    private static final long serialVersionUID = 4L;
    private final transient Controller controller;

    /**
     * Constructs a combat panel and attaches a controller to it.
     * 
     * @param controller The controller from which to poll information.
     */
    public CombatPanel(final Controller controller) {
        this.controller = controller;
    }

    @Override
    public void paintComponent(final Graphics g) {
        //TODO
    }
}
