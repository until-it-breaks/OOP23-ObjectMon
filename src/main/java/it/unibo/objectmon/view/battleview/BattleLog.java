package it.unibo.objectmon.view.battleview;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogObserver;

/**
 * A ScrollPane used to display textual information about the battle.
 */
public final class BattleLog extends JScrollPane implements BattleLogObserver {

    private static final long serialVersionUID = 3L;
    /**
     * The area on which the battle progress is printed.
     */
    private final JTextArea textArea;

    /**
     * Constructs a plain JScrollPane with a JTextArea.
     *
     * @param controller the controller from which to poll information.
     */
    public BattleLog(final Controller controller) {
        controller.getBattleLogger().addObserver(this);
        this.textArea = new JTextArea() {
            @Override
            public void append(final String str) {
                super.append(str);
                setCaretPosition(getDocument().getLength());
            }
        };
        this.textArea.setBackground(Color.BLACK);
        this.textArea.setForeground(Color.WHITE);
        this.textArea.setEditable(false);
        this.textArea.setFont(getFont());
        this.setViewportView(textArea);
    }

    @Override
    public void update(final String logEntry) {
        textArea.append(logEntry);
    }
}
