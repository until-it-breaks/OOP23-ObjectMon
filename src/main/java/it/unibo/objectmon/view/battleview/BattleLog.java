package it.unibo.objectmon.view.battleview;

import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JTextArea;

import it.unibo.objectmon.controller.Controller;

/**
 * A Pane that is used to display textual information about the battle.
 */
@SuppressWarnings("PMD")
public class BattleLog extends ScrollPane {
    private static final long serialVersionUID = 3L;
    private final transient Controller controller;
    private final JTextArea textArea;

    /**
     * Constructs a plain ScrollPane that has a scrollable JTextArea.
     * 
     * @param controller the controller from which to poll information.
     */
    public BattleLog(final Controller controller) {
        this.controller = controller;
        this.textArea = new JTextArea();
        this.textArea.setBackground(Color.BLACK);
        this.textArea.setEditable(false);
        this.add(textArea);
    }
}
