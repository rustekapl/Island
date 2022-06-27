package ru.javarush.island.drogunov.enity.animals.herbivors;

import ru.javarush.island.drogunov.enity.animals.Animal;
import ru.javarush.island.drogunov.enity.annotations.Populations;
import ru.javarush.island.drogunov.interfaces.Herbivorous;

@Populations(max = 500)
public class Mouse extends Animal implements Herbivorous {

    public Mouse(int x, int y) {
        super(x, y);
    }
}
