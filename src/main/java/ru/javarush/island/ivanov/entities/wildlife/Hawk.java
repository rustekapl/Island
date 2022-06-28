package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Hawk extends Predator {
    private AnimalParams hawkParams = new AnimalParams();
    private Square squareInfo;

    public Hawk() {
        hawkParams.setWeight(6);
        hawkParams.setMaxNumberPerSquare(20);
        hawkParams.setSpeed(3);
        hawkParams.setAmountOfFoodForSatiety(1);
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

    public void setHawkParams(AnimalParams hawkParams) {
        this.hawkParams = hawkParams;
    }

    @Override
    public AnimalParams getParams() {
        return hawkParams;
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
