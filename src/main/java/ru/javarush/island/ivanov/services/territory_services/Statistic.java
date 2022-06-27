package ru.javarush.island.ivanov.services.territory_services;

import ru.javarush.island.ivanov.entities.Creature;
import ru.javarush.island.ivanov.entities.territory.Island;
import ru.javarush.island.ivanov.variables.ListOfAnimalsAndHerbs;
import ru.javarush.island.ivanov.variables.island_params.IslandWidthAndHeight;

import java.util.HashMap;
import java.util.Set;

public class Statistic {

    public void giveMeStatistic(Island island) {
        for (int i = 0; i < IslandWidthAndHeight.getWidth(); i++) {
            for (int j = 0; j < IslandWidthAndHeight.getHeight(); j++) {
                HashMap<String, Set<Creature>> creaturesPerSquare = new HashMap<>(island.getIslandTerritory()[i][j].getResidents());
                System.out.println("WildLife at square " + i + " " + j);
                for (String type : ListOfAnimalsAndHerbs.getCurrencies()) {
                    Set<Creature> tempSet = creaturesPerSquare.get(type);
                    System.out.println(type + " : " + tempSet.size());
                }
            }
        }
    }
}

