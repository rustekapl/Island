package ru.javarush.island.volokitin.entities.organisms;

import ru.javarush.island.volokitin.entities.organisms.animals.Animal;
import ru.javarush.island.volokitin.entities.settings.Settings;
import ru.javarush.island.volokitin.entities.world.Area;
import ru.javarush.island.volokitin.util.Randomizer;

public abstract class Organism {
    private final String type = this.getClass().getSimpleName();
    private double weight;

    public abstract void multiply(Area area);

    public abstract void growUp(Area area);

    protected Organism() {
        OrganismsCommonSpecs organismCommonSpecs = Settings.get().getOrganismCommonSpecsByType(this.type);
        this.weight = Randomizer.getRandom(organismCommonSpecs.getMaxWeight() / 2.0D, organismCommonSpecs.getMaxWeight());
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getChildrenQuantity(Area area) {
        Settings settings = Settings.get();
        Integer childrenQuantity = settings.getOrganismsChildrenQuantity().get(getType());
        int maxQuantityInArea = settings.getOrganismCommonSpecsByType(getType()).getMaxQuantity();
        int newBornQuantity = Randomizer.getRandom(0, Math.min(childrenQuantity, maxQuantityInArea));
        int sameOrganismTypeQuantity = area.getInhabitants().get(this.getType()).toArray().length;

        return Math.min(maxQuantityInArea - sameOrganismTypeQuantity, newBornQuantity);
    }

    public void starve(Area area) {
        safeStarve(area);
    }

    private void safeStarve(Area area) {
        area.getLock().lock();
        try {
            OrganismsCommonSpecs organismCommonSpecs = Settings.get().getOrganismCommonSpecsByType(this.getType());
            int weightLossPercent;
            if (this instanceof Animal) {
                //TODO Coding. Magic values or methods. Bad reading and understanding
                //TODO Coding. Need move to config or settings
                weightLossPercent = 20;
            } else {
                weightLossPercent = 1;
            }

            double weightLoss = organismCommonSpecs.getMaxWeight() * weightLossPercent / 100;
            this.setWeight(this.getWeight() - weightLoss);
            //TODO Coding. Magic values or methods. Bad reading and understanding
            //TODO Coding. Need move to config or settings
            if (this.getWeight() < organismCommonSpecs.getMaxWeight() * 0.3) {
                area.getInhabitants().get(this.getType()).remove(this);
            }
        } finally {
            area.getLock().unlock();
        }
    }
}
