package ru.javarush.island.ivanov.services.move_services;

import org.jetbrains.annotations.NotNull;
import ru.javarush.island.ivanov.entities.Creature;

import java.util.Set;

public class CheckForMaxNumberAtSquare {

    public static boolean checkForEnoughSpace(@NotNull Creature creature) {
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
