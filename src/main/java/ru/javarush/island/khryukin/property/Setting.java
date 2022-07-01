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
    public static final double WOLF_WEIGHT = 50;
    public static final double WOLF_MAX_WEIGHT = 50;
    public static final int WOLF_MAX_COUNT = 30;
    public static final int WOLF_MAX_SPEED = 3;
    public static final int WOLF_MAX_FOOD = 8;

    //Настройки для лошади
    public static final String HORSE_NAME = "Horse";
    public static final String HORSE_ICON = "\uD83D\uDC0E";
    public static final double HORSE_WEIGHT = 400;
    public static final double HORSE_MAX_WEIGHT = 400;
    public static final int HORSE_MAX_COUNT = 20;
    public static final int HORSE_MAX_SPEED = 4;
    public static final int HORSE_MAX_FOOD = 60;

    //Настройки для удава
    public static final String BOA_NAME = "Boa";
    public static final String BOA_ICON = "\uD83D\uDC0D";
    public static final double BOA_WEIGHT = 15;
    public static final double BOA_MAX_WEIGHT = 15;
    public static final int BOA_MAX_COUNT = 30;
    public static final int BOA_MAX_SPEED = 1;
    public static final int BOA_MAX_FOOD = 3;

    //Настройки для лисы
    public static final String FOX_NAME = "Fox";
    public static final String FOX_ICON = "\uD83E\uDD8A";
    public static final double FOX_WEIGHT = 8;
    public static final double FOX_MAX_WEIGHT = 8;
    public static final int FOX_MAX_COUNT = 30;
    public static final int FOX_MAX_SPEED = 2;
    public static final int FOX_MAX_FOOD = 2;

    //Настройки для лисы
    public static final String BEAR_NAME = "Bear";
    public static final String BEAR_ICON = "\uD83D\uDC3B";
    //public static final double BEAR_WEIGHT = 500;
    public static final double BEAR_MAX_WEIGHT = 500;
    public static final int BEAR_MAX_COUNT = 5;
    public static final int BEAR_MAX_SPEED = 2;
    public static final int BEAR_MAX_FOOD = 80;

    //Настройки для растения
    public static final String PLANT_NAME = "Plant";
    public static final String PLANT_ICON = "\uD83C\uDF3F";
    //public static final double PLANT_WEIGHT = 1;
    public static final double PLANT_MAX_WEIGHT = 1;
    public static final int PLANT_MAX_COUNT = 2000;
    public static final int PLANT_MAX_SPEED = 0;
    public static final int PLANT_MAX_FOOD = 0;

}
