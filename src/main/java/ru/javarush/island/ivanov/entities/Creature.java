package ru.javarush.island.ivanov.entities;

import org.jetbrains.annotations.NotNull;
import ru.javarush.island.ivanov.entities.interfaces.Breedable;
import ru.javarush.island.ivanov.entities.interfaces.WildLife;
import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.services.eat_services.CheckAmountOfConsumption;
import ru.javarush.island.ivanov.services.eat_services.PercenterForConsumption;
import ru.javarush.island.ivanov.services.randomizers.RandomizerForConsume;
import ru.javarush.island.ivanov.services.randomizers.RandomizerForType;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

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

            Set<Creature> set = square
                    .getResidents()
                    .get(type);
            //TODO Code style. Needs reformat. One line - one method
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
            //TODO Code style. Needs reformat. One line - one method
            return square.getResidents().get(getType()).remove(this);
        } finally {
            square.getLock().unlock();
        }
    }

    protected boolean safeFindFood(@NotNull Square square) {
        //TODO Code style. Long code. Needs to be split into several methods
        square.getLock().lock();
        try {
            String randomType = RandomizerForType.getRandomType(this);
            PercenterForConsumption percenter = new PercenterForConsumption();
            int chanceToEat = percenter.getPercents(this.getType(), randomType);
            boolean resultForEating = RandomizerForConsume.getResult(chanceToEat);
            if (resultForEating) {
                Set<Creature> set = square.getResidents().get(randomType);
                for (Creature creature : set) {
                    boolean enoughFoodForEater = CheckAmountOfConsumption.enoughFood(this, creature);
                    if (enoughFoodForEater) {
                        this.getParams().setTurnsToDeath(2);
                    } else {
                        this.getParams().setTurnsToDeath(this.getParams().getTurnsToDeath() - 1);
                        if (this.getParams().getTurnsToDeath() <= 0) {
                            this.setSquareInfo(null);
                            square.getResidents().get(getType()).remove(this);
                            return false;
                        }
                    }
                    set.remove(creature);
                    creature.setSquareInfo(null);
                    return true;
                }
            }
        } finally {
            square.getLock().unlock();
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public AnimalParams getParams() {
        return params;
    }

    public void setParams(AnimalParams params) {
        this.params = params;
    }
}
