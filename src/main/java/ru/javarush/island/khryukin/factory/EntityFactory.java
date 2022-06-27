package ru.javarush.island.khryukin.factory;

import ru.javarush.island.khryukin.entity.animals.herbivores.Horse;
import ru.javarush.island.khryukin.entity.animals.organisms.Organism;
import ru.javarush.island.khryukin.entity.animals.predators.Bear;
import ru.javarush.island.khryukin.entity.animals.predators.Wolf;
import ru.javarush.island.khryukin.entity.map.Cell;
import ru.javarush.island.khryukin.utils.EntityFactoryData;
import ru.javarush.island.khryukin.utils.RandomValue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.*;

public class EntityFactory implements Factory {
    private static final Class<?>[] TYPES = {Wolf.class, Horse.class, Bear.class};
    private static final Organism[] PROTOTYPES;

    static {
        try {
            PROTOTYPES = EntityFactoryData.createPrototypes(TYPES);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public EntityFactory() {

    }

    @Override
    public Cell createRandomCell() {
        Map<Type, Set<Organism>> residents = new HashMap<>();
        boolean fill = RandomValue.get(50);
        if (fill) {
            for (Organism prototype : PROTOTYPES) {
                Type type = prototype.getClass();
                boolean born = RandomValue.get(50);
                if (born) {
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<Organism> organisms = residents.get(prototype.getClass());
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
