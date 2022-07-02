package ru.javarush.island.zazimko.classes.animals.herbivores;

import ru.javarush.island.zazimko.classes.animals.Animal;
import ru.javarush.island.zazimko.classes.animals.Organism;
import ru.javarush.island.zazimko.classes.plants.Plant;
import ru.javarush.island.zazimko.exceptions.IslandConfigException;
import ru.javarush.island.zazimko.gameField.Cell;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Herbivores extends Animal {
    public void toDie(Cell cell) {
        ConcurrentHashMap<Type, Set<Organism>> organisms = cell.getOrganisms();
        Class<? extends Herbivores> aClass = this.getClass();
        Set<Organism> organismSet = organisms.get(aClass);
        if (this.getWeight() < this.getWeight() * 0.5) {
            organismSet.remove(this);
        }
    }


    public void toEat(Cell cell) {
        ConcurrentHashMap<Type, Set<Organism>> organisms = cell.getOrganisms();//получили мапу с организмами на клетке
        Set<Organism> checkFood = checkFood(organisms);//отсортировали траву
        for (Organism organism : checkFood) {
            if (this.getWeight() < this.getMaxWeight()) {
                this.setWeight(this.getWeight() + organism.getWeight());
                checkFood.remove(organism);
            } else break;
        }
    }

    public Set<Organism> checkFood(ConcurrentHashMap<Type, Set<Organism>> organisms) {
        Set<Type> types = organisms.keySet();
        Set<Organism> checkedHerbivores = new HashSet<>();
        for (Type type : types) {
            if (type instanceof Plant plant) {
                checkedHerbivores.addAll(organisms.get(plant));
            }
        }
        return checkedHerbivores;
    }


    public void toMove(Cell currentCell) {
        Cell destination;
        int quantityOfSteps = this.getSpeed();
        destination = currentCell.getNextCell(quantityOfSteps);
        ConcurrentHashMap<Type, Set<Organism>> destinationOrganisms = destination.getOrganisms();
        Set<Organism> destinationSetOrganisms = destinationOrganisms.get(this.getClass());
        destinationSetOrganisms.add(this);
        currentCell.getOrganisms().get(this.getClass()).remove(this);
        this.setWeight(this.getWeight() - (this.getWeight() * 0.1));
    }


    public void toMultiply(Cell cell) {
        ConcurrentHashMap<Type, Set<Organism>> organisms = cell.getOrganisms();
        Class<? extends Herbivores> aClass = this.getClass();
        Organism organism = checkMultiply(aClass, organisms);
        Set<Organism> organismSet = organisms.get(aClass);
        organismSet.add(organism);
    }

    private Organism checkMultiply(Class<? extends Herbivores> aClass, ConcurrentHashMap<Type, Set<Organism>> organisms) {
        Set<Type> types = organisms.keySet();
        Organism organism = null;
        if (types.contains(aClass)) {
            Set<Organism> setToMultiply = organisms.get(aClass);
            if (setToMultiply.size() > 1) {
                try {
                    Constructor<? extends Herbivores> constructor = aClass.getConstructor();
                    organism = constructor.newInstance();
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                         IllegalAccessException | RuntimeException e) {
                    throw new IslandConfigException("NO found constructor!!!");
                }

            }
        }
        return organism;
    }

}
