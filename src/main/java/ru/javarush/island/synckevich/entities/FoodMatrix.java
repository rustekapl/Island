package ru.javarush.island.synckevich.entities;

import ru.javarush.island.synckevich.entities.animals.Animal;
import ru.javarush.island.synckevich.enums.EntityType;

import java.util.concurrent.ThreadLocalRandom;

public class FoodMatrix {
    private FoodMatrix() {
    }

    private static final int[][] FOOD_MATRIX = new int[][]{
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}};

    public static boolean isEaten(Animal hungryAnimal, Entity foodEntity) {
        int hungryAnimalIndex = EntityType.valueOf(hungryAnimal.getClass().getSimpleName().toUpperCase()).ordinal();
        int foodEntityIndex = EntityType.valueOf(foodEntity.getClass().getSimpleName().toUpperCase()).ordinal();
        int probabilityOfEating = FOOD_MATRIX[hungryAnimalIndex][foodEntityIndex];
        return ThreadLocalRandom.current().nextInt(100) < probabilityOfEating;
    }
}


