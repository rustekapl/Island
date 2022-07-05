package ru.javarush.island.stepanov.utils;

import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.location.LocationCell;
import ru.javarush.island.stepanov.entities.registry.PrototypeRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatisticsCollector {

    private StatisticsCollector(){}
    private static Integer dayCount = 0;

    public static String returnGeneralizedStatistics(Location location){
        Map<String, Integer> statisticsMap = new HashMap<>();
        PrototypeRegistry prototypeRegistry = PrototypeRegistry.getInstance();
        for(String className : prototypeRegistry.getPrototypedClasses()){
            statisticsMap.put(className, 0);
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Day Count "+dayCount+".\n");
        LocationCell[][] locationMatrix = location.getLocationMatrix();
        for (LocationCell cell: location.getCellsPool()) {
            LocationCell locationCell = locationMatrix[cell.getCoordinate().getWidth()][cell.getCoordinate().getHeight()];
            Map<String, Set<Creature>> cellInhabitants = locationCell.getCellInhabitants();
            for (Map.Entry<String, Set<Creature>> entry: cellInhabitants.entrySet()) {
                statisticsMap.put(entry.getKey(), statisticsMap.get(entry.getKey())+entry.getValue().size());
            }
        }
        stringBuilder.append(statisticsMap.toString());
        dayCount++;
        return stringBuilder.toString();
    }

}
