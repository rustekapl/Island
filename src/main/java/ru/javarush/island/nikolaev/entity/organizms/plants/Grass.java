package ru.javarush.island.nikolaev.entity.organizms.plants;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.map.Cell;
import ru.javarush.island.nikolaev.entity.organizms.Limit;
import ru.javarush.island.nikolaev.entity.organizms.Organism;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Setting(name = "Grass", icon = "\u2F8B", maxWeight = 1, maxCount = 200, maxSpeed = 0, maxFood = 0, idFromTheSpecTable = 14)
public class Grass extends Organism {

    public Grass(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }


    @Override
    public void spawn(Cell currentCell) {
        Type type = this.getClass();
        Map<Type, Set<Organism>> residents = currentCell.getResidents();
        Set<Organism> organisms = residents.get(type);
        if (Objects.nonNull(organisms) && organisms.contains(this)) {
            organisms.add(clone(this));
        } else {
            throw new IllegalStateException(this + " not found at " + currentCell);
        }
    }


}
