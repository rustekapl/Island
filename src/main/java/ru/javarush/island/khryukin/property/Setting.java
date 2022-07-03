package ru.javarush.island.khryukin.property;


import java.util.LinkedHashMap;
import java.util.Map;

public class Setting {
    //Заполняем рацион с вероятностью
    public static final Map<String, Map<String, Integer>> rationMap = new LinkedHashMap<>();
    static {
        for (int i = 0, n = AnimalsRation.names.length; i < n; i++) {
            String animalKey = AnimalsRation.names[i];
            rationMap.putIfAbsent(animalKey, new LinkedHashMap<>());
            for (int j = 0; j < n; j++) {
                int ration = AnimalsRation.setProbablyTable[i][j];
                if (ration > 0) {
                    rationMap.get(animalKey).put(AnimalsRation.names[j], ration);
                }
            }
        }
    }
    //Настройки карты
    public static final int MAP_ROWS = 10;
    public static final int MAP_COLS = 10;

    //Настройки для волка
    public static final String WOLF_NAME = "Wolf";
    public static final String WOLF_ICON = "\uD83D\uDC3A";
    public static final double WOLF_MAX_WEIGHT = 50;
    public static final int WOLF_MAX_COUNT = 30;
    public static final int WOLF_MAX_SPEED = 3;
    public static final int WOLF_MAX_FOOD = 8;

    //Настройки для лошади
    public static final String HORSE_NAME = "Horse";
    public static final String HORSE_ICON = "\uD83D\uDC0E";
    public static final double HORSE_MAX_WEIGHT = 400;
    public static final int HORSE_MAX_COUNT = 20;
    public static final int HORSE_MAX_SPEED = 4;
    public static final int HORSE_MAX_FOOD = 60;

    //Настройки для удава
    public static final String BOA_NAME = "Boa";
    public static final String BOA_ICON = "\uD83D\uDC0D";
    public static final double BOA_MAX_WEIGHT = 15;
    public static final int BOA_MAX_COUNT = 30;
    public static final int BOA_MAX_SPEED = 1;
    public static final int BOA_MAX_FOOD = 3;

    //Настройки для лисы
    public static final String FOX_NAME = "Fox";
    public static final String FOX_ICON = "\uD83E\uDD8A";
    public static final double FOX_MAX_WEIGHT = 8;
    public static final int FOX_MAX_COUNT = 30;
    public static final int FOX_MAX_SPEED = 2;
    public static final int FOX_MAX_FOOD = 2;

    //Настройки для лисы
    public static final String BEAR_NAME = "Bear";
    public static final String BEAR_ICON = "\uD83D\uDC3B";
    public static final double BEAR_MAX_WEIGHT = 500;
    public static final int BEAR_MAX_COUNT = 5;
    public static final int BEAR_MAX_SPEED = 2;
    public static final int BEAR_MAX_FOOD = 80;

    //Настройки для растения
    public static final String PLANT_NAME = "Plant";
    public static final String PLANT_ICON = "\uD83C\uDF3F";
    public static final double PLANT_MAX_WEIGHT = 1;
    public static final int PLANT_MAX_COUNT = 2000;
    public static final int PLANT_MAX_SPEED = 0;
    public static final int PLANT_MAX_FOOD = 0;

    //Настройки для орла
    public static final String EAGLE_NAME = "Eagle";
    public static final String EAGLE_ICON = "\uD83E\uDD85";
    public static final double EAGLE_MAX_WEIGHT = 6;
    public static final int EAGLE_MAX_COUNT = 20;
    public static final int EAGLE_MAX_SPEED = 3;
    public static final int EAGLE_MAX_FOOD = 1;

    //Настройки для оленя
    public static final String DEER_NAME = "Deer";
    public static final String DEER_ICON = "\uD83E\uDD8C";
    public static final double DEER_MAX_WEIGHT = 300;
    public static final int DEER_MAX_COUNT = 20;
    public static final int DEER_MAX_SPEED = 4;
    public static final int DEER_MAX_FOOD = 50;

    //Настройки для кролика
    public static final String RABBIT_NAME = "Rabbit";
    public static final String RABBIT_ICON = "\uD83D\uDC07";
    public static final double RABBIT_MAX_WEIGHT = 2;
    public static final int RABBIT_MAX_COUNT = 150;
    public static final int RABBIT_MAX_SPEED = 2;
    public static final double RABBIT_MAX_FOOD = 0.45;

    public static final String MOUSE_NAME = "Mouse";
    public static final String MOUSE_ICON = "\uD83D\uDC01";
    public static final double MOUSE_MAX_WEIGHT = 0.05;
    public static final int MOUSE_MAX_COUNT = 500;
    public static final int MOUSE_MAX_SPEED = 1;
    public static final double MOUSE_MAX_FOOD = 0.01;

    //Настройки для козы
    public static final String GOAT_NAME = "Goat";
    public static final String GOAT_ICON = "\uD83D\uDC10";
    public static final double GOAT_MAX_WEIGHT = 60;
    public static final int GOAT_MAX_COUNT = 140;
    public static final int GOAT_MAX_SPEED = 3;
    public static final double GOAT_MAX_FOOD = 10;

    //Настройки для овцы
    public static final String SHEEP_NAME = "Sheep";
    public static final String SHEEP_ICON = "\uD83D\uDC11";
    public static final double SHEEP_MAX_WEIGHT = 70;
    public static final int SHEEP_MAX_COUNT = 140;
    public static final int SHEEP_MAX_SPEED = 3;
    public static final double SHEEP_MAX_FOOD = 15;

    //Настройки для кабана
    public static final String BOAR_NAME = "Boar";
    public static final String BOAR_ICON = "\uD83D\uDC17";
    public static final double BOAR_MAX_WEIGHT = 400;
    public static final int BOAR_MAX_COUNT = 50;
    public static final int BOAR_MAX_SPEED = 2;
    public static final double BOAR_MAX_FOOD = 50;

    //Настройки для буйвола
    public static final String BUFFALO_NAME = "Buffalo";
    public static final String BUFFALO_ICON = "\uD83D\uDC03";
    public static final double BUFFALO_MAX_WEIGHT = 700;
    public static final int BUFFALO_MAX_COUNT = 10;
    public static final int BUFFALO_MAX_SPEED = 3;
    public static final double BUFFALO_MAX_FOOD = 100;

    //Настройки для утки
    public static final String DUCK_NAME = "Duck";
    public static final String DUCK_ICON = "\uD83E\uDD86";
    public static final double DUCK_MAX_WEIGHT = 1;
    public static final int DUCK_MAX_COUNT = 200;
    public static final int DUCK_MAX_SPEED = 4;
    public static final double DUCK_MAX_FOOD = 0.15;

    //Настройки для гусеницы
    public static final String CATERPILLAR_NAME = "Caterpillar";
    public static final String CATERPILLAR_ICON = "\uD83D\uDC1B";
    public static final double CATERPILLAR_MAX_WEIGHT = 0.01;
    public static final int CATERPILLAR_MAX_COUNT = 1000;
    public static final int CATERPILLAR_MAX_SPEED = 0;
    public static final double CATERPILLAR_MAX_FOOD = 0;

}
