package it.unibo.objectmon.model.world;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class TileSetLoader {
    
    private static final String PATH = "/textures/tileset.json.tsj";

    public static TileSetLoader.TileSet loadFromJson() {
        InputStream inputStream = TileSetLoader.class.getResourceAsStream(PATH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        final Gson gson = new Gson();
        TileSet out = gson.fromJson(reader, TileSet.class);
        out.calculateMappedTiles();
        return out;
    }

    public static class TileSet {
        private int columns;
        private int rows;
        private int imageheight;
        private int imagewidth;
        private int tileheight;
        private int tilewidth;
        private List<Tile> tiles;
        private Map<Integer, Coord> texturePosition = new HashMap<>();

        public List<Tile> getTiles() {
            return tiles;
        }

        public int getImageheight() {
            return imageheight;
        }

        public int getImagewidth() {
            return imagewidth;
        }

        public int getTileWidth() {
            return tilewidth;
        }

        public int getTileheight() {
            return tileheight;
        }

        public int getCols() {
            return columns;
        }

        public int getRows() {
            return rows;
        }

        public void calculateMappedTiles() {
            var iterator = tiles.iterator();
            for (int i = 0; i < this.columns; i++) {
                for (int j = 0; j < this.rows; j++) {
                    if (iterator.hasNext()) {
                        this.texturePosition.put(iterator.next().getId(), new Coord(i, j));
                    }
                }
            }
        }

        public Map<Integer, Coord> getTexturePositions() {
            return this.texturePosition;
        }
    }

    public static class Tile {
        private int id;
        private List<Property> properties;
        private String type;

        public List<Property> getProperties() {
            return properties;
        }
        
        public int getId() {
            return id;
        }
    
        public String getType() {
            return type;
        }
        
        @Override
        public String toString() {
            return "Tile [id=" + id + ", type=" + type + ", " + "properties=" + properties +"]";
        }
    }

    public static class Property {
        private String name;
        private boolean value;
        
        public String getName() {
            return name;
        }
    
        public boolean isValue() {
            return value;
        }
    
        @Override
        public String toString() {
            return name + "=" + value;
        }
    }

    /*
    public static void main(String[] args) {
        TileSet ts = TileSetLoader.loadFromJson();
        var coords = ts.getTexturePositions();
        for (var entry : coords.entrySet()) {
            System.out.println("id:" + entry.getKey() + " position " + entry.getValue());
        }
    }
    */
}
