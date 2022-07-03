package ru.javarush.island.aleev.factories;

import ru.javarush.island.aleev.cotstants.OrganismType;
import ru.javarush.island.aleev.entity.organism.Organism;
import ru.javarush.island.aleev.entity.organism.animals.carnivores.*;
import ru.javarush.island.aleev.entity.organism.animals.herbivores.*;
import ru.javarush.island.aleev.entity.organism.plants.Plant;
import ru.javarush.island.aleev.parameters.GameParameters;

import static ru.javarush.island.aleev.cotstants.OrganismType.*;

public class OrganismFactory {
    static OrganismFactory organismFactory;

    private OrganismFactory() {
    }

    public static OrganismFactory getInstance() {
        if (organismFactory == null) {
            organismFactory = new OrganismFactory();
        }
        return organismFactory;
    }

    public Organism getPrototype(OrganismType organismType) {
        return switch (organismType) {
            case BEAR -> new Bear(GameParameters.getInstance().getParameters().get(BEAR));
            case BOA -> new Boa(GameParameters.getInstance().getParameters().get(BOA));
            case EAGLE -> new Eagle(GameParameters.getInstance().getParameters().get(EAGLE));
            case FOX -> new Fox(GameParameters.getInstance().getParameters().get(FOX));
            case WOLF -> new Wolf(GameParameters.getInstance().getParameters().get(WOLF));
            case BOAR -> new Boar(GameParameters.getInstance().getParameters().get(BOAR));
            case BUFFALO -> new Buffalo(GameParameters.getInstance().getParameters().get(BUFFALO));
            case CATERPILLAR -> new Caterpillar(GameParameters.getInstance().getParameters().get(CATERPILLAR));
            case DEER -> new Deer(GameParameters.getInstance().getParameters().get(DEER));
            case DUCK -> new Duck(GameParameters.getInstance().getParameters().get(DUCK));
            case GOAT -> new Goat(GameParameters.getInstance().getParameters().get(GOAT));
            case HORSE -> new Horse(GameParameters.getInstance().getParameters().get(HORSE));
            case MOUSE -> new Mouse(GameParameters.getInstance().getParameters().get(MOUSE));
            case RABBIT -> new Rabbit(GameParameters.getInstance().getParameters().get(RABBIT));
            case SHEEP -> new Sheep(GameParameters.getInstance().getParameters().get(SHEEP));
            case PLANT -> new Plant(GameParameters.getInstance().getParameters().get(PLANT));

        };
    }
}
