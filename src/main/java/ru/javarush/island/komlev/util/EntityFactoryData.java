package ru.javarush.island.komlev.util;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;
import ru.javarush.island.komlev.etnity.organizms.Organism;
import ru.javarush.island.komlev.exception.MyException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EntityFactoryData {
    //класс для создания прототипов животных


    private EntityFactoryData() {
    }

    public static Organism[] createGerms(Class<?>[] TYPES) {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(TypeData.class)) {
                TypeData data = type.getAnnotation(TypeData.class);
                String name = data.name();
                String icon = data.icon();
                double maxWeight = data.maxWeight();
                double weight = Randomizer.random(maxWeight / 2, maxWeight);
                Limit limit = new Limit(
                        data.maxWeight(),
                        data.maxCount(),
                        data.maxSpeed(),
                        data.maxFood()
                );
                organisms[index++] = generateGerms(type, name, icon, weight, limit);
            }
        }
        return organisms;
    }

    private static Organism generateGerms(Class<?> type, String name, String icon, double weight, Limit limit) {
        try {
            Constructor<?> constructor = type.getConstructor(String.class, String.class, double.class, Limit.class);
            return (Organism) constructor.newInstance(name, icon, weight, limit);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new MyException("not found constructor", e);
        }

    }
}


