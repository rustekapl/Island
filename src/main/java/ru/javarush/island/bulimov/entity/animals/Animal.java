package ru.javarush.island.bulimov.entity.animals;

import ru.javarush.island.bulimov.abstractions.Eating;
import ru.javarush.island.bulimov.abstractions.Movable;
import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.islandMap.Cell;
import ru.javarush.island.bulimov.islandMap.Island;
import ru.javarush.island.bulimov.settings.OrganismSetting;
import ru.javarush.island.bulimov.util.Random;

import java.util.HashMap;
import java.util.Map;


public abstract class Animal extends Organism implements Eating, Movable {
    public int maxSpeedInCell;
    public double maxSaturation;


    public Animal(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, saturation);
        this.maxSpeedInCell = maxSpeedInCell;
        this.maxSaturation = maxSaturation;

    }

    @Override
    public boolean eating(Cell cell){
        cell.getLock().lock();
        try{
            if(this.weight > 0){
                int iter = -1;
                int rnd = Random.random(0, findEat(this).size());
                for (Map.Entry<String, Integer> pair : findEat(this).entrySet()) {
                    iter++;
                    if (iter == rnd){
                        if(cell.getAnimalsCell().get(pair.getKey())!= null
                                && cell.getAnimalsCell().get(pair.getKey()).size() > 0){
                            for (Organism organism : cell.getAnimalsCell().get(pair.getKey())) {
                                if(organism.weight > 0 && Random.random(0, 100) > pair.getValue()){
                                    if(this.saturation + organism.weight >= this.maxSaturation) this.saturation = this.maxSaturation;
                                    else this.saturation += organism.weight;
                                    organism.weight = 0;
                                    break;
                                }
                            }
                        }
                    }

                }
            }
            return false;
        }
        finally {
            cell.getLock().unlock();
        }
    }
    @Override
    public boolean reproducing(Cell cell)  {
        cell.getLock().lock();
        try{
            if(cell.getAnimalsCell().get(this.name).size() > 0 && this.weight > 0) {
                cell.getAnimalsCell().get(this.name).stream()
                        .filter(s-> !s.pregnancy && s.weight > 0)
                        .findAny()
                        .get().pregnancy = true;
                return true;
            }
            return false;
        }
        finally {
            cell.getLock().unlock();
        }
    }
    @Override
    public boolean moving(Cell cell) {
        cell.getLock().lock();
        int column = cell.column;
        int line = cell.line;
        try {
            if (this.weight > 0){
                this.remove(cell);
                int rout = Random.random(0, 3);
                switch (rout) {
                    case 0 -> {
                        if (column + this.maxItemCell >= 100)
                            column = 100;
                        else {
                            column += this.maxItemCell;
                        }
                    }
                    case 1 -> {
                        if (column - this.maxItemCell <= 0)
                            column = 0;
                        else {
                            column -= this.maxItemCell;
                        }
                    }
                    case 2 -> {
                        if (line + this.maxItemCell >= 20)
                            line = 20;
                        else {
                            line += this.maxItemCell;
                        }
                    }
                    case 3 -> {
                        if (line - this.maxItemCell <= 0)
                            line = 0;
                        else {
                            line -= this.maxItemCell;
                        }
                    }
                }
                this.goNewCell(column, line);
                this.weight -= 0.5;
                return true;
            }
            return false;
        }
        finally {
            cell.getLock().unlock();
        }//Поменять switch на метод
    }
    public void remove(Cell cell){
        cell.getLock().lock();
        try{
            cell.getAnimalsCell().get(this.name).remove(this);
        }
        finally {
            cell.getLock().unlock();
        }
    }
    public void goNewCell(int column, int line){
        Island.getAnimalMap()[column][line].getLock().lock();
        try{
            if(Island.getAnimalMap()[column][line].getAnimalsCell().get(this.name).size()< this.maxItemCell)
                Island.getAnimalMap()[column][line].getAnimalsCell().get(this.name).add(this);
        }
        finally {
            Island.getAnimalMap()[column][line].getLock().unlock();
        }
    }

    public static HashMap<String, Integer> findEat(Organism organism){
        HashMap<String, Integer> eat = new HashMap<>();
        for (int name = 0; name < OrganismSetting.getNames().length; name++) {
            if(organism.name.equals(OrganismSetting.getNames()[name])){
                for (int percent = 0; percent < OrganismSetting.getPercent()[name].length; percent++) {
                    if(OrganismSetting.getPercent()[name][percent] > 0){
                        eat.put(OrganismSetting.getNames()[percent], OrganismSetting.getPercent()[name][percent]);
                    }
                }
            }
        }
        return eat;
    }




}
