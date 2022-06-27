package ru.javarush.island.drogunov.enity.animals.herbivors;

import ru.javarush.island.drogunov.enity.animals.Animal;
import ru.javarush.island.drogunov.enity.annotations.Populations;
import ru.javarush.island.drogunov.interfaces.Herbivorous;

@Populations(max = 50)
public class WildBoard extends Animal implements Herbivorous {

    public WildBoard(int x, int y) {
        super(x, y);
    }
}
