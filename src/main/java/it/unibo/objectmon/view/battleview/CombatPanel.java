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
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 * A panel used to display the flow of the battle.
 */
public final class CombatPanel extends JPanel {
    private static final long serialVersionUID = 4L;
    private static final int Y_OFFSET = 20;
    private static final Font DEFAULT_FONT = new Font("Arial", Font.BOLD, 16);
    private final transient Controller controller;
    private final transient ImageLoader imageLoader;

    /**
     * Constructs a {@link CombatPanel} and attaches a {@link Controller} to it.
     * 
     * @param controller The {@link Controller} from which information is retrieved.
     */
    public CombatPanel(final Controller controller) {
        this.controller = controller;
        this.imageLoader = new ImageLoaderImpl();
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (g instanceof Graphics2D && controller.getGameState() != GameState.PAUSE) {
            final Graphics2D graphics2d = (Graphics2D) g;
            RenderingUtils.configureRenderingHints(graphics2d);
            drawBackgroud(graphics2d);
            drawChallengers(graphics2d);
            drawObjectmonCount(graphics2d);
            drawObjectmons(graphics2d);
            graphics2d.dispose();
        }
    }
    //Draws the background to fill the entire component width and height available.
    private void drawBackgroud(final Graphics2D g) {
        final BufferedImage background = imageLoader.getImage("/battle/background.png");
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    private void drawObjectmons(final Graphics2D g) {
        final Battle battleInfo = controller.getBattleStats().get();
        final Objectmon playerObjectmon = battleInfo.getCurrentObjectmon();
        final Objectmon enemyObjectmon = battleInfo.getEnemyObjectmon();
        final BufferedImage playerObjectmonImg = imageLoader.getImage("/battle/objectmon/"
            + playerObjectmon.getName()
            + ".png");
        final BufferedImage enemyObjectmonImg = imageLoader.getImage("/battle/objectmon/"
            + enemyObjectmon.getName()
            + ".png");
        final int width = getWidth() / 2;
        final int height = getHeight() / 2;
        //Draws the player objectmon in the middle left.
        g.drawImage(playerObjectmonImg, 0, height - playerObjectmonImg.getHeight() / 2, width, height, null);
        //Draws the player objectmon information just above half it's image height.
        drawObjectmonInfo(g, playerObjectmon, 0, height - playerObjectmonImg.getHeight() / 2);
        //Draws the enemy objectmon in the middle right.
        g.drawImage(enemyObjectmonImg, width, height - enemyObjectmonImg.getHeight() / 2, width, height, null);
        //Draws the enemy objectmon information just above half it's image height.
        drawObjectmonInfo(g, enemyObjectmon, width, height - enemyObjectmonImg.getHeight() / 2);
    }

    private void drawObjectmonInfo(final Graphics2D g, final Objectmon objectmon, final int x, final int y) {
        g.setColor(Color.WHITE);
        g.setFont(DEFAULT_FONT);
        final FontMetrics fm = g.getFontMetrics();
        //Draw objectmon name.
        final int nameWidth = fm.stringWidth(objectmon.getName());
        g.drawString(objectmon.getName(), x + (getWidth() / 4) - (nameWidth / 2), y + Y_OFFSET);
        //Draw objectmon level.
        final String levelText = "Level: " + objectmon.getLevel();
        final int levelWidth = fm.stringWidth(levelText);
        g.drawString(levelText, x + (getWidth() / 4) - (levelWidth / 2), y + Y_OFFSET * 2);
        //Draw objectmon health.
        final String healthText = "Health: " + objectmon.getCurrentHp() + "/" + objectmon.getStats().getSingleStat(StatId.HP);
        final int healthWidth = fm.stringWidth(healthText);
        g.drawString(healthText, x + (getWidth() / 4) - (healthWidth / 2), y + Y_OFFSET * 3);
    }

    private void drawChallengers(final Graphics2D g) {
        final Battle battleInfo = controller.getBattleStats().get();
        final Player player = battleInfo.getPlayer();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), Y_OFFSET * 2);
        g.setColor(Color.WHITE);
        g.setFont(DEFAULT_FONT);
        final FontMetrics fm = g.getFontMetrics();
        final String text;
        if (battleInfo.getTrainer().isPresent()) {
            final Trainer enemy = battleInfo.getTrainer().get();
            text = player.getName() + " vs " + enemy.getName();
        } else {
            text = player.getName() + " vs Random Encounter";
        }
        //Centered in the middle.
        final int textWidth = fm.stringWidth(text);
        final int x = (getWidth() - textWidth) / 2;
        g.drawString(text, x, Y_OFFSET);
    }

    private void drawObjectmonCount(final Graphics2D g) {
        final Battle battleInfo = controller.getBattleStats().get();
        final int playerObjectmonCount = battleInfo.getPlayerTeam().getParty().size();
        final int enemyObjectmonCount = battleInfo.getTrainerTeam()
            .map(trainerTeam -> trainerTeam.getParty().size())
            .orElse(0);
        g.setColor(Color.WHITE);
        g.setFont(DEFAULT_FONT);
        final FontMetrics fm = g.getFontMetrics();
        // Draw player objectmon count at the top left corner.
        final String playerCountText = battleInfo.getPlayer().getName() + " objectmons: " + playerObjectmonCount;
        g.drawString(playerCountText, 10, Y_OFFSET);
        // Draw enemy objectmon count at the top right corner.
        if (battleInfo.getTrainer().isPresent()) {
            final String enemyCountText = battleInfo.getPlayer().getName() + " objectmons: " + enemyObjectmonCount;
            final int enemyCountWidth = fm.stringWidth(enemyCountText);
            g.drawString(enemyCountText, getWidth() - enemyCountWidth - 10, Y_OFFSET);
        }
    }
}
