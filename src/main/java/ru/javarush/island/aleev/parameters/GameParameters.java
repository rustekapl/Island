package ru.javarush.island.aleev.parameters;

import ru.javarush.island.aleev.cotstants.Constants;
import ru.javarush.island.aleev.cotstants.OrganismType;

import java.util.HashMap;
import java.util.Map;


public class GameParameters {



    private final Map<OrganismType,Parameters> parameters=new HashMap<>();
    private final int[][] chanceToEat = new int[OrganismType.values().length][OrganismType.values().length];


    private static final GameParameters instance = new GameParameters();


    private GameParameters() {
        initParameters();
    }


    private void initParameters() {
        //TODO Coding. Hard code. Not flexible
        parameters.put(OrganismType.BEAR, new Parameters(Constants.BEAR_ICON, Constants.MAX_COUNT_BEAR, Constants.MAX_SPEED_BEAR));
        parameters.put(OrganismType.BOA, new Parameters(Constants.BOA_ICON, Constants.MAX_COUNT_BOA, Constants.MAX_SPEED_BOA));
        parameters.put(OrganismType.EAGLE, new Parameters(Constants.EAGLE_ICON, Constants.MAX_COUNT_EAGLE, Constants.MAX_SPEED_EAGLE));
        parameters.put(OrganismType.FOX, new Parameters(Constants.FOX_ICON, Constants.MAX_COUNT_FOX, Constants.MAX_SPEED_FOX));
        parameters.put(OrganismType.WOLF, new Parameters(Constants.WOLF_ICON, Constants.MAX_COUNT_WOLF, Constants.MAX_SPEED_WOLF));
        parameters.put(OrganismType.BOAR, new Parameters(Constants.BOAR_ICON, Constants.MAX_COUNT_BOAR, Constants.MAX_SPEED_BOAR));
        parameters.put(OrganismType.BUFFALO, new Parameters(Constants.BUFFALO_ICON, Constants.MAX_COUNT_BUFFALO, Constants.MAX_SPEED_BUFFALO));
        parameters.put(OrganismType.CATERPILLAR, new Parameters(Constants.CATERPILLAR_ICON, Constants.MAX_COUNT_CATERPILLAR, Constants.MAX_SPEED_CATERPILLAR));
        parameters.put(OrganismType.DEER, new Parameters(Constants.DEER_ICON, Constants.MAX_COUNT_DEER, Constants.MAX_SPEED_DEER));
        parameters.put(OrganismType.DUCK, new Parameters(Constants.DUCK_ICON, Constants.MAX_COUNT_DUCK, Constants.MAX_SPEED_DUCK));
        parameters.put(OrganismType.GOAT, new Parameters(Constants.GOAT_ICON, Constants.MAX_COUNT_GOAT, Constants.MAX_SPEED_GOAT));
        parameters.put(OrganismType.HORSE, new Parameters(Constants.HORSE_ICON, Constants.MAX_COUNT_HORSE, Constants.MAX_SPEED_HORSE));
        parameters.put(OrganismType.MOUSE, new Parameters(Constants.MOUSE_ICON, Constants.MAX_COUNT_MOUSE, Constants.MAX_SPEED_MOUSE));
        parameters.put(OrganismType.RABBIT, new Parameters(Constants.RABBIT_ICON, Constants.MAX_COUNT_RABBIT, Constants.MAX_SPEED_RABBIT));
        parameters.put(OrganismType.SHEEP, new Parameters(Constants.SHEEP_ICON, Constants.MAX_COUNT_SHEEP, Constants.MAX_SPEED_SHEEP));
        parameters.put(OrganismType.PLANT, new Parameters(Constants.PLANT_ICON, Constants.MAX_COUNT_PLANT, Constants.MAX_SPEED_PLANT));


        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.HORSE.ordinal()] = 10;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.DEER.ordinal()] = 15;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.RABBIT.ordinal()] = 60;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.MOUSE.ordinal()] = 80;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.GOAT.ordinal()] = 60;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.SHEEP.ordinal()] = 70;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.BOAR.ordinal()] = 15;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.BUFFALO.ordinal()] = 10;
        chanceToEat[OrganismType.WOLF.ordinal()][OrganismType.DUCK.ordinal()] = 40;

        chanceToEat[OrganismType.BOA.ordinal()][OrganismType.FOX.ordinal()] = 15;
        chanceToEat[OrganismType.BOA.ordinal()][OrganismType.RABBIT.ordinal()] = 20;
        chanceToEat[OrganismType.BOA.ordinal()][OrganismType.MOUSE.ordinal()] = 40;
        chanceToEat[OrganismType.BOA.ordinal()][OrganismType.DUCK.ordinal()] = 10;

        chanceToEat[OrganismType.FOX.ordinal()][OrganismType.RABBIT.ordinal()] = 70;
        chanceToEat[OrganismType.FOX.ordinal()][OrganismType.MOUSE.ordinal()] = 90;
        chanceToEat[OrganismType.FOX.ordinal()][OrganismType.DUCK.ordinal()] = 40;
        chanceToEat[OrganismType.FOX.ordinal()][OrganismType.CATERPILLAR.ordinal()] = 40;

        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.BOA.ordinal()] = 80;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.HORSE.ordinal()] = 40;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.DEER.ordinal()] = 80;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.RABBIT.ordinal()] = 80;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.MOUSE.ordinal()] = 90;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.GOAT.ordinal()] = 70;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.SHEEP.ordinal()] = 70;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.BOAR.ordinal()] = 50;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.BUFFALO.ordinal()] = 20;
        chanceToEat[OrganismType.BEAR.ordinal()][OrganismType.DUCK.ordinal()] = 10;

        chanceToEat[OrganismType.EAGLE.ordinal()][OrganismType.FOX.ordinal()] = 10;
        chanceToEat[OrganismType.EAGLE.ordinal()][OrganismType.RABBIT.ordinal()] = 90;
        chanceToEat[OrganismType.EAGLE.ordinal()][OrganismType.MOUSE.ordinal()] = 90;
        chanceToEat[OrganismType.EAGLE.ordinal()][OrganismType.DUCK.ordinal()] = 80;

        chanceToEat[OrganismType.HORSE.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.DEER.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.RABBIT.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.MOUSE.ordinal()][OrganismType.CATERPILLAR.ordinal()] = 90;
        chanceToEat[OrganismType.MOUSE.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.GOAT.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.SHEEP.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.BOAR.ordinal()][OrganismType.MOUSE.ordinal()] = 50;
        chanceToEat[OrganismType.BOAR.ordinal()][OrganismType.CATERPILLAR.ordinal()] = 90;
        chanceToEat[OrganismType.BOAR.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.BUFFALO.ordinal()][OrganismType.PLANT.ordinal()] = 100;

        chanceToEat[OrganismType.DUCK.ordinal()][OrganismType.PLANT.ordinal()] = 100;
        chanceToEat[OrganismType.DUCK.ordinal()][OrganismType.CATERPILLAR.ordinal()] = 90;

        chanceToEat[OrganismType.CATERPILLAR.ordinal()][OrganismType.PLANT.ordinal()] = 100;

    }


    public static GameParameters getInstance() {
        return instance;
    }



    public Map<OrganismType, Parameters> getParameters() {
        return instance.parameters;
    }

    public int[][] getChanceToEat() {
        return chanceToEat;
    }
}
