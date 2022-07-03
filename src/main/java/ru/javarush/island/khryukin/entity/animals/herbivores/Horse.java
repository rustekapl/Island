package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Horse extends Animal {
    public Horse(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Horse(Setting.HORSE_NAME, Setting.HORSE_ICON, Setting.HORSE_MAX_WEIGHT, new Limit(Setting.HORSE_MAX_WEIGHT, Setting.HORSE_MAX_COUNT, Setting.HORSE_MAX_SPEED, Setting.HORSE_MAX_FOOD));
    }
}
