package ru.javarush.island.stepanov.entities.creatures;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.javarush.island.stepanov.entities.location.LocationCell;
import ru.javarush.island.stepanov.intefaces.Mortal;
import ru.javarush.island.stepanov.intefaces.Reproducible;
import ru.javarush.island.stepanov.intefaces.Spawnable;
import ru.javarush.island.stepanov.settings.CreatureGeneralSettings;
import ru.javarush.island.stepanov.settings.GlobalSettings;
import ru.javarush.island.stepanov.utils.logger.LifeCycleStages;
import ru.javarush.island.stepanov.utils.logger.Logger;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@ToString
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Creature implements Cloneable,
        Spawnable, Mortal, Reproducible
{
    @JsonIgnore
    private static final AtomicLong creatureOrderNum = new AtomicLong();
    @EqualsAndHashCode.Include()
    private String name;
    @Setter
    private double currentWeight;
    private AtomicBoolean isReadyForAction = new AtomicBoolean(true);
    private final CreatureGeneralSettings settings = GlobalSettings.getInstance()
                                                        .getCreatureGeneralSettingsMap()
                                                        .get(this.getClass().getSimpleName());

    public Creature(){
        super();
        long id = creatureOrderNum.incrementAndGet();
        this.name = this.getClass().getSimpleName() + "_" + id;
    }

    @Override
    public boolean spawn(LocationCell cell){
        Set<Creature> cellCreatures = cell.getCreatures(this.getClass().getSimpleName());
        if (cellCreatures.size() < settings.getMaxPopulationPerCell()){
            cell.getCellInhabitants().get(this.getClass().getSimpleName()).add(this);
            return true;
        }
        return false;
    }
    @Override
    public void die(LocationCell cell){
        if (cell.containsCreature(this)) {
            cell.getCellInhabitants().get(this.getClass().getSimpleName()).remove(this);
        } else {
            String msg = "No longer exists";
            Logger.logEvent(LifeCycleStages.DIE, this, cell, msg);
        }
    }

    public void safeDie(LocationCell cell){
        cell.getLock().lock();
        try {
            this.die(cell);
        } finally {
            cell.getLock().unlock();
        }
    }

    @Override
    public void reproduce(LocationCell cell){

        if (this.getIsReadyForAction().get()) {

            cell.getLock().lock();

            try {
                Set<Creature> cellCreatures = cell.getCreatures(this.getClass().getSimpleName());
                if (cellCreatures.size() > 1 && cell.containsCreature(this)) {
                    this.clone().spawn(cell);

                    String msg = "Reproduced";
                    Logger.logEvent(LifeCycleStages.REPRODUCE, this, cell, msg);
                } else {

                    String msg = "No one to reproduce with / Cell is full / Creature no longer exists";
                    Logger.logEvent(LifeCycleStages.REPRODUCE, this, cell, msg);
                }

            } finally {
                cell.getLock().unlock();
            }
        }
    }

    public void removeWeightByPeriod(){
        this.currentWeight = this.currentWeight - (this.currentWeight/20);
    }

    public boolean starved(){
        if (this.currentWeight < this.settings.getFullWeight() - this.getSettings().getHungerCapacity()){
            return true;
        }
        return false;
    }

    private void setDefaultWeight(){
        this.currentWeight = this.settings.getFullWeight() - (this.settings.getFullWeight()/20);
    }
    @Override
    public Creature clone() {
        try {
            Creature clone = (Creature) super.clone();
            clone.name = clone.getClass().getSimpleName() + "_" + Creature.creatureOrderNum.incrementAndGet();
            clone.isReadyForAction = new AtomicBoolean(true);
            clone.setDefaultWeight();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
