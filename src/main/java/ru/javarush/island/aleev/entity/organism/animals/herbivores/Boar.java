package ru.javarush.island.aleev.entity.organism.animals.herbivores;


import ru.javarush.island.aleev.entity.map.Cell;
import ru.javarush.island.aleev.parameters.Parameters;


public class Boar extends Herbivore {
    public Boar(Parameters parameters) {
        super(parameters);
    }


    public void eat(Cell currentCell) {
//    currentCell.residents.forEach((key, value) -> System.out.print(key + "=" + value.size() + " "))

    }


    @Override
    public void move() {
        super.move();
    }

    @Override
    public void eat() {

    }


    @Override
    public void reproduct() {
        super.reproduct();
    }


}
