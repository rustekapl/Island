package ru.javarush.island.stepanov.settings;

import lombok.Getter;

import java.util.Map;

@Getter
public class CreatureGeneralSettings {

    private double fullWeight;
    private int maxPopulationPerCell;
    private int startPopulation;
    private int speed;
    private double hungerCapacity;
    private Map<String, Integer> foodChainSettings;

    //TODO ---  unused
    //TODO Code style. Many warnings. Skip or fix it.
    public CreatureGeneralSettings() {
        super();
    }

    public CreatureGeneralSettings(double fullWeight, int maxPopulationPerCell, int startPopulation, int speed, double hungerCapacity, Map<String, Integer> foodChainSettings) {
        this.fullWeight = fullWeight;
        this.maxPopulationPerCell = maxPopulationPerCell;
        this.startPopulation = startPopulation;
        this.speed = speed;
        this.hungerCapacity = hungerCapacity;
        this.foodChainSettings = foodChainSettings;
    }


}
