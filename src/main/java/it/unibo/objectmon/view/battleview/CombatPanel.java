package it.unibo.objectmon.view.battleview;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import it.unibo.objectmon.view.utility.ImageLoader;
import it.unibo.objectmon.view.utility.ImageLoaderImpl;
import it.unibo.objectmon.view.utility.RenderingUtils;
import it.unibo.objectmon.controller.Controller;

/**
 * A panel that is used to display the flow of the battle.
 */
public final class CombatPanel extends JPanel {
    private static final long serialVersionUID = 4L;
    private final transient Controller controller;
    private final transient ImageLoader imageLoader;

    /**
     * Constructs a combat panel and attaches a controller to it.
     * 
     * @param controller The controller from which to poll information.
     */
    public CombatPanel(final Controller controller) {
        this.controller = controller;
        this.imageLoader = new ImageLoaderImpl();
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (g instanceof Graphics2D) {
            final Graphics2D graphics2d = (Graphics2D) g;
            RenderingUtils.configureRenderingHints(graphics2d);
            drawBackgroud(graphics2d);
            drawObjectmons(graphics2d);
            graphics2d.dispose();
        }
    }

    private void drawBackgroud(final Graphics2D g) {
        final BufferedImage background = imageLoader.getImage("/battle/background.png");
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    private void drawObjectmons(final Graphics2D g) {
        final BufferedImage playerObjectmon = imageLoader.getImage("/objectmon/"
            + controller.getBattleStats().get().getCurrentObjectmon().getName()
            + ".png");
        final BufferedImage enemyObjectmon = imageLoader.getImage("/objectmon/"
            + controller.getBattleStats().get().getEnemyObjectmon().getName()
            + ".png");
        //Draws the player's objectmon at the bottom left.
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        g.drawImage(playerObjectmon, 0, height, width, height, null);
        drawObjectmonInfo(g, controller.getBattleStats().get().getCurrentObjectmon().getName(), controller.getBattleStats().get().getCurrentObjectmon().getLevel(), controller.getBattleStats().get().getCurrentObjectmon().getCurrentHp(), 0, 0);
        //Draws the enemy objectmon at the top right.
        width = getWidth() / 2;
        height = getHeight() / 2;
        g.drawImage(enemyObjectmon, width, 0, width, height, null);
        drawObjectmonInfo(g, controller.getBattleStats().get().getEnemyObjectmon().getName(), controller.getBattleStats().get().getEnemyObjectmon().getLevel(), controller.getBattleStats().get().getEnemyObjectmon().getCurrentHp(), width, 0);
    }

    private void drawObjectmonInfo(Graphics2D g, String name, int level, int health, int x, int y) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        FontMetrics fm = g.getFontMetrics();
    
        // Draw objectmon name
        int nameWidth = fm.stringWidth(name);
        g.drawString(name, x + (getWidth() / 4) - (nameWidth / 2), y + 20);
    
        // Draw objectmon level
        String levelText = "Level: " + level;
        int levelWidth = fm.stringWidth(levelText);
        g.drawString(levelText, x + (getWidth() / 4) - (levelWidth / 2), y + 40);
    
        // Draw objectmon health
        String healthText = "Health: " + health;
        int healthWidth = fm.stringWidth(healthText);
        g.drawString(healthText, x + (getWidth() / 4) - (healthWidth / 2), y + 60);
    }
}
