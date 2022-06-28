package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Boar extends Herbivorous {
    private AnimalParams boarParams = new AnimalParams();
    private Square squareInfo;

    public Boar() {
        boarParams.setWeight(400);
        boarParams.setMaxNumberPerSquare(50);
        boarParams.setSpeed(2);
        boarParams.setAmountOfFoodForSatiety(50);
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

    public void setBoarParams(AnimalParams boarParams) {
        this.boarParams = boarParams;
    }

    @Override
    public AnimalParams getParams() {
        return boarParams;
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
