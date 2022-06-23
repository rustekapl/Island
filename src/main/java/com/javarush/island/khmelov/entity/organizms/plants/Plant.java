package com.javarush.island.khmelov.entity.organizms.plants;

import com.javarush.island.khmelov.abstraction.annotations.Setting;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.Organism;

import java.util.Set;

@Setting(name = "Трава", icon = "\u2F8B", maxWeight = 1, maxCount = 200, maxSpeed = 0, maxFood = 0)
public class Plant extends Organism {
    public Plant(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

    @Override
    public boolean spawn(Cell cell) {
        Cell neighborCell = cell.getNextCell(1);
        neighborCell.getLock().lock();
        try {
            this.changeWeight(cell, 2);
            Set<Organism> plants = neighborCell.getResidents().get(getType());
            if (plants.size() < getLimit().getMaxCount() &&
                    getWeight() > getLimit().getMaxWeight() / 5
            ) {
                Organism newPlant = Organism.clone(this);
                double childWeight = getWeight() / 20;
                newPlant.setWeight(childWeight);
                return plants.add(newPlant);
            }
        } finally {
            neighborCell.getLock().unlock();
        }
        return false;
    }
}
