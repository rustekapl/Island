package ru.javarush.island.khryukin.factory;

import ru.javarush.island.khryukin.entity.animals.herbivores.*;
import ru.javarush.island.khryukin.entity.animals.predators.*;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.entity.map.Cell;
import ru.javarush.island.khryukin.entity.plants.Plant;
import ru.javarush.island.khryukin.utils.EntityFactoryData;
import ru.javarush.island.khryukin.utils.RandomValue;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class EntityFactory implements Factory{
    private static final Class<?>[] TYPES = {Wolf.class, Horse.class, Bear.class, Plant.class, Fox.class,
            Boa.class, Eagle.class, Deer.class, Rabbit.class, Mouse.class, Goat.class, Sheep.class,
            Boar.class, Buffalo.class, Duck.class, Caterpillar.class};
    private static final Organism[] PROTOTYPES;

    static {
        try {
            PROTOTYPES = EntityFactoryData.createPrototypes(TYPES);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public EntityFactory() {

    }

    @Override
    public Cell createRandomCell() {
        Map<String, Set<Organism>> residents = new HashMap<>();
        boolean fill = RandomValue.get(50);
        if (fill) {
            for (Organism prototype : PROTOTYPES) {
                String type = prototype.getType();
                boolean born = RandomValue.get(50);
                if (born) {
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<Organism> organisms = residents.get(prototype.getType());
                    int currentCount = organisms.size();
                    int max = prototype.getLimit().getMaxCount() - currentCount;
                    int count = RandomValue.random(0, max);
                    for (int i = 0; i < count; i++) {
                        organisms.add(prototype.clone());
                    }
                }
            }
        }
        Cell cell = new Cell(residents);
        cell.setNextCell(new ArrayList<>());
        return cell;
    }

    @Override
    public List<Organism> getAllPrototypes() {
        return Arrays.asList(PROTOTYPES);
    }
}
