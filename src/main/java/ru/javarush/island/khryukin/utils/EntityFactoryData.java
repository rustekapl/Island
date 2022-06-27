package ru.javarush.island.khryukin.utils;

import ru.javarush.island.khryukin.entity.animals.organisms.Organism;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EntityFactoryData {
    public EntityFactoryData() {

    }

    //TODO Coding. Here throws checked exception
    public static Organism[] createPrototypes(Class<?>[] TYPES) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            Method getBirth = type.getDeclaredMethod("birth");
            organisms[index++] = (Organism) getBirth.invoke(type);
        }
        /*organisms[0] = Horse.birth();
        organisms[1] = Wolf.birth();
        organisms[2] = Bear.birth();*/
        //System.out.println(Arrays.toString(organisms));
        return organisms;
    }
}
