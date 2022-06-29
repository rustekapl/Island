package ru.javarush.ivanov.island.services.move_services;

import org.jetbrains.annotations.NotNull;
import ru.javarush.ivanov.island.entities.Creature;

import java.util.HashSet;
import java.util.Set;

public class CheckForMaxNumberAtSquare {

    public static boolean check(@NotNull Creature creature) {
        int maxNumberAtSquare = creature
                .getParams()
                .getMaxNumberPerSquare();
        String type = creature.getType();
        Set<Creature> amountOfCreatures = creature
                .getSquareInfo()
                .getResidents()
                .get(type);
        int counter = amountOfCreatures.size();
        return maxNumberAtSquare > counter;
    }


}
