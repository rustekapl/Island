package ru.javarush.ivanov.island.entities.wildlife;

import ru.javarush.ivanov.island.entities.interfaces.WildLife;
import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.variables.animal_params.AnimalParams;

public class Buffalo extends Herbivorous {
    private final AnimalParams buffaloParams = new AnimalParams();
    private Square squareInfo;

    public Buffalo() {
        buffaloParams.setWeight(700);
        buffaloParams.setMaxNumberPerSquare(10);
        buffaloParams.setSpeed(3);
        buffaloParams.setAmountOfFoodForSatiety(100);
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
        return buffaloParams;
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
