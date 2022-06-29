package ru.javarush.ivanov.island.view;

import ru.javarush.ivanov.island.entities.territory.Island;
import ru.javarush.ivanov.island.entities.Creature;
import ru.javarush.ivanov.island.variables.ListOfAnimalsAndHerbs;
import ru.javarush.ivanov.island.variables.island_params.IslandWidthAndHeight;

import java.util.*;

public class Statistic {

    public void giveMeStatistic(Island island) {
        for (int i = 0; i < IslandWidthAndHeight.getWidth(); i++) {
            for (int j = 0; j < IslandWidthAndHeight.getHeight(); j++) {
                Map<String, Set<Creature>> creaturesPerSquare = island.getIslandTerritory()[i][j].getResidents();
                System.out.println("WildLife at square " + i + " " + j);
                for (String type : ListOfAnimalsAndHerbs.getCurrencies()) {
                    Set<Creature> tempSet = creaturesPerSquare.get(type);
                    System.out.println(type + " : " + tempSet.size());
                }
            }
        }
    }
}

