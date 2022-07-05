package ru.javarush.island.stepanov.utils;

import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.entities.location.Coord;
import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.location.LocationCell;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RandomSpawner {

    private RandomSpawner() {
    }

    public static void spawnByRandomCoordinates(Creature prototype, int countCopies, Location islandField){
        Map<Coord, Set<Creature>> clonedCreatures = clonePrototypesByRandomCoordinates(prototype, countCopies, islandField);
        addToLocation(clonedCreatures, islandField.getLocationMatrix());
    }

    private static void addToLocation(Map<Coord, Set<Creature>> clonedCreatures, LocationCell[][] locationMatrix){
        for (Map.Entry<Coord, Set<Creature>> entry: clonedCreatures.entrySet()) {
            LocationCell locationCell = locationMatrix[entry.getKey().getWidth()][entry.getKey().getHeight()];
            for (Creature creature: entry.getValue()) {
                creature.spawn(locationCell);
            }
        }
    }

    private static Map<Coord, Set<Creature>> clonePrototypesByRandomCoordinates(Creature prototype, int countCopies, Location islandField){
        Map<Coord, Set<Creature>> resultMap = new HashMap<>();
        for (int i = 0; i < countCopies; i++) {
            Coord randomCoordinate = islandField.getRandomCoordinate();
            Set<Creature> creatureInstances = new HashSet<>();
            if (resultMap.get(randomCoordinate) == null){
                creatureInstances.add(prototype.clone());
                resultMap.put(randomCoordinate, creatureInstances);
            } else {
                Set<Creature> creatureSet = resultMap.get(randomCoordinate);
                creatureSet.add(prototype.clone());
                resultMap.put(randomCoordinate, creatureSet);
            }
        }
        return resultMap;
    }
}
