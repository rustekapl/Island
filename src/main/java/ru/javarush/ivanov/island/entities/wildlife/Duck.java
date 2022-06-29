package ru.javarush.ivanov.island.entities.wildlife;

import ru.javarush.ivanov.island.entities.interfaces.WildLife;
import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.variables.animal_params.AnimalParams;

public class Duck extends Herbivorous {
    private final AnimalParams duckParams = new AnimalParams();
    private Square squareInfo;

    public Duck() {
        duckParams.setWeight(1);
        duckParams.setMaxNumberPerSquare(200);
        duckParams.setSpeed(4);
        duckParams.setAmountOfFoodForSatiety(0.15);
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
        return duckParams;
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
