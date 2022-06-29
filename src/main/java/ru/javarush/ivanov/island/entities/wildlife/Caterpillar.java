package ru.javarush.ivanov.island.entities.wildlife;

import ru.javarush.ivanov.island.entities.interfaces.WildLife;
import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.variables.animal_params.AnimalParams;

public class Caterpillar extends Herbivorous {
    private final AnimalParams caterpillarParams = new AnimalParams();
    private Square squareInfo;

    public Caterpillar() {
        caterpillarParams.setWeight(0.01);
        caterpillarParams.setMaxNumberPerSquare(1000);
        caterpillarParams.setSpeed(0);
        caterpillarParams.setAmountOfFoodForSatiety(0);
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
        return caterpillarParams;
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
