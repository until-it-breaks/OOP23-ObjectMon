package it.unibo.objectmon.view.battleview;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import it.unibo.objectmon.view.utility.ImageLoader;
import it.unibo.objectmon.view.utility.ImageLoaderImpl;

import it.unibo.objectmon.controller.Controller;

/**
 * A panel that is used to display the flow of the battle.
 */
@SuppressWarnings("PMD")
public class CombatPanel extends JPanel {
    private static final long serialVersionUID = 4L;
    private final transient Controller controller;
    private final double scale = 2.0;

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
        ImageLoader loader = new ImageLoaderImpl();
        BufferedImage image = loader.getImage("/battle/background.png");
        BufferedImage image2 = loader.getImage("/objectmon/Kecleon.png");
        BufferedImage image3 = loader.getImage("/objectmon/Zigzagoon.png");
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        g.drawImage(image2, 0, height, width, height, null);
        width = getWidth() / 2;
        height = getHeight() / 2;
        g.drawImage(image3, width, 0, width, height, null);
    }
}
