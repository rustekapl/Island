package ru.javarush.ivanov.island.entities.wildlife;

import ru.javarush.ivanov.island.entities.territory.Square;

public abstract class Predator extends Animal {

    @Override
    public boolean eat(Square square) {
        return super.eat(square);
    }

    @Override
    public boolean move(Square square) {
        return super.move(square);
    }

    @Override
    public boolean breed(Square square) {
        return super.breed(square);
    }
}
