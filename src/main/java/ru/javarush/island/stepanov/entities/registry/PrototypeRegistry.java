package ru.javarush.island.stepanov.entities.registry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.exceptions.IslandAppException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class PrototypeRegistry {

    private static volatile PrototypeRegistry instance;

    @Getter
    @Setter
    private final Map<String, Creature> prototypesRegistry = new HashMap<>();

    private PrototypeRegistry(){
    }

    public static PrototypeRegistry getInstance(){
        PrototypeRegistry result = instance;
        if (instance != null){
            return result;
        }
        synchronized (PrototypeRegistry.class){
            if (instance == null){
                instance = new PrototypeRegistry();
            }
            return instance;
        }
    }

    @SuppressWarnings("unchecked")
    public void createPrototype(String className){
        try {
            Class<? extends Creature> clazz = (Class<? extends Creature>) Class.forName(className);
            Constructor<? extends Creature> constructor = clazz.getDeclaredConstructor();
            prototypesRegistry.put(clazz.getSimpleName(), getInstanceByConstructor(constructor));
        } catch (NoSuchMethodException e){
            throw new IslandAppException("Class '" + className + "' was not found. Ignore.");
        } catch (ClassNotFoundException e) {
            throw new IslandAppException("No such class was found in project " + className + ". Please, fix the settings file.");
        }
    }

    private <T extends Creature> T getInstanceByConstructor(Constructor<T> constructor){
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IslandAppException("The following error happened while creating class prototypes: " + e.getMessage());
        }
    }

    public Set<String> getPrototypedClasses(){
        Set<String> prototypedClasses = this.prototypesRegistry.keySet();

        if (prototypedClasses.size() != 0){
            return prototypedClasses;
        } else {
            throw new IslandAppException("Prototype registry has no registered prototypes. Please init any beforehand.");
        }
    }

    public List<Creature> getAllPrototypes(){
        return this.prototypesRegistry.values().stream().toList();
    }
}