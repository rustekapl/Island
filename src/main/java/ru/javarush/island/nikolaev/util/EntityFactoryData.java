package ru.javarush.island.nikolaev.util;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;
import ru.javarush.island.nikolaev.entity.organizms.Organism;
import ru.javarush.island.nikolaev.exception.InitGameException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EntityFactoryData {

    private EntityFactoryData() {
    }

    public static Organism[] createPrototypes(Class<?>[] TYPES) {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(Setting.class)) {
                Setting setting = type.getAnnotation(Setting.class);
                String name = setting.name();
                String icon = setting.icon();
                double maxWeight = setting.maxWeight();
                double weight = Randomizer.random(maxWeight / 2, maxWeight);
                int idFromtheSpecTable = setting.idFromTheSpecTable();
                Limit limit = new Limit(
                        setting.maxWeight(),
                        setting.maxCount(),
                        setting.maxSpeed(),
                        setting.maxFood()
                );

                organisms[index++] = generatePrototype(type, name, icon, weight, idFromtheSpecTable, limit);
            }
        }
        return organisms;
    }

    private static Organism generatePrototype(Class<?> type, String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        try {
            Constructor<?> constructor = type.getConstructor(String.class, String.class, double.class, int.class, Limit.class);
            return (Organism) constructor.newInstance(name, icon, weight, idFromTheSpecTable, limit);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new InitGameException("not found Entity constructor", e);
        }
    }
}
