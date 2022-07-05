package ru.javarush.island.komlev.etnity.organizms.plants;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.map.Cell;
import ru.javarush.island.komlev.etnity.organizms.Limit;
import ru.javarush.island.komlev.etnity.organizms.Organism;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@TypeData(name = "трава", icon = "\u2F8B", maxWeight = 1, maxCount = 200, maxSpeed = 0, maxFood = 0)
public class Plant extends Organism {

    public Plant(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public void spawn(Cell currentCell) {
        Type type = this.getClass();
        Map<Type, Set<Organism>> residents = currentCell.getResidents();
        Set<Organism> organisms = residents.get(type);
        if (Objects.nonNull(organisms) && organisms.contains(this)) {
            organisms.add(this.clone());
        } else {
            throw new IllegalStateException(this + " not found at " + currentCell);
        }
    }
}
