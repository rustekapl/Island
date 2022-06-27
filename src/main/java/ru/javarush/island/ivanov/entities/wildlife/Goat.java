package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Goat extends Herbivorous {
    private AnimalParams goatParams = new AnimalParams();
    private Square squareInfo;

    public Goat() {
        goatParams.setWeight(60);
        goatParams.setMaxNumberPerSquare(140);
        goatParams.setSpeed(3);
        goatParams.setAmountOfFoodForSatiety(10);
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

    public void setGoatParams(AnimalParams goatParams) {
        this.goatParams = goatParams;
    }

    @Override
    public AnimalParams getParams() {
        return goatParams;
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
