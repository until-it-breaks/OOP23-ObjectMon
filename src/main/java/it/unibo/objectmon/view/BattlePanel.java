package it.unibo.objectmon.view;

import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.view.battleview.BattleLog;
import it.unibo.objectmon.view.battleview.CombatPanel;
import it.unibo.objectmon.view.battleview.CommandPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

/**
 * The panel used when the player is engaged in a battle.
 */
public class BattlePanel extends JPanel {
    private static final long serialVersionUID = 2L;
    private static final double COMBAT_PANEL_RATIO = 0.95;
    private static final double COMMAND_PANEL_RATIO = 0.05;
    private static final double RIGHT_PANEL_RATIO = 0.15;

    /**
     * Constructs a {@link BattlePanel} comprising a {@link CombatPanel}, a {@link CommandPanel} and a {@link BattleLog}.
     * 
     * @param controller The {@link Controller} used to retrieve rendering information.
     */
    public BattlePanel(final Controller controller) {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setLayout(new BorderLayout());

        //Left panel (CombatPanel and CommandPanel)
        final JPanel leftPanel = new JPanel(new GridBagLayout());
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(leftPanel, BorderLayout.CENTER);

        final CombatPanel combatPanel = new CombatPanel(controller);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = COMBAT_PANEL_RATIO;
        leftPanel.add(combatPanel, gbc);

        final CommandPanel commandPanel = new CommandPanel(controller);
        gbc.gridy = 1;
        gbc.weighty = COMMAND_PANEL_RATIO;
        leftPanel.add(commandPanel, gbc);

        // Right panel (BattleLog)
        final JPanel rightPanel = new JPanel(new BorderLayout());
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) (screenSize.width * RIGHT_PANEL_RATIO);
        rightPanel.setPreferredSize(new Dimension(width, 0));
        this.add(rightPanel, BorderLayout.EAST);

        // Log Panel
        final BattleLog battleLog = new BattleLog(controller);
        rightPanel.add(battleLog, BorderLayout.CENTER);
    }
}
