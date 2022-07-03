package ru.javarush.island.gribanov.entity.lives.plants;

import ru.javarush.island.gribanov.entity.lives.Limit;
import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.entity.map.Cell;
import ru.javarush.island.gribanov.utils.RandomGenerator;

import java.util.Set;

public class Plant extends Organism {
    private final static Limit limit;
    static {
        limit = new Limit(1.0, 0.0,200,0,0.0);
    }
    public Plant() {
        super("Растение", "\uD83C\uDF31", limit.getMAX_WEIGHT(), limit);
    }

    public Plant(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public void spawn(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            Set<Organism> plants = currentCell.getResidents().get(getType());
            if (plants.size() < getLimit().getCOUNT_ON_CELL() &&
                    getWeight() > getLimit().getMAX_WEIGHT() / 2
            ) {
                double plantRatio = (double)(plants.size())/getLimit().getCOUNT_ON_CELL();
                if (Double.compare(plantRatio, 0.2d) <= 0){
                    plants.add(new Plant());
                } else if (Double.compare(plantRatio, 0.5d) <= 0){
                    newProbablyPlant(50, plants);
                } else if (Double.compare(plantRatio, 0.8d) <= 0){
                    newProbablyPlant(10, plants);
                }
            }
        }
        finally {
            currentCell.getLock().unlock();
        }
    }

    private void newProbablyPlant(int probably, Set<Organism> plants){
        if (RandomGenerator.get(probably)){
            plants.add(new Plant());
        }
    }
}
