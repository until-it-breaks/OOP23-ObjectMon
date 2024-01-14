package it.unibo.objectmon.model.world;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import com.sun.tools.javac.Main;

public class LoadTiles {
    public static void main(String[] args) {
        String path = "./textures/tileset_atlas.tsj";
        try {
            String json = readFromClasspath(path);
            TileSet tileSet = TileSet.loadFromJson(json);
            
            for (Tile tile : tileSet.getTiles()) {
                System.out.println(tile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFromClasspath(String filePath) throws IOException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);

        if (inputStream == null) {
            throw new IOException("File not found in the classpath: " + filePath);
        }

        try (Scanner scanner = new Scanner(inputStream)) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
