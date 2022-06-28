package ru.javarush.island.ivanov.variables.island_params;

public class IslandWidthAndHeight {

    private static int width = 100;
    private static int height = 20;

    private IslandWidthAndHeight() {
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        IslandWidthAndHeight.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        IslandWidthAndHeight.height = height;
    }
}
