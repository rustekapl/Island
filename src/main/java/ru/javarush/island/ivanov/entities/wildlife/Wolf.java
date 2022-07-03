package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Wolf extends Predator {
    private final AnimalParams wolfParams = new AnimalParams();
    private Square squareInfo;

    public Wolf() {
        wolfParams.setWeight(50);
        wolfParams.setMaxNumberPerSquare(30);
        wolfParams.setSpeed(3);
        wolfParams.setAmountOfFoodForSatiety(8);
    }

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

    @Override
    public AnimalParams getParams() {
        return wolfParams;
    }

    @Override
    public Square getSquareInfo() {
        return squareInfo;
    }

    @Override
    public void setSquareInfo(Square squareInfo) {
        this.squareInfo = squareInfo;
    }
}
