package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.etnity.organizms.Limit;
import ru.javarush.island.komlev.etnity.organizms.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}

