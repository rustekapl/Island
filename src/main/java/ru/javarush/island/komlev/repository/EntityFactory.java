package ru.javarush.island.komlev.repository;

import ru.javarush.island.komlev.etnity.map.Cell;
import ru.javarush.island.komlev.etnity.organizms.Organism;
import ru.javarush.island.komlev.etnity.organizms.animals.herbivores.*;
import ru.javarush.island.komlev.etnity.organizms.animals.predators.*;
import ru.javarush.island.komlev.etnity.organizms.plants.Plant;
import ru.javarush.island.komlev.util.EntityFactoryData;
import ru.javarush.island.komlev.util.Randomizer;

import java.lang.reflect.Type;
import java.util.*;

public class EntityFactory implements Factory {
    private static final Class<?>[] TYPES = {Plant.class, Wolf.class, Bear.class,
            Boa.class, Buffalo.class, Boar.class, Caterpillar.class, Deer.class, Duck.class,
            Goat.class, Horse.class, Mouse.class, Rabbit.class, Sheep.class,
            Eagle.class, Fox.class};
    private static final Organism[] GERMS = EntityFactoryData.createGerms(TYPES);

    public EntityFactory() {
    }

    @Override
    public Cell createRandomCell() {
        Map<Type, Set<Organism>> residents = new HashMap<>();
        boolean fill = Randomizer.get(90);
        if (fill) {
            for (Organism germ : GERMS) {
                Type type = germ.getClass();
                boolean born = Randomizer.get(50);
                if (born) {
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<Organism> organisms = residents.get((germ.getClass()));
                    int currentCount = organisms.size();
                    int max = germ.getLimit().getMaxCount() - currentCount;
                    int count = Randomizer.random(0, max);
                    for (int i = 0; i < count; i++) {
                        organisms.add(germ.clone());

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
        return Arrays.asList(GERMS);
    }

    @Override
    public String toString() {
        return "EntityFactory{"
                + "germs="
                + Arrays.toString(GERMS) + '}';
    }
}
