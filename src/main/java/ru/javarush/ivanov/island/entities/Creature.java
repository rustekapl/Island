package ru.javarush.ivanov.island.entities;

import org.jetbrains.annotations.NotNull;
import ru.javarush.ivanov.island.entities.interfaces.Breedable;
import ru.javarush.ivanov.island.entities.interfaces.WildLife;
import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.services.eat_services.CheckAmountOfConsumption;
import ru.javarush.ivanov.island.services.eat_services.PercenterForConsumption;
import ru.javarush.ivanov.island.services.randomizers.RandomizerForConsume;
import ru.javarush.ivanov.island.services.randomizers.RandomizerForType;
import ru.javarush.ivanov.island.variables.animal_params.AnimalParams;

import java.util.Set;


public abstract class Creature implements WildLife, Breedable {

    private final String type = this.getClass().getSimpleName();
    private AnimalParams params;

    protected boolean safeDie(@NotNull Square square) {
        square.getLock().lock();
        try {
            return square.remove(this);
        } finally {
            square.getLock().unlock();
        }
    }


    protected boolean safeMove(Square source, Square destination) {
        if (safeAddTo(destination)) {
            if (safePollFrom(source)) {
                return true;
            } else {
                safePollFrom(destination);
            }
        }
        return false;
    }

    protected boolean safeAddTo(@NotNull Square square) {
        square.getLock().lock();
        try {
            Set<Creature> set = square.getResidents().get(type);
            int maxCount = this.getParams().getMaxNumberPerSquare();
            int size = set.size();
            return size < maxCount && set.add(this);
        } finally {
            square.getLock().unlock();
        }
    }

    protected boolean safePollFrom(@NotNull Square square) {
        square.getLock().lock();
        try {
            return square.getResidents().get(getType()).remove(this);
        } finally {
            square.getLock().unlock();
        }
    }

    protected boolean safeFindFood(@NotNull Square square) {
        square.getLock().lock();
        try {
            String randomType = RandomizerForType.getRandomType(this);
            PercenterForConsumption percenter = new PercenterForConsumption();
            int chanceToEat = percenter.getPercents(this.getType(), randomType);
            boolean resultForEating = RandomizerForConsume.getResult(chanceToEat);
            if (resultForEating) {
                Set<Creature> set = square.getResidents().get(randomType);
                for (Creature creature : set) {
                    return checkForEnoughFood(square, set, creature);
                }
            }
        } finally {
            square.getLock().unlock();
        }
        return false;
    }

    private boolean checkForEnoughFood(@NotNull Square square, Set<Creature> set, Creature creature) {
        boolean enoughFoodForEater = CheckAmountOfConsumption.enoughFood(this, creature);
        if (enoughFoodForEater) {
            this.getParams().setTurnsBeforeCreatureDied(2);
        } else {
            this.getParams().setTurnsBeforeCreatureDied(this.getParams().getTurnsBeforeCreatureDied() - 1);
            if (this.getParams().getTurnsBeforeCreatureDied() <= 0) {
                this.setSquareInfo(null);
                square.getResidents().get(getType()).remove(this);
                return false;
            }
        }
        set.remove(creature);
        creature.setSquareInfo(null);
        return true;
    }


    public String getType() {
        return type;
    }

    public AnimalParams getParams() {
        return params;
    }
}
