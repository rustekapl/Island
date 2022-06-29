package ru.javarush.ivanov.island.variables;


import ru.javarush.ivanov.island.entities.Creature;
import ru.javarush.ivanov.island.entities.interfaces.WildLife;
import ru.javarush.ivanov.island.entities.wildlife.*;

public class AnimalAndHerbsFactory {
    public static Creature createWildLife(ListOfAnimalsAndHerbs listOfAnimalsAndHerbs) {
        return switch (listOfAnimalsAndHerbs) {
            case BEAR -> new Bear();
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case FOX -> new Fox();
            case GOAT -> new Goat();
            case HAWK -> new Hawk();
            case HERBS -> new Herbs();
            case HORSE -> new Horse();
            case RABBIT -> new Rabbit();
            case RAT -> new Rat();
            case SHEEP -> new Sheep();
            case SNAKE -> new Snake();
            case WOLF -> new Wolf();
        };
    }

    private AnimalAndHerbsFactory() {
    }
}
