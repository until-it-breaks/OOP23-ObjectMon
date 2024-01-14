package it.unibo.objectmon.model.world;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.sun.tools.javac.Main;


public class LoadMatrix {

    public static void main(String[] args) {

        final Gson gson = new Gson();
        String json;
        try {
            json = readFromClasspath("./world/world.json.tmj");
            MatrixData matrixData = gson.fromJson(json, MatrixData.class);
            System.out.println(matrixData.getHeight());
            System.out.println(matrixData.getWidth());
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
