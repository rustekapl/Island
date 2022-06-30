package ru.javarush.ivanov.island.view;

import ru.javarush.ivanov.island.entities.territory.Island;
import ru.javarush.ivanov.island.entities.Creature;
import ru.javarush.ivanov.island.variables.ListOfAnimalsAndHerbs;
import ru.javarush.ivanov.island.variables.island_params.IslandWidthAndHeight;

import java.util.*;

public class Statistic {
    private int day = 1;

    public void giveMeStatistic(Island island) {
        Map<String, Integer> creatures = new HashMap<>();
        creaturesFiller(creatures);
        for (int i = 0; i < IslandWidthAndHeight.getWidth(); i++) {
            for (int j = 0; j < IslandWidthAndHeight.getHeight(); j++) {
                Map<String, Set<Creature>> creaturesPerSquare = island.getIslandTerritory()[i][j].getResidents();
                for (String type : ListOfAnimalsAndHerbs.getCurrencies()) {
                    Set<Creature> tempSet = creaturesPerSquare.get(type);
                    creatures.compute(type, (k, v) -> v = v + tempSet.size());

                }
            }
        }
        System.out.println("Day: " + day);
        creatures.forEach((k, v) -> System.out.println(k + " : " + v));
        day++;
    }

    private void creaturesFiller(Map<String, Integer> creatures) {
        for (String type : ListOfAnimalsAndHerbs.getCurrencies()) {
            creatures.put(type, 0);
        }
    }
}

