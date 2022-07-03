package ru.javarush.island.khryukin.utils;

import ru.javarush.island.khryukin.entity.organisms.Organism;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EntityFactoryData {
    public EntityFactoryData(){

    }

    public static Organism[] createPrototypes(Class<?>[] TYPES) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            Method getBirth = type.getDeclaredMethod("birth");
            organisms[index++] = (Organism) getBirth.invoke(type);
        }

        return organisms;
    }
}
