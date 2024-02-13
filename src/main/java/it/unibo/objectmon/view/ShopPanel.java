package it.unibo.objectmon.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.HealEnum;

/**
 * GUI for the item buying system.
 */
public class ShopPanel extends JPanel {

    private final JPanel itemContainerPanel;
    private final JLabel moneyLabel = new JLabel("Credits: 1000 coins"); //update via controller
    private final Controller controller;

    /**
     * Constructs a shop panel.
     * @param controller
     */
    public ShopPanel(final Controller controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        //player info panel
        final JPanel playerInfoPanel = new JPanel(new BorderLayout());
        playerInfoPanel.add(moneyLabel, BorderLayout.CENTER);

        //back button
        final JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                //sends request to the controller
            }
        });
        playerInfoPanel.add(backButton, BorderLayout.EAST);

        this.add(playerInfoPanel, BorderLayout.NORTH);

        //item container panel
        itemContainerPanel = new JPanel();
        itemContainerPanel.setLayout(new BoxLayout(itemContainerPanel, BoxLayout.Y_AXIS));

        addItemsToContainerPanel();

        final JScrollPane scrollPane = new JScrollPane(itemContainerPanel);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void addItemsToContainerPanel() {
        for (final BallEnum ball : BallEnum.values()) {
            final String description = ball.getDescription() + "\nCatch multiplier : " + ball.getCatchRateMultiplier();
            final int owned = 0; //controller.getPlayer.getInventory.get....
            addItemPanel(ball.getName(), ball.getValue(), ball.getImagePath(), description, owned);
        }

        for (final HealEnum heal : HealEnum.values()) {
            final String description = heal.getDescription() + "\nHealing amount : " + heal.getHealingAmount();
            final int owned = 0; //controller.getPlayer.getInventory.get....
            addItemPanel(heal.getName(), heal.getValue(), heal.getImagePath(), description, owned);
        }
    }

    private void addItemPanel(final String itemName, 
        final int value, 
        final String imagePath, 
        final String description, 
        final int quantity) {

            final JPanel itemPanel = new JPanel(new BorderLayout());
            //Icon
            final ImageIcon icon = new ImageIcon(this.getClass().getResource(imagePath));
            final JLabel iconLabel = new JLabel(icon);
            itemPanel.add(iconLabel, BorderLayout.WEST);
            //Info Panel(Name, Description)
            final JPanel infoPanel = new JPanel(new BorderLayout());
            //Name
            final JLabel nameLabel = new JLabel(itemName);
            infoPanel.add(nameLabel, BorderLayout.NORTH);
            //Description
            final JTextArea descriptionTextArea = new JTextArea(description);
            descriptionTextArea.setLineWrap(true);
            descriptionTextArea.setWrapStyleWord(true);
            descriptionTextArea.setEditable(false);
            final JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
            descriptionScrollPane.setPreferredSize(new Dimension(200, 80));
            infoPanel.add(descriptionScrollPane, BorderLayout.CENTER);
            itemPanel.add(infoPanel, BorderLayout.CENTER);
            //Owned Amount
            final JPanel quantityPanel = new JPanel(new BorderLayout());
            final JLabel quantityLabel = new JLabel("Owned: " + quantity);
            quantityPanel.add(quantityLabel, BorderLayout.WEST);
            //Buy button
            final JButton buyButton = new JButton("Buy (" + value + " credits)");
            buyButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent e) {
                    //notify command
                }
            });
            quantityPanel.add(buyButton, BorderLayout.EAST);
            itemPanel.add(quantityPanel, BorderLayout.SOUTH);
            itemContainerPanel.add(itemPanel);

    }
}
