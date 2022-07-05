package ru.javarush.island.ryabov.abstraction;

import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.exception.GameException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class EntityScanner {
    private EntityScanner() {
    }

    public static Organism[] createPrototypes(List<Class<?>> TYPES) {
        Organism[] organisms = new Organism[TYPES.size()];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(TypeData.class)) {
                TypeData typeData = type.getAnnotation(TypeData.class);
                String name = typeData.name();
                String icon = typeData.icon();
                Limit limit = new Limit(
                        typeData.maxWeight(),
                        typeData.maxCountInCell(),
                        typeData.maxSpeed(),
                        typeData.maxFood(),
                        typeData.icon(),
                        typeData.name()
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
            throw new GameException("not found Entity constructor", e);
        }
    }
}