package ru.javarush.island.zazimko.classes.animals.carnivores;

import ru.javarush.island.zazimko.classes.animals.Animal;
import ru.javarush.island.zazimko.classes.animals.Organism;
import ru.javarush.island.zazimko.classes.util.Randoms;
import ru.javarush.island.zazimko.exceptions.IslandConfigException;
import ru.javarush.island.zazimko.gameField.Cell;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Carnivore extends Animal {
    public Carnivore() {

    }

    public void toDie(Cell cell) {
        ConcurrentHashMap<Type, Set<Organism>> organisms = cell.getOrganisms();
        Class<? extends Carnivore> aClass = this.getClass();
        Set<Organism> organismSet = organisms.get(aClass);
        if (this.getWeight() < this.getWeight() * 0.5) {
            organismSet.remove(this);
        }
    }


    public void toEat(Cell cell) {
        ConcurrentHashMap<Type, Set<Organism>> organisms = cell.getOrganisms();//получили мапу с организмами на клетке
        ConcurrentHashMap<Type, Integer> initializedRation1 = this.initializedRation;//Получили мапу с рационом
        Set<Organism> checkFood = checkFood(organisms, initializedRation1);//отсеяли организмы не входящие в рацион
        for (Organism organism : checkFood) {
            if (checkEat(organism, initializedRation1)) {
                if (this.getWeight() < this.getMaxWeight()) {
                    this.setWeight(this.getWeight() + organism.getWeight());
                    checkFood.remove(organism);
                } else break;
            }
        }
    }

    public Set<Organism> checkFood(ConcurrentHashMap<Type, Set<Organism>> organisms, ConcurrentHashMap<Type, Integer> initializedRation1) {
        Set<Type> types = organisms.keySet();
        Set<Type> types1 = initializedRation1.keySet();
        Set<Organism> checkedHerbivores = new HashSet<>();
        for (Type type : types) {
            if (types1.contains(type)) {
                checkedHerbivores.addAll(organisms.get(type));
            }
        }
        return checkedHerbivores;
    }

    public boolean checkEat(Organism organism, ConcurrentHashMap<Type, Integer> initializedRation1) {
        return Randoms.get(initializedRation1.get(organism));
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
        Class<? extends Carnivore> aClass = this.getClass();
        Organism organism = checkMultiply(aClass, organisms);
        Set<Organism> organismSet = organisms.get(aClass);
        organismSet.add(organism);
    }

    private Organism checkMultiply(Class<? extends Carnivore> aClass, ConcurrentHashMap<Type, Set<Organism>> organisms) {
        Set<Type> types = organisms.keySet();
        Organism organism = null;
        if (types.contains(aClass)) {
            Set<Organism> setToMultiply = organisms.get(aClass);
            if (setToMultiply.size() > 1) {
                try {
                    Constructor<? extends Carnivore> constructor = aClass.getConstructor();
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
