package it.unibo.objectmon.view.battleview;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.commands.RunAway;
import it.unibo.objectmon.controller.commands.SwitchObjectmon;
import it.unibo.objectmon.controller.commands.UseItem;
import it.unibo.objectmon.controller.commands.UseSkill;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.item.api.BallItem;
import it.unibo.objectmon.model.item.api.HealItem;

/**
 * The panel responsible for sending the player choices to the model.
 */
public final class CommandPanel extends JPanel {
    private static final long serialVersionUID = 5L;
    private final transient Controller controller;
    /**
     * The attack button expands into the available attack choices.
     */
    private final JButton attackButton = new JButton("Attack");
    /**
     * The switch button expands into the available switch choices.
     */
    private final JButton switchButton = new JButton("Switch");
    /**
     * The item button expands into the available item choices.
     */
    private final JButton itemButton = new JButton("Use Item");
    /**
     * The flee button.
     */
    private final JButton fleeButton = new JButton("Run away");
    /**
     * The button that allows to rethink your move.
     */
    private final JButton backButton = new JButton("Back");

    /**
     * Constructs a JPanel displaying some buttons.
     * 
     * @param controller The controller to which commands are sent.
     */
    public CommandPanel(final Controller controller) {
        this.controller = controller;
        this.setLayout(new GridBagLayout());
        attackButton.addActionListener(e -> {
            drawAttacks();
        });
        switchButton.addActionListener(e -> {
            drawSwitch();
        });
        itemButton.addActionListener(e -> {
            drawItems();
        });
        fleeButton.addActionListener(e -> {
            controller.notifyCommand(new RunAway());
        });
        backButton.addActionListener(e -> {
            removeAll();
            drawStartingButtons();
        });
        drawStartingButtons();
    }

    private void drawAttacks() {
        this.removeAll();
        final GridBagConstraints gbc = createDefaultConstraints();
        final int[] skillCounter = {0};
        for (final Skill skill : controller.getBattleStats().get().getCurrentObjectmon().getSkills()) {
            final JButton attackButton = new JButton(skill.getName());
            attackButton.setForeground(Color.WHITE);
            attackButton.setBackground(AspectColorMap.getColor(skill.getAspect()));
            final int currentSkillIndex = skillCounter[0];
            attackButton.addActionListener(e -> {
                    removeAll();
                    controller.notifyCommand(new UseSkill(currentSkillIndex));
                    drawStartingButtons();
            });
            attackButton.setToolTipText("Power: " + skill.getBasePower()
                + " Accuracy: " + skill.getAccuracy() + "% "
                + "Type: " + skill.getCategory().getName()
            );
            this.add(attackButton, gbc);
            gbc.gridx++;
            skillCounter[0]++;
        }
        this.add(backButton);
        this.revalidate();
        this.repaint();
    }

    private void drawSwitch() {
        this.removeAll();
        final GridBagConstraints gbc = createDefaultConstraints();
        final int[] objectmonCounter = {0};

        for (final Objectmon objectmon : controller.getBattleStats().get().getPlayerTeam().getParty()) {
            final JButton switchObjectmon = new JButton();
            switchObjectmon.setText(objectmon.getName());
            if (objectmon.equals(controller.getBattleStats().get().getCurrentObjectmon())) {
                switchObjectmon.setEnabled(false);
            }
            final int currentObjectmonIndex = objectmonCounter[0];
            switchObjectmon.addActionListener(e -> {
                    removeAll();
                    controller.notifyCommand(new SwitchObjectmon(currentObjectmonIndex));
                    drawStartingButtons();
            });
            switchObjectmon.setToolTipText("Aspects: " + objectmon.getAspects().toString()
            + " HP: " + objectmon.getCurrentHp() + " / " + objectmon.getStats().getSingleStat(StatId.HP));
            this.add(switchObjectmon, gbc);
            objectmonCounter[0]++;
            gbc.gridx++;
        }
        this.add(backButton);
        this.revalidate();
        this.repaint();
    }

    private void drawItems() {
        this.removeAll();
        final GridBagConstraints gbc = createDefaultConstraints();
        final int[] itemCounter = {0};
        for (final var entry : controller.getPlayer().getInventory().getItems().entrySet()) {
            final JButton itemButton = new JButton(entry.getKey().getName() + ": " + entry.getValue());
            if (entry.getKey() instanceof HealItem) {
                final HealItem heal = (HealItem) entry.getKey();
                itemButton.setToolTipText("Restores: " + heal.getHealPoints() + " HP");
            } else if (entry.getKey() instanceof BallItem) {
                final BallItem ball = (BallItem) entry.getKey();
                itemButton.setToolTipText("Catch rate multiplier : " + ball.getCatchMultiplier());
            }
            final int currentItemCount = itemCounter[0];
            itemButton.addActionListener(e -> {
                removeAll();
                controller.notifyCommand(new UseItem(currentItemCount));
                drawStartingButtons();
            });
            this.add(itemButton, gbc);
            itemCounter[0]++;
            gbc.gridx++;
        }
        this.add(backButton);
        this.revalidate();
        this.repaint();
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
        revalidate();
        repaint();
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
