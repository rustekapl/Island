package ru.javarush.island.zazimko.modificators;

import ru.javarush.island.zazimko.classes.animals.carnivores.*;
import ru.javarush.island.zazimko.classes.animals.herbivores.*;
import ru.javarush.island.zazimko.classes.plants.Plant;

import java.io.Serializable;

public class Config implements Serializable {

    //TODO Coding. Hard code. Not flexible
    public static final int SIZE = 20;
    public static final int HEIGHT = 5;
    public static final int WIDTH = 5;
    //********************************
    // array of animal types to start the game with
    public static final Class<?>[] TYPES = {Plant.class, Horse.class, Bear.class, Eagle.class, Fox.class, Snake.class, Wolf.class,
            Buffalo.class, Caterpillar.class, Deer.class, Duck.class, Goat.class, Hog.class, Mouse.class, Rabbit.class, Sheep.class};
    public static final int INITIAL_VALUE = 50;
    //*********************************

    public static final int BEAR_WEIGHT = 500;
    public static final int WOLF_WEIGHT = 50;
    public static final int SNAKE_WEIGHT = 15;
    public static final int FOX_WEIGHT = 8;
    public static final int EAGLE_WEIGHT = 6;
    public static final int HORSE_WEIGHT = 400;
    public static final int DEER_WEIGHT = 300;
    public static final int RABBIT_WEIGHT = 2;
    public static final double MOUSE_WEIGHT = 40;
    public static final int GOAT_WEIGHT = 60;
    public static final int SHEEP_WEIGHT = 70;
    public static final int HOG_WEIGHT = 400;
    public static final int BUFFALO_WEIGHT = 700;
    public static final int DUCK_WEIGHT = 1;
    public static final double CATERPILLAR_WEIGHT = 0.01d;
    public static final int PLANT_WEIGHT = 1;
    //***********************************
    public static final int BEAR_SPEED = 2;
    public static final int WOLF_SPEED = 3;
    public static final int SNAKE_SPEED = 1;
    public static final int FOX_SPEED = 2;
    public static final int EAGLE_SPEED = 3;
    public static final int HORSE_SPEED = 4;
    public static final int DEER_SPEED = 4;
    public static final int RABBIT_SPEED = 2;
    public static final int MOUSE_SPEED = 1;
    public static final int GOAT_SPEED = 3;
    public static final int SHEEP_SPEED = 3;
    public static final int HOG_SPEED = 2;
    public static final int BUFFALO_SPEED = 3;
    public static final int DUCK_SPEED = 4;
    public static final int CATERPILLAR_SPEED = 0;
    //**********************************
    public static final String BEAR_ICON = "\uD83D\uDC3B";
    public static final String HOG_ICON = "\uD83D\uDC17";
    public static final String HORSE_ICON = "\uD83D\uDC0E";
    public static final String DEER_ICON = "\uD83E\uDD8C";
    public static final String BUFFALO_ICON = "\uD83D\uDC03";
    public static final String SHEEP_ICON = "\uD83D\uDC11";
    public static final String GOAT_ICON = "\uD83D\uDC10";
    public static final String WOLF_ICON = "\uD83D\uDC3A";
    public static final String SNAKE_ICON = "\uD83D\uDC0D";
    public static final String FOX_ICON = "\uD83E\uDD8A";
    public static final String EAGLE_ICON = "\uD83E\uDD85";
    public static final String RABBIT_ICON = "\uD83D\uDC07";
    public static final String DUCK_ICON = "\uD83E\uDD86";
    public static final String CATERPILLAR_ICON = "\uD83D\uDC1B";
    public static final String MOUSE_ICON = "\uD83D\uDC01";
    public static final String PLANT_ICON = "\uD83C\uDF3F";
    //*************************************************
    public static final double BEAR_SATIETY = 80;
    public static final double WOLF_SATIETY = 8;
    public static final double SNAKE_SATIETY = 3;
    public static final double FOX_SATIETY = 2;
    public static final double EAGLE_SATIETY = 1;
    public static final double HORSE_SATIETY = 60;
    public static final double DEER_SATIETY = 50;
    public static final double RABBIT_SATIETY = 0.45d;
    public static final double MOUSE_SATIETY = 0.01d;
    public static final double GOAT_SATIETY = 10;
    public static final double SHEEP_SATIETY = 15;
    public static final double HOG_SATIETY = 50;
    public static final double BUFFALO_SATIETY = 100;
    public static final double DUCK_SATIETY = 0.15d;
    public static final double CATERPILLAR_SATIETY = 0;
    //*******************************
    public static final int BEAR_MAX_VALUE = 5;
    public static final int WOLF_MAX_VALUE = 30;
    public static final int SNAKE_MAX_VALUE = 30;
    public static final int FOX_MAX_VALUE = 30;
    public static final int EAGLE_MAX_VALUE = 20;
    public static final int HORSE_MAX_VALUE = 20;
    public static final int DEER_MAX_VALUE = 20;
    public static final int RABBIT_MAX_VALUE = 150;
    public static final int MOUSE_MAX_VALUE = 500;
    public static final int GOAT_MAX_VALUE = 140;
    public static final int SHEEP_MAX_VALUE = 140;
    public static final int HOG_MAX_VALUE = 50;
    public static final int BUFFALO_MAX_VALUE = 10;
    public static final int DUCK_MAX_VALUE = 200;
    public static final int CATERPILLAR_MAX_VALUE = 1000;
    public static final int PLANT_MAX_VALUE = 200;


}
