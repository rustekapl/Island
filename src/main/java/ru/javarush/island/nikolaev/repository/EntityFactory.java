package ru.javarush.island.nikolaev.repository;

import ru.javarush.island.nikolaev.entity.map.Cell;
import ru.javarush.island.nikolaev.entity.organizms.Organism;
import ru.javarush.island.nikolaev.entity.organizms.animals.herbivores.*;
import ru.javarush.island.nikolaev.entity.organizms.animals.predators.Bear;
import ru.javarush.island.nikolaev.entity.organizms.animals.predators.Eagle;
import ru.javarush.island.nikolaev.entity.organizms.animals.predators.Fox;
import ru.javarush.island.nikolaev.entity.organizms.animals.predators.Wolf;
import ru.javarush.island.nikolaev.entity.organizms.plants.Grass;
import ru.javarush.island.nikolaev.util.EntityFactoryData;
import ru.javarush.island.nikolaev.util.Randomizer;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class EntityFactory implements Factory {

    //TODO It is required that TYPES are automatically generated based on classes (not abstract) that are located in
    // entity/organizations/predators/;
    // entity/organizations/plants/
    // entity/organizations/herbivores/

    private static final Class<?>[] TYPES = {Horse.class, Boar.class, Buffalo.class, Deer.class, Duck.class,
            Mouse.class, Rabbit.class, Sheep.class, Wolf.class, Bear.class, Eagle.class, Fox.class, Grass.class};


    private static final Organism[] PROTOTYPES = EntityFactoryData.createPrototypes(TYPES);

    public EntityFactory() {

    }


    @Override
    public Cell createRandomCell() {
        Map<Type, Set<Organism>> residents = new ConcurrentHashMap<>();
        boolean fill = Randomizer.get(50); //TODO need config
        if (fill) {
            for (Organism prototype : PROTOTYPES) {
                Type type = prototype.getClass();
                boolean born = Randomizer.get(50); //TODO need config
                if (born) {
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<Organism> organisms = residents.get(prototype.getClass());
                    int currentCount = organisms.size();
                    int max = prototype.getLimit().getMaxCount() - currentCount;
                    int count = Randomizer.random(0, max);
                    for (int i = 0; i < count; i++) {
                        organisms.add(Organism.clone(prototype));
                    }

                }
            }
        }
        return new Cell(residents);
    }


    @Override
    public List<Organism> getAllPrototypes() {
        return Arrays.asList(PROTOTYPES);
    }

    @Override
    public String toString() {
        return "EntityFactory{" +
                "prototypes=" + Arrays.toString(PROTOTYPES) +
                '}';
    }
}
