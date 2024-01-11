package it.unibo.objectmon.model.world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class used to read a matrix like file and turn it into a game readable map.
 */
public final class WorldLoader {

    private final Logger logger = Logger.getLogger("WorldLoader");
    /**
     * @return a LinkedHashSet that containts every coordinates paired with its tile type.
     */
    public World getWorld() {
        final World out = new World();
        try (
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("world/world1.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        ) {
            int i = 0;
            String string = bufferedReader.readLine();
            while (string != null) {
                final String[] values = string.split("\\s+");
                for (int j = 0; j < values.length; j++) {
                    TileType tileType;
                    switch (values[j]) {
                        case "0":
                            tileType = TileType.WATER;
                            break;
                        case "1":
                            tileType = TileType.GRASS;
                            break;
                        default:
                            tileType = TileType.VOID;
                            break;
                    }
                    out.setTileAt(new Coord(i, j), new Tile(tileType));
                }
                string = bufferedReader.readLine();
                i++;
            }
        } catch (final IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
            //TODO Could be improved bu also printing stacktrace
        }
        return out;
    }

    /*  TEST
    public static void main(String[] args) {

        WorldLoader wl = new WorldLoader();
        var world = wl.getWorld();
        System.out.println(world.getTileAt(new Coord(2, 0)).toString());
        //expects grass
    }
    */
}
