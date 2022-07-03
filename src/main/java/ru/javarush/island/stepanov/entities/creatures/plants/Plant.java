package ru.javarush.island.stepanov.entities.creatures.plants;

import lombok.Getter;
import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.entities.location.LocationCell;
import ru.javarush.island.stepanov.utils.logger.LifeCycleStages;
import ru.javarush.island.stepanov.utils.logger.Logger;

@Getter
public class Plant extends Creature {
    public Plant(){
        super();
    }

    @Override
    public boolean starved() {
        return false;
    }

    @Override
    public void removeWeightByPeriod() {
    }

    @Override
    public void reproduce(LocationCell cell){

        if (this.getIsReadyForAction().get()) {

            cell.getLock().lock();

            try {
                if (cell.containsCreature(this)) {
                    this.clone().spawn(cell);

                    String msg = "Reproduced at cell.";
                    Logger.logEvent(LifeCycleStages.REPRODUCE, this, cell, msg);
                } else {

                    String msg = "Did not reproduced. Plant does not exists.";
                    Logger.logEvent(LifeCycleStages.REPRODUCE, this, cell, msg);
                }

            } finally {
                cell.getLock().unlock();
            }
        }
    }

    @Override
    public Plant clone() {
        return (Plant) super.clone();
    }
}
