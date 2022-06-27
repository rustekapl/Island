package ru.javarush.island.khmelov.entity.organizms.animals.herbivores;

import ru.javarush.island.khmelov.entity.organizms.Limit;
import ru.javarush.island.khmelov.entity.organizms.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
