package ru.javarush.island.hozhasaitov.app.interfaces;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.javarush.island.hozhasaitov.app.entity.map.Cell;
import ru.javarush.island.hozhasaitov.app.util.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PredatoryAnimal extends Animal {

    @Override
    public void eat() {
        if (gameMap[this.getCoorY()][this.getCoorX()].getHerbivorousAnimals().size() > 0) {
            List<HerbivorousAnimal> herbivorousAnimals = gameMap[this.getCoorY()][this.getCoorX()]
                    .getHerbivorousAnimals().stream().filter(h -> diet.containsKey(h.getClass())).toList();
            for (HerbivorousAnimal h : herbivorousAnimals) {
                if (tryingEat(h, diet.get(h.getClass()))) {
                    weight = Math.min(weightMax + h.getWeightMax(), weightMax);
                    break;
                }
            }
        }
    }

    private boolean tryingEat(HerbivorousAnimal h, Integer integer) {
        List<HerbivorousAnimal> herbivorousAnimals = gameMap[h.getCoorY()][getCoorX()]
                .getHerbivorousAnimals();
        if (integer >= Randomaizer.randomInt()) {

            herbivorousAnimals.remove(h);
            DecrementСounterAnimal.decrement(h);
            return true;
        }
        return false;
    }

    @Override
    public int[] searchPrey() {
        Cell[] lineMoveX = GetterLineX.getLine(this, gameMap);
        Cell[] lineMoveY = GetterLineY.getLine(this, gameMap);
        int offX = Math.max(this.getCoorX() - this.getSpeed(), 0);
        int offY = Math.max(this.getCoorY() - this.getSpeed(), 0);
        int coordPreyX = SearcherPrey.searchPreyLine(this, lineMoveX, true);
        int coorX = offX + coordPreyX;
        int coorY;
        if (coordPreyX != this.coorX) {
            coorY = this.coorY;
        } else {
            coorY = offY + SearcherPrey.searchPreyLine(this, lineMoveY, false);
        }
        return new int[]{coorX, coorY};
    }

    @Override
    public void move(int[] coordinates) {
        int newCoordX = coordinates[0];
        int newCoordY = coordinates[1];
        int oldCoordX = this.coorX;
        int oldCoordY = this.coorY;
        gameMap[newCoordY][newCoordX].getPredatoryAnimals().add(this);
        this.setCoorX(newCoordX);
        this.setCoorY(newCoordY);
        gameMap[oldCoordY][oldCoordX].getPredatoryAnimals().remove(this);

    }

    @Override
    public void spawn() {
        Class<? extends Animal> predator = this.getClass();
        AtomicInteger counter = new AtomicInteger(0);
        gameMap[this.getCoorY()][this.getCoorX()].getPredatoryAnimals().forEach(p -> {
            if (predator == p.getClass())
                counter.getAndIncrement();
        });
        if (counter.get() > 1 && counter.get() < maximumAmount) {

            try {
                gameMap[this.getCoorY()][this.getCoorX()].getPredatoryAnimals()
                        .add((PredatoryAnimal) this.clone());
            } catch (CloneNotSupportedException e) {
                System.out.println("Не получилось клонировать");
            }

        }
    }

    @Override
    public void die() {
        if (weightMax == 0 || weightMax < 0) {
            gameMap[coorY][coorX].getPredatoryAnimals().remove(this);
        } else {
            weightMax = weightMax - amountFod;
        }
    }
}
