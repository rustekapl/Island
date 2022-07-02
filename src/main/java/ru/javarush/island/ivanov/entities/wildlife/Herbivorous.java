package ru.javarush.island.ivanov.entities.wildlife;


import ru.javarush.island.ivanov.entities.territory.Square;

public abstract class Herbivorous extends Animal {
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
