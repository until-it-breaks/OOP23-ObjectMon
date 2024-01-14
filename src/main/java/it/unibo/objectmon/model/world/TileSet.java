package it.unibo.objectmon.model.world;

import java.util.List;

import com.google.gson.Gson;

public class TileSet {
    private int columns;
    private String image;
    private int imageheight;
    private int imagewidth;
    private String name;
    private int tilecount;
    private int tileheight;
    private List<Tile> tiles;

    public static TileSet loadFromJson(final String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, TileSet.class);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(final List<Tile> tiles) {
        this.tiles = tiles;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(final int columns) {
        this.columns = columns;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public int getImageheight() {
        return imageheight;
    }

    public void setImageheight(final int imageheight) {
        this.imageheight = imageheight;
    }

    public int getImagewidth() {
        return imagewidth;
    }

    public void setImagewidth(final int imagewidth) {
        this.imagewidth = imagewidth;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getTilecount() {
        return tilecount;
    }

    public void setTilecount(final int tilecount) {
        this.tilecount = tilecount;
    }

    public int getTileheight() {
        return tileheight;
    }

    public void setTileheight(final int tileheight) {
        this.tileheight = tileheight;
    }
}