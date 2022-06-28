package ru.javarush.island.drogunov.enity.animals.herbivors;

import ru.javarush.island.drogunov.enity.animals.Animal;
import ru.javarush.island.drogunov.enity.annotations.Populations;
import ru.javarush.island.drogunov.interfaces.Herbivorous;

@Populations(max = 20)
public class Horse extends Animal implements Herbivorous {

    public Horse(int x, int y) {
        super(x, y);
    }
}

