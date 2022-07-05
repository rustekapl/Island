package ru.javarush.island.zazimko.config;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;
import ru.javarush.island.zazimko.entity.organizms.Organism;
import ru.javarush.island.zazimko.exception.IslandConfigException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EntityScanner {

    private EntityScanner() {
    }

    public static Organism[] createPrototypes(Class<?>[] TYPES) {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(TypeData.class)) {
                TypeData typeData = type.getAnnotation(TypeData.class);
                String name = typeData.name();
                String icon = typeData.icon();
                int flockSize = typeData.flockSize();
                Limit limit = new Limit(
                        typeData.maxCountInCell() / flockSize,
                        typeData.maxWeight() * flockSize,
                        typeData.maxSpeed(),
                        typeData.maxFood() * flockSize,
                        flockSize
                );

                organisms[index++] = generatePrototype(type, name, icon, limit);
            }
        }
        return organisms;
    }

    private static Organism generatePrototype(Class<?> type, String name, String icon, Limit limit) {
        try {
            Constructor<?> constructor = type.getConstructor(String.class, String.class, Limit.class);
            return (Organism) constructor.newInstance(name, icon, limit);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new IslandConfigException("not found Entity constructor", e);
        }
    }
}
