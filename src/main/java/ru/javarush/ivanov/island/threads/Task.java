package ru.javarush.ivanov.island.threads;

import ru.javarush.ivanov.island.entities.Creature;
import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.entities.wildlife.Animal;

import java.util.function.Consumer;

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
