package ru.javarush.island.zazimko.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.javarush.island.zazimko.entity.organizms.Organism;
import ru.javarush.island.zazimko.entity.organizms.animals.herbivores.*;
import ru.javarush.island.zazimko.entity.organizms.animals.predators.*;
import ru.javarush.island.zazimko.entity.organizms.plants.Plant;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter(AccessLevel.PROTECTED)
public class Setting {

    private static final Class<?>[] TYPES = {Wolf.class, Bear.class, Horse.class, Mouse.class, Plant.class, Eagle.class, Fox.class, Snake.class,
            Buffalo.class, Caterpillar.class, Deer.class, Duck.class, Goat.class, Hog.class, Rabbit.class, Sheep.class};

    public static final Organism[] PROTOTYPES = EntityScanner.createPrototypes(TYPES);

    private static volatile Setting SETTING;

    public static Setting get() {
        Setting setting = SETTING;
        if (Objects.isNull(setting)) {
            synchronized (Setting.class) {
                if (Objects.isNull(setting = SETTING)) {
                    setting = SETTING = new Setting();
                }
            }
        }
        return setting;
    }

    private int period;
    private int rows;
    private int cols;

    private int showRows;
    private int showCols;
    private int consoleCellWith;
    private int percentAnimalSlim;
    private int percentPlantGrow;
    @Getter(AccessLevel.PROTECTED)
    private Map<String, Map<String, Integer>> foodMap = new LinkedHashMap<>();

    public Map<String, Integer> getFoodMap(String keyName) {
        this.foodMap.putIfAbsent(keyName, new LinkedHashMap<>());
        return foodMap.get(keyName);
    }

    private Setting() {
        loadFromDefault();
    }

    private void loadFromDefault() {
        period = Default.PERIOD;

        rows = Default.ROWS;
        cols = Default.COLS;

        showRows = Default.SHOW_ROWS;
        showCols = Default.SHOW_COLS;
        consoleCellWith = Default.CONSOLE_CELL_WITH;
        percentAnimalSlim = Default.PERCENT_ANIMAL_SLIM;
        percentPlantGrow = Default.PERCENT_PLANT_GROW;
        for (int i = 0, n = Default.names.length; i < n; i++) {
            String key = Default.names[i];
            this.foodMap.putIfAbsent(key, new LinkedHashMap<>());
            for (int j = 0; j < n; j++) {
                int ratio = Default.setProbablyTable[i][j];
                if (ratio > 0) {
                    this.foodMap.get(key).put(Default.names[j], ratio);
                }
            }
        }
    }

}