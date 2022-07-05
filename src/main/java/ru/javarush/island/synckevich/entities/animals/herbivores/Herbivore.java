package ru.javarush.island.synckevich.entities.animals.herbivores;

import ru.javarush.island.synckevich.entities.Entity;
import ru.javarush.island.synckevich.entities.FoodMatrix;
import ru.javarush.island.synckevich.entities.animals.Animal;

public abstract class Herbivore extends Animal {

    public boolean eat(Entity foodEntity) {
        boolean isEating = FoodMatrix.isEaten((this), foodEntity);

        if (isEating) {

            if (foodEntity.getWeight() >= this.getHungryPoints()) {
                this.setHealthPoints(this.getHungryPoints());
            } else {
                double hungerAfterEating = this.getHealthPoints() + foodEntity.getWeight();
                this.setHealthPoints(hungerAfterEating);
            }

            return true;

        } else {
            return false;
        }
    }
}
