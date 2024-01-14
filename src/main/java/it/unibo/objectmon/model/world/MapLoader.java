package it.unibo.objectmon.model.world;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import com.google.gson.Gson;

public class MapLoader {

    private static final String PATH = "/world/world.json.tmj";

    public static MapLoader.MapData loadFromJson() {
        InputStream inputStream = MapLoader.class.getResourceAsStream(PATH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        final Gson gson = new Gson();
        return gson.fromJson(reader, MapData.class);
    }

    public static class MapData {
        private List<Layer> layers;
        private int height;
        private int width;
    
        public List<Layer> getLayers() {
            return layers;
        }
    
        public int getHeight() {
            return height;
        }
    
        public int getWidth() {
            return width;
        }


    }
    public static class Layer {
        private List<Integer> data;

        public List<Integer> getData() {
            return data;
        }
    }
}
