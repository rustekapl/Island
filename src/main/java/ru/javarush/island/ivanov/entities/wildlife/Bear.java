package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Bear extends Predator {
    private final AnimalParams bearParams = new AnimalParams();
    private Square squareInfo;

    public Bear() {
        bearParams.setWeight(500);
        bearParams.setMaxNumberPerSquare(5);
        bearParams.setSpeed(2);
        bearParams.setAmountOfFoodForSatiety(80);
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
        return bearParams;
    }

    public Square getSquareInfo() {
        return squareInfo;
    }

    public void setSquareInfo(Square squareInfo) {
        this.squareInfo = squareInfo;
    }
}
