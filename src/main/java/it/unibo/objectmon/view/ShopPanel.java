package it.unibo.objectmon.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.commands.BuyItem;
import it.unibo.objectmon.controller.commands.ExitShop;
import it.unibo.objectmon.controller.commands.SellItem;
import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.HealEnum;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.impl.HealItemImpl;

/**
 * GUI for the item buying system.
 */
public class ShopPanel extends JPanel {
    private static final long serialVersionUID = 5L;
    private static final int WIDTH_SCROLLPANE = 200;
    private static final int HEIGHT_SCROLLPANE = 80;
    private final JPanel itemContainerPanel;
    private final JLabel moneyLabel = new JLabel();
    private final transient Controller controller;

    /**
     * Constructs a shop panel.
     * @param controller
     */
    public ShopPanel(final Controller controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        //player info panel
        final JPanel playerInfoPanel = new JPanel(new BorderLayout());
        moneyLabel.setText("Player credits: " + controller.getPlayer().getInventory().getCredits());
        playerInfoPanel.add(moneyLabel, BorderLayout.CENTER);

        //back button
        final JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.notifyCommand(new ExitShop());
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
            addItemPanel(ball.getImagePath(), description, new BallItemImpl(ball));
        }

        for (final HealEnum heal : HealEnum.values()) {
            final String description = heal.getDescription() + "\nHealing amount : " + heal.getHealingAmount();
            addItemPanel(heal.getImagePath(), description, new HealItemImpl(heal));
        }
    }

    private void addItemPanel(final String imagePath, final String description, final Item item) {

        final JPanel itemPanel = new JPanel(new BorderLayout());
        //Icon
        final URL resourceUrl = ShopPanel.class.getResource(imagePath);
        final ImageIcon icon = new ImageIcon(resourceUrl);
        final JLabel iconLabel = new JLabel(icon);
        itemPanel.add(iconLabel, BorderLayout.WEST);
        //Right side panel
        final JPanel rightPanel = new JPanel(new BorderLayout());
        //Info Panel(Name, Description)
        final JPanel infoPanel = new JPanel(new BorderLayout());
        //Name
        final JLabel nameLabel = new JLabel(item.getName());
        infoPanel.add(nameLabel, BorderLayout.NORTH);
        //Description
        final JTextArea descriptionTextArea = new JTextArea(description);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setEditable(false);
        final JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionScrollPane.setPreferredSize(new Dimension(WIDTH_SCROLLPANE, HEIGHT_SCROLLPANE));
        infoPanel.add(descriptionScrollPane, BorderLayout.CENTER);
        rightPanel.add(infoPanel, BorderLayout.CENTER);

        //Owned Amount
        final JPanel buttonPanel = new JPanel(new FlowLayout());
        final int quantity = controller.getPlayer().getInventory().getItems().getOrDefault(item, 0);
        final JLabel quantityLabel = new JLabel("Owned: " + quantity);
        buttonPanel.add(quantityLabel);
        //Buy button
        final JButton buyButton = new JButton("Buy (" + item.getValue() + " credits)");
        buyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.notifyCommand(new BuyItem(item));
                //Tells the controller to execute it immediately.
                controller.execute();
                //Update the player credits label
                moneyLabel.setText("Player credits: " + controller.getPlayer().getInventory().getCredits());
                //Update the owned quantity label
                quantityLabel.setText("Owned: " + controller.getPlayer().getInventory().getItems().getOrDefault(item, 0));
            }
        });
        buttonPanel.add(buyButton);

        //Sell button
        final JButton sellButton = new JButton("Sell");
        sellButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.notifyCommand(new SellItem(item));
                //Tells the controller to execute it immediately
                controller.execute();
                //Update the player credits label
                moneyLabel.setText("Player credits: " + controller.getPlayer().getInventory().getCredits());
                //Update the owned quantity label
                quantityLabel.setText("Owned: " + controller.getPlayer().getInventory().getItems().getOrDefault(item, 0));
            }
        });
        buttonPanel.add(sellButton);

        rightPanel.add(buttonPanel, BorderLayout.SOUTH);
        itemPanel.add(rightPanel, BorderLayout.CENTER);
        itemContainerPanel.add(itemPanel);
    }
}
