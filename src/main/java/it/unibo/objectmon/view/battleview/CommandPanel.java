package it.unibo.objectmon.view.battleview;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;

/**
 * The panel responsible for sending the player choices to the model.
 */
@SuppressWarnings("PMD")
public class CommandPanel extends JPanel {
    private static final long serialVersionUID = 5L;
    private final transient Controller controller;
    private final JButton attackButton = new JButton("Attack");
    private final JButton switchButton = new JButton("Switch");
    private final JButton itemButton = new JButton("Use item");
    private final JButton fleeButton = new JButton("Run away");

    /**
     * Constructs a JPanel displaying some buttons.
     * 
     * @param controller The controller to which commands are sent.
     */
    public CommandPanel(final Controller controller) {
        this.controller = controller;
        this.setLayout(new GridBagLayout());
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                drawAttacks();
            }
        });
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                drawSwitch();
            }
        });
        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                drawItems();
            }
        });
        fleeButton.addActionListener(null); //To be substituted with something like controller.notifyCommand(new RunAway())
        drawStartingButtons();
    }

    private void drawAttacks() {
        this.removeAll();
        final GridBagConstraints gbc = createDefaultConstraints();

        final JButton attack1 = new JButton("Attack 1");
        attack1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        this.add(attack1, gbc);


        final JButton attack2 = new JButton("Attack 2");
        attack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(attack2, gbc);

        final JButton attack3 = new JButton("Attack 3");
        attack3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(attack3, gbc);


        final JButton attack4 = new JButton("Attack 4");
        attack4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(attack4, gbc);
        this.revalidate();
    }

    private void drawSwitch() {
        this.removeAll();
        final GridBagConstraints gbc = createDefaultConstraints();
        final JButton switch1 = new JButton("Switch choice 1");
        switch1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        this.add(switch1, gbc);
        final JButton switch2 = new JButton("Switch choice 2");
        switch2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(switch2, gbc);
        final JButton switch3 = new JButton("Switch choice 3");
        switch3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(switch3, gbc);
        final JButton switch4 = new JButton("Switch choice 4");
        switch4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(switch4, gbc);
        final JButton switch5 = new JButton("Switch choice 5");
        switch5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(switch5, gbc);
        final JButton switch6 = new JButton("Switch choice 6");
        switch6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(switch6, gbc);
        this.revalidate();
    }

    private void drawItems() {
        this.removeAll();
        final GridBagConstraints gbc = createDefaultConstraints();
        final JButton item1 = new JButton("Item 1");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        this.add(item1, gbc);
        final JButton item2 = new JButton("Item 2");
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(item2, gbc);
        final JButton item3 = new JButton("Item 3");
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(item3, gbc);
        final JButton item4 = new JButton("Item 4");
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(item4, gbc);
        final JButton item5 = new JButton("Item 5");
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(item5, gbc);
        final JButton item6 = new JButton("Item 6");
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                removeAll();
                drawStartingButtons();
            }
        });
        gbc.gridx++;
        this.add(item6, gbc);
        this.revalidate();
    }

    private void drawStartingButtons() {
        final GridBagConstraints gbc = createDefaultConstraints();
        this.add(attackButton, gbc);
        gbc.gridx++;
        this.add(switchButton, gbc);
        gbc.gridx++;
        this.add(itemButton, gbc);
        gbc.gridx++;
        this.add(fleeButton, gbc);
    }

    private GridBagConstraints createDefaultConstraints() {
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
}
