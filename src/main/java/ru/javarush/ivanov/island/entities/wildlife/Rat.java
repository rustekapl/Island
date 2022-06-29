package ru.javarush.ivanov.island.entities.wildlife;

import ru.javarush.ivanov.island.entities.interfaces.WildLife;
import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.variables.animal_params.AnimalParams;

public class Rat extends Herbivorous {
    private final AnimalParams ratParams = new AnimalParams();
    private Square squareInfo;

    public Rat() {
        ratParams.setWeight(0.05);
        ratParams.setMaxNumberPerSquare(500);
        ratParams.setSpeed(1);
        ratParams.setAmountOfFoodForSatiety(0.01);
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
        return ratParams;
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
