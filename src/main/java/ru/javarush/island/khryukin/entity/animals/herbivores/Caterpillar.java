package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Caterpillar extends Animal {
    public Caterpillar(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Caterpillar(Setting.CATERPILLAR_NAME, Setting.CATERPILLAR_ICON, Setting.CATERPILLAR_MAX_WEIGHT, new Limit(Setting.CATERPILLAR_MAX_WEIGHT, Setting.CATERPILLAR_MAX_COUNT, Setting.CATERPILLAR_MAX_SPEED, Setting.CATERPILLAR_MAX_FOOD));
    }
}
