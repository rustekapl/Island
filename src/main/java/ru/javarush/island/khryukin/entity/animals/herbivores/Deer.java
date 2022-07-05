package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Deer extends Animal {
    public Deer(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
    public static Organism birth() {
        return new Deer(Setting.DEER_NAME, Setting.DEER_ICON, Setting.DEER_MAX_WEIGHT, new Limit(Setting.DEER_MAX_WEIGHT, Setting.DEER_MAX_COUNT, Setting.DEER_MAX_SPEED, Setting.DEER_MAX_FOOD));
    }
}
