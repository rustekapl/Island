package com.javarush.island.khmelov.entity.organizms.plants;

import com.javarush.island.khmelov.abstraction.annotations.Setting;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.Organism;
import com.javarush.island.khmelov.util.Probably;

import java.util.Set;

@Setting(name = "Трава", icon = "\u2F8B", maxWeight = 1, maxCount = 200, maxSpeed = 0, maxFood = 0)
public class Plant extends Organism {
    public Plant(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

    @Override
    public boolean spawn(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> organisms = cell.getResidents().get(getType());
            int count = getWeight() > getLimit().getMaxWeight() / 2 &&
                    Probably.random(0, 10) < 8 && //TODO 10==off
                    organisms.contains(this) &&
                    organisms.size() > 2 &&
                    organisms.size() < getLimit().getMaxCount()
                    ? 1
                    : 0;
            if (count > 0) {
                boolean born = organisms.size() < getLimit().getMaxCount();
                if (organisms.contains(this) && born) {
                    double childWeight = getWeight() / (1 + count);
                    for (int i = 0; i < count; i++) {
                        Organism clone = Organism.clone(this);
                        clone.setWeight(childWeight);
                        organisms.add(clone);
                    }
                    return born;
                }
            }
        } finally {
            cell.getLock().unlock();
        }
        return false;
    }
}
