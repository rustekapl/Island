package ru.javarush.island.drogunov.enity.animals.predators;

import ru.javarush.island.drogunov.enity.animals.Animal;
import ru.javarush.island.drogunov.enity.annotations.Populations;
import ru.javarush.island.drogunov.interfaces.Predatory;

@Populations(max = 30)
public class Fox extends Animal implements Predatory {

    public Fox(int x, int y) {
        super(x, y);
    }
}

