package it.unibo.objectmon.view;

import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.World;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WorldRenderer extends JPanel{
    private World world;
    private int squareSize = 48;

    public WorldRenderer(World world) {
        this.world = world;
    }

    public void draw(final Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        for (Coord coord : world.getTiles().keySet()) {
            g2.setColor(Color.RED);
            int scaledX = coord.x() * squareSize;
            int scaledY = coord.y() * squareSize;
            Image img;
            switch (world.getTileAt(coord).getType()) {
                case WATER:
                    try {
                        img = ImageIO.read(getClass().getResourceAsStream("/textures/water.png"));
                        g2.drawImage(img, scaledX, scaledY, null);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    break;
                case GRASS:
                    try {
                        img = ImageIO.read(getClass().getResourceAsStream("/textures/grass.png"));
                        g2.drawImage(img, scaledX, scaledY, null);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        g2.dispose();
    }

}
