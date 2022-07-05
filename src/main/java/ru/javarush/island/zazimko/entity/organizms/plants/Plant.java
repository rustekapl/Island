package ru.javarush.island.zazimko.entity.organizms.plants;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.config.Setting;
import ru.javarush.island.zazimko.entity.map.Cell;
import ru.javarush.island.zazimko.entity.organizms.Limit;
import ru.javarush.island.zazimko.entity.organizms.Organism;
import ru.javarush.island.zazimko.entity.organizms.Organisms;
import ru.javarush.island.zazimko.util.Randoms;

@TypeData(name = "Трава", icon = "\u2F8B", maxWeight = 1, maxCountInCell = 200, flockSize = 20, maxSpeed = 0, maxFood = 0)
public class Plant extends Organism {
    public Plant(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

    @Override
    public boolean spawn(Cell cell) {
        this.safeChangeWeight(cell, Setting.get().getPercentPlantGrow());
        boolean born = false;
        for (int i = 0; i < 6; i++) {
            Cell neighborCell = cell.getNextCell(Randoms.random(0, 2));
            born |= safePlantPropagation(neighborCell);
        }

        return born;
    }

    private boolean safePlantPropagation(Cell cell) {
        Limit limit = getLimit();
        cell.getLock().lock();
        try {
            Organisms plants = cell.getResidents().get(getType());
            if (plants.size() < limit.getMaxCountInCell() &&
                    getWeight() > limit.getMaxWeight() / 200
            ) {
                Organism newPlant = Organism.clone(this);
                double childWeight = getWeight() / 10;
                newPlant.setWeight(childWeight);
                return plants.add(newPlant);
            }
        } finally {
            cell.getLock().unlock();
        }
        return false;
    }
}
