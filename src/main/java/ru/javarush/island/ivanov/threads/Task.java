package ru.javarush.island.ivanov.threads;

import ru.javarush.island.ivanov.entities.Creature;
import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.entities.wildlife.Animal;

public class Task {

    private final Creature creature;

    private final Square square;

    public Task(Creature creature, Square square) {
        this.creature = creature;
        this.square = square;
    }

    public void begin() {
        creature.breed(square);
        if (creature instanceof Animal animal) {
            animal.eat(square);
            animal.move(square);
        }
    }
}
