package ru.javarush.island.kolontsov.entities;

import ru.javarush.island.kolontsov.gamefield.Cell;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    private final String name;
    private final String icon;
    private final double maxWeight;
    private final double weight;
    private final int maxCount;
    private final int speed;
    private final int maxFood;

    public Animal(String name, String icon, double maxWeight, double startWeight, int maxCount, int speed, int maxFood) {
        this.name = name;
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.weight = ThreadLocalRandom.current().nextDouble(maxWeight/2, maxWeight);
        this.maxCount = maxCount;
        this.speed = speed;
        this.maxFood = maxFood;
    }

    //не понимаю реализацию метода, и start должен быть ячейкой в массиве и как в какую-то сторону прибавить
    //int steps - вопрос
    public void move(Cell cell) {

        int steps = ThreadLocalRandom.current().nextInt(0, speed);
        //вот есть допустим enum Direction - не понятно, могу ли я как-то рандомно тоже выбрать направление из того списка?

        //startCell - не понимаю как взять рандомную стартовую ячейку, в которой рождается животное и запихать его туда
        //наверное я не совсем верно написал, потому что при каждом ходе у нее будет стартовая ячейка меняться..
        //startCell наверное лучше вынести в класс до метода move?
        Cell[][] startCell = new Cell[ThreadLocalRandom.current().nextInt(0,100)][ThreadLocalRandom.current().nextInt(0,20)];
        //finishCell = startCell.randomDirection + steps;
        //тут должна быть проверка еще видимо, если Direction выпал такой-то, то
        //Cell[][] finishCell = startCell + steps (в направлении которое попалось)

        //также должна быть наверное какая-то проверка, что если в finishCell этого вида животных больше maxCount,
        //то вернутсья в цикл и выбрать другое направление

        //startCell = finishCell - как-то надо переписать стартовую, чтобы от нее отсчет начинался со 2-ого хода
        //return finishCell;
    }

    public void eat() {
        if (weight < maxWeight) {

        }
    }

    public void multiply() {

    }
}
