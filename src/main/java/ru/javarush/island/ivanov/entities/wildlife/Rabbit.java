package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Rabbit extends Herbivorous {
    private AnimalParams rabbitParams = new AnimalParams();
    private Square squareInfo;

    public Rabbit() {
        rabbitParams.setWeight(2);
        rabbitParams.setMaxNumberPerSquare(150);
        rabbitParams.setSpeed(2);
        rabbitParams.setAmountOfFoodForSatiety(0.45);
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

    public void setRabbitParams(AnimalParams rabbitParams) {
        this.rabbitParams = rabbitParams;
    }

    @Override
    public AnimalParams getParams() {
        return rabbitParams;
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
