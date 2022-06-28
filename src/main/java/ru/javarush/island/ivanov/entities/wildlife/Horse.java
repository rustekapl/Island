package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Horse extends Herbivorous {
    private AnimalParams horseParams = new AnimalParams();
    private Square squareInfo;

    public Horse() {
        horseParams.setWeight(400);
        horseParams.setMaxNumberPerSquare(20);
        horseParams.setSpeed(4);
        horseParams.setAmountOfFoodForSatiety(60);
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

    public void setHorseParams(AnimalParams horseParams) {
        this.horseParams = horseParams;
    }

    @Override
    public AnimalParams getParams() {
        return horseParams;
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
