package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Rabbit extends Animal {
    public Rabbit(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Rabbit(Setting.RABBIT_NAME, Setting.RABBIT_ICON, Setting.RABBIT_MAX_WEIGHT, new Limit(Setting.RABBIT_MAX_WEIGHT, Setting.RABBIT_MAX_COUNT, Setting.RABBIT_MAX_SPEED, Setting.RABBIT_MAX_FOOD));
    }
}
