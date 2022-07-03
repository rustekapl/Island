package ru.javarush.island.bulimov.entity.repository;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.entity.animals.carnivores.*;
import ru.javarush.island.bulimov.entity.animals.herbivores.*;
import ru.javarush.island.bulimov.entity.plants.Plant;

import java.util.HashMap;


public class AnimalsFactory {
    private final static HashMap<Integer, Organism> PROTOTYPES = new HashMap<>() {
    };

    //TODO Coding. Magic values or methods. Bad reading and understanding
    //TODO Coding. here need cycles or streams
    static {
        PROTOTYPES.put(0, new Wolf(50.0, 30, 3, 8, 4.0));
        PROTOTYPES.put(1, new Boa(15, 30, 1, 3, 1.5));
        PROTOTYPES.put(2, new Fox(8, 30, 2, 2, 1.0));
        PROTOTYPES.put(3, new Bear(500, 5, 2, 80, 40.0));
        PROTOTYPES.put(4, new Eagle(6, 20, 3, 1, 0.5));

        PROTOTYPES.put(5, new Horse(400.0, 20, 4, 60, 30.0));
        PROTOTYPES.put(6, new Deer(300, 20, 4, 50, 25.0));
        PROTOTYPES.put(7, new Rabbit(2, 150, 2, 0.45, 0.15));
        PROTOTYPES.put(8, new Mouse(0.05, 500, 1, 0.01,0.005));
        PROTOTYPES.put(9, new Goat(60, 140, 3, 10,5.0));
        PROTOTYPES.put(10, new Sheep(70, 140, 3, 15,7.0));
        PROTOTYPES.put(11, new Boar(400, 50, 2, 50,25.0));
        PROTOTYPES.put(12, new Buffalo(700, 10, 3, 100,50.0));
        PROTOTYPES.put(13, new Duck(1, 200, 4, 0.15,0.5));
        PROTOTYPES.put(14, new Caterpillar(0.01, 1000, 0, 0,0));

        PROTOTYPES.put(15, new Plant(1.0, 200, 0));
    }



    public static HashMap<Integer,Organism> getAnimals() {
        return PROTOTYPES;
    }
}
