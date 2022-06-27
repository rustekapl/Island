package ru.javarush.island.ivanov.services.move_services;

import org.jetbrains.annotations.NotNull;
import ru.javarush.island.ivanov.entities.Creature;

import java.util.HashSet;
import java.util.Set;

public class CheckForMaxNumberAtSquare {

    public static boolean check(@NotNull Creature creature) {
        int maxNumberAtSquare = creature.getParams().getMaxNumberPerSquare();
        String type = creature.getType();
        //TODO Code style. Need reformat or extraction to methods | variables | constants
        Set<Creature> amountOfCreatures = new HashSet<>(creature.getSquareInfo().getResidents().get(type));
        int counter = amountOfCreatures.size();
        return maxNumberAtSquare > counter;
    }


}
