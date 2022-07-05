package ru.javarush.island.drogunov;

import ru.javarush.island.drogunov.enity.game_unit.animals.Animal;
import ru.javarush.island.drogunov.enity.game_unit.animals.herbivores.*;
import ru.javarush.island.drogunov.enity.game_unit.animals.predators.*;
import ru.javarush.island.drogunov.enity.game_unit.plants.type_plants.SimplePlant;

import java.util.*;

public class Constants {
    //Should go to the settings file
    public static final Map<Class<?>, String> GAME_UNITS = new HashMap<>();

    static {
        //TODO Coding. Hard code. Not flexible
        GAME_UNITS.put(Wolf.class, "10 Horse 15 Deer 60 Rabbit 80 Mouse 60 Goat 70 Sheep 15 Board 10 Buffalo 40 Duck");
        GAME_UNITS.put(Boa.class, "15 Fox 20 Rabbit 40 Mouse 10 Duck");
        GAME_UNITS.put(Fox.class, "70 Rabbit 90 Mouse 60 Duck 40 Caterpillar");
        GAME_UNITS.put(Bear.class, "80 Boa 40 Horse 80 Deer 80 Rabbit 90 Mouse 70 Goat 70 Sheep 50 Board 20 Buffalo 10 Duck");
        GAME_UNITS.put(Eagle.class, "10 Fox 90 Rabbit 90 Mouse 80 Duck");
        GAME_UNITS.put(Horse.class, "100 SimplePlant");
        GAME_UNITS.put(Deer.class, "100 SimplePlant");
        GAME_UNITS.put(Rabbit.class, "100 SimplePlant");
        GAME_UNITS.put(Mouse.class, "90 Caterpillar 100 SimplePlant");
        GAME_UNITS.put(Goat.class, "100 SimplePlant");
        GAME_UNITS.put(Sheep.class, "100 SimplePlant");
        GAME_UNITS.put(Boar.class, "50 Mouse 90 Caterpillar 100 SimplePlant");
        GAME_UNITS.put(Buffalo.class, "100 SimplePlant");
        GAME_UNITS.put(Duck.class, "90 Caterpillar 100 SimplePlant");
        GAME_UNITS.put(Caterpillar.class, "100 SimplePlant");
        GAME_UNITS.put(SimplePlant.class, "");
    }

    //Map storing 1) All unit classes for create island.
    //                  2) Value map (Target class, Eating probabilities)
    public static final Map<Class<?>, Map<Class<?>, Integer>> PROBABILITY_EATING = new HashMap<>();

    static {
        GAME_UNITS.keySet().stream().filter(Animal.class::isAssignableFrom).forEach(unitEatable -> PROBABILITY_EATING.put(unitEatable, getTargets(unitEatable)));
    }

    private static Map<Class<?>, Integer> getTargets(Class<?> unitEater) {
        Map<Class<?>, Integer> result = new TreeMap<>(Comparator.comparing(Class::getSimpleName));

        String targetUnitsAndProbability = GAME_UNITS.get(unitEater);
        Scanner read = new Scanner(targetUnitsAndProbability);

        while (read.hasNext()) {
            Integer probability = Integer.valueOf(read.next());
            String unitTarget = read.next();
            for (Class<?> classUnitTarget : GAME_UNITS.keySet()) {
                String simpleName = classUnitTarget.getSimpleName();
                if (simpleName.equals(unitTarget)) {
                    result.put(classUnitTarget, probability);
                }
            }
        }
        return result;
    }
}
