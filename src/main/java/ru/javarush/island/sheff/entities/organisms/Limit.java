package ru.javarush.island.sheff.entities.organisms;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Limit {
    private double maxWeight;
    private double maxFood;
    private int maxCount;
    private int maxSpeed;
    private int femaleGenderChance;
    private int[] offspring;
    private Map<String, Integer> ration;

    @Override
    public String toString() {
        return "Limit{" +
                "maxWeight=" + maxWeight +
                ", maxFood=" + maxFood +
                ", maxCount=" + maxCount +
                ", maxSpeed=" + maxSpeed +
                ", offspring=" + Arrays.toString(offspring) +
                ", ration=" + ration +
                '}';
    }
}
