package ru.javarush.island.zazimko.classes.util;

import ru.javarush.island.zazimko.classes.animals.Organism;
import ru.javarush.island.zazimko.exceptions.IslandConfigException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static ru.javarush.island.zazimko.modificators.Config.INITIAL_VALUE;
import static ru.javarush.island.zazimko.modificators.Config.TYPES;

public class Factory {
    private final Class<?>[] types;


    public Factory() {
        this.types = TYPES;

    }

    public ConcurrentHashMap<Type, Set<Organism>> createAnimals() {

        ConcurrentHashMap<Type, Set<Organism>> organisms = new ConcurrentHashMap<>();
        for (Class<?> type : types) {
            int quantity = Randoms.getRnd(0, INITIAL_VALUE);
            try {
                Set<Organism> animals = new HashSet<>();
                Constructor<?> constructor = type.getConstructor();
                for (int i = 0; i < quantity; i++) {
                    Organism organism = (Organism) constructor.newInstance();
                    animals.add(organism);
                }
                organisms.put(type, animals);

            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | RuntimeException e) {
                throw new IslandConfigException("NO found constructor!!!");
            }
        }
        return organisms;
    }

}
