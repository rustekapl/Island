package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Mouse extends Animal {
    public Mouse(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Mouse(Setting.MOUSE_NAME, Setting.MOUSE_ICON, Setting.MOUSE_MAX_WEIGHT, new Limit(Setting.MOUSE_MAX_WEIGHT, Setting.MOUSE_MAX_COUNT, Setting.MOUSE_MAX_SPEED, Setting.MOUSE_MAX_FOOD));
    }
}
