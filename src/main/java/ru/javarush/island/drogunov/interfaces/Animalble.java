package ru.javarush.island.drogunov.interfaces;

import ru.javarush.island.drogunov.enity.animals.Animal;
import ru.javarush.island.drogunov.game_space.GameSpace;

public interface Animalble {
    void eat(Animal one, Animal two);

    void multiply(Animal one, Animal two);

    void walk(GameSpace playSpace);
}
