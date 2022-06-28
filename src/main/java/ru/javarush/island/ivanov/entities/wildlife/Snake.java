package ru.javarush.island.ivanov.entities.wildlife;

import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

public class Snake extends Predator {
    private AnimalParams snakeParams = new AnimalParams();
    private Square squareInfo;

    public Snake() {
        snakeParams.setWeight(15);
        snakeParams.setMaxNumberPerSquare(30);
        snakeParams.setSpeed(1);
        snakeParams.setAmountOfFoodForSatiety(3);
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

    public void setSnakeParams(AnimalParams snakeParams) {
        this.snakeParams = snakeParams;
    }

    @Override
    public AnimalParams getParams() {
        return snakeParams;
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
