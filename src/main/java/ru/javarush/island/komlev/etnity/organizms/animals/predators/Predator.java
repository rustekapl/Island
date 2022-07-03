package ru.javarush.island.komlev.etnity.organizms.animals.predators;

import ru.javarush.island.komlev.etnity.organizms.Limit;
import ru.javarush.island.komlev.etnity.organizms.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
