package ru.javarush.island.hozhasaitov.app.interfaces;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.animals.Animal;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class HerbivorousAnimal extends Animal {
    @Override
    public void eat() {

    }

    @Override
    public void move(int[] coordinates) {

    }

    @Override
    public int[] searchPrey() {
        return new int[0];
    }

    @Override
    public void spawn() {
        Class<? extends Animal> herbivorous = this.getClass();
        AtomicInteger counter = new AtomicInteger(0);
        gameMap[this.getCoorY()][this.getCoorX()].getHerbivorousAnimals().forEach(h -> {
            if (herbivorous == h.getClass())
                counter.getAndIncrement();
        });
        if (counter.get() > 1 && counter.get() < maximumAmount) {

            try {
                gameMap[this.getCoorY()][this.getCoorX()].getHerbivorousAnimals()
                        .add((HerbivorousAnimal) this.clone());
            } catch (CloneNotSupportedException e) {
                System.out.println("Не получилось клонировать");
            }

        }
    }

    @Override
    public void die() {
        if (weightMax > 0) {
            weightMax = weightMax - amountFod;
        } else if (weightMax == 0 || weightMax < 0) {
            gameMap[coorY][coorX].getHerbivorousAnimals().remove(this);
        }
    }
}
