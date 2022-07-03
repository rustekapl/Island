package ru.javarush.island.synckevich.entities;

import ru.javarush.island.synckevich.entities.animals.carnivores.*;
import ru.javarush.island.synckevich.entities.animals.herbivores.*;
import ru.javarush.island.synckevich.entities.plants.Plant;
import ru.javarush.island.synckevich.enums.EntityType;

public class EntityFactory {
    private EntityFactory() {
    }

    public static Entity createAnimal(EntityType type) {
        //TODO ---  map?
        return switch (type) {
            case WOLF -> new Wolf();
            case SNAKE -> new Snake();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case DEER -> new Deer();
            case RABBIT -> new Rabbit();
            case MOUSE -> new Mouse();
            case GOAT -> new Goat();
            case SHEEP -> new Sheep();
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case DUCK -> new Duck();
            case CATERPILLAR -> new Caterpillar();
            case PLANT -> new Plant();
        };
    }
}
