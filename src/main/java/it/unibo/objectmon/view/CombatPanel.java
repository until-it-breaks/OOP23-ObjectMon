package it.unibo.objectmon.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import it.unibo.objectmon.controller.Controller;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatPanel extends JPanel {

    public CombatPanel(final Controller controller) {
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.7;
        gbc.fill = GridBagConstraints.BOTH;

        JPanel combatPanel = new JPanel();
        combatPanel.setBackground(Color.BLACK);
        this.add(combatPanel, gbc);

        //Sets the log box in the third row and allocates 20% of the total height
        gbc.gridy = 2;
        gbc.weighty = 0.2;
        JTextArea logBox = new JTextArea();
        logBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logBox);
        this.add(scrollPane, gbc);

        //Sets the commands in the second row and allocates 10% of total height
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        JPanel commandPanel = new JPanel();
        commandPanel.setLayout(new GridLayout());

        JButton attackButton = new JButton("Attack");
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawAttacks(commandPanel);
            }
            
        });
        commandPanel.add(attackButton);

        JButton switchButton = new JButton("Switch");
        commandPanel.add(switchButton);
        JButton itemButton = new JButton("Use Item");
        commandPanel.add(itemButton);
        JButton fleeButton = new JButton("Run Away");
        commandPanel.add(fleeButton);
        this.add(commandPanel, gbc);
    }

    private void drawAttacks(JPanel commandPanel) {
        commandPanel.removeAll();
        JButton attack1 = new JButton("Attack 1");
        commandPanel.add(attack1);
        JButton attack2 = new JButton("Attack 2");
        commandPanel.add(attack2);
        JButton attack3 = new JButton("Attack 3");
        commandPanel.add(attack3);
        JButton attack4 = new JButton("Attack 4");
        commandPanel.add(attack4);

        commandPanel.revalidate();
    }
}
