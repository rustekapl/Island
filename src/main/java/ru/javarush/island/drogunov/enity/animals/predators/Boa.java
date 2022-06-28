package ru.javarush.island.drogunov.enity.animals.predators;

import ru.javarush.island.drogunov.enity.animals.Animal;
import ru.javarush.island.drogunov.enity.annotations.Populations;
import ru.javarush.island.drogunov.interfaces.Predatory;

@Populations(max = 30)
public class Boa extends Animal implements Predatory {

    public Boa(int x, int y) {
        super(x, y);
    }
}

