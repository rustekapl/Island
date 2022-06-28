package ru.javarush.island.drogunov.util;

import lombok.SneakyThrows;
import ru.javarush.island.drogunov.enity.annotations.Initialize;
import ru.javarush.island.drogunov.exceptions.ClassForDependenceNotFound;
import ru.javarush.island.drogunov.game_space.GameSettings;
import ru.javarush.island.drogunov.game_space.GameSpace;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Injector {

    private static Map<Class<?>, Class<?>> beans = new HashMap<>();

    //TODO ---  maybe need another class?
    static {
        beans.put(InitializerGame.class, InitializerGame.class);
        beans.put(GameSpace.class, GameSpace.class);
        beans.put(GameSettings.class, GameSettings.class);
        beans.put(StartPopulation.class, StartPopulation.class);
    }

    @SneakyThrows
    public static Object injectDependencies(Class<?> clazz) {
        Object newObject = clazz.getConstructor().newInstance();

        for (Field declaredField : newObject.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Initialize.class)) {
                Class<?> type = declaredField.getType();
                Class<?> injectedClass = beans.get(type);
                if (injectedClass == null) {
                    throw new ClassForDependenceNotFound("Field " + declaredField.getName() + " can't be injected");
                }

                Object injectingInstance = injectDependencies(injectedClass);
                declaredField.setAccessible(true);
                declaredField.set(newObject, injectingInstance);
                declaredField.setAccessible(false);
            }
        }
        return newObject;
    }
}
