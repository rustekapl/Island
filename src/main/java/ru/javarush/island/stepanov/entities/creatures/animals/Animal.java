package ru.javarush.island.stepanov.entities.creatures.animals;

import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.location.LocationCell;
import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.intefaces.Eater;
import ru.javarush.island.stepanov.intefaces.Movable;
import ru.javarush.island.stepanov.utils.logger.LifeCycleStages;
import ru.javarush.island.stepanov.utils.logger.Logger;
import ru.javarush.island.stepanov.utils.RandomGenerator;

import java.util.*;

public abstract class Animal extends Creature implements Movable, Eater {
    public Animal(){
        super();
    }

    @Override
    public void move(LocationCell cell, Location location) {
        LocationCell targetCell = calculateNewCell(cell, location);
        if (targetCell.equals(cell)){
            safeNotMove(cell);
        } else {
            this.getIsReadyForAction().set(false);  // lock creatures for other operations while moving
            safeMove(cell, targetCell);
            this.getIsReadyForAction().set(true);
        }
    }
    private void safeMove(LocationCell fromCell, LocationCell toCell){
        boolean isDestinationSpawned;

        // spawn in target cell
        toCell.getLock().lock();
        try {
            isDestinationSpawned = this.spawn(toCell);
            if (isDestinationSpawned) {
                String msg = "Was successfully spawned / moved to target cell";
                Logger.logEvent(LifeCycleStages.MOVE, this, fromCell, toCell, msg);
            } else {
                String msg = "Was not spawned / moved to target cell due to no free space";
                Logger.logEvent(LifeCycleStages.MOVE, this, fromCell, toCell, msg);
            }
        } finally {
            toCell.getLock().unlock();
        }

        // die in current cell or cancel spawn in target cell
        fromCell.getLock().lock();
        try {
            if (isDestinationSpawned && fromCell.containsCreature(this)) {
                this.die(fromCell);

                String msg = "Die in source cell due to successfull move to new cell";
                Logger.logEvent(LifeCycleStages.MOVE, this, fromCell, toCell, msg);
            } else {
                this.die(toCell);

                String msg = "Cancel move to target cell because creature does not exists in source cell";
                Logger.logEvent(LifeCycleStages.MOVE, this, fromCell, toCell, msg);
            }
        } finally {
            fromCell.getLock().unlock();
        }
    }

    private void safeNotMove(LocationCell cell){
        cell.getLock().lock();
        try {
            if (cell.containsCreature(this)){
                String msg = "Moved to the same cell";
                Logger.logEvent(LifeCycleStages.MOVE, this, cell, msg);
            } else {
                String msg = "No longer exists in cell";
                Logger.logEvent(LifeCycleStages.MOVE, this, cell, msg);
            }
        } finally {
            cell.getLock().unlock();
        }
    }

    private LocationCell calculateNewCell(LocationCell cell, Location location){

        int speed = this.getSettings().getSpeed();
        if (speed > 0) {
            for (int i = 0; i < this.getSettings().getSpeed(); i++) {
                List<LocationCell> cellsAround = location.getCellsAround(cell);
                cell = cellsAround.get(RandomGenerator.get(cellsAround.size() - 1));
            }
        }
        return cell;
    }

    @Override
    public void eat(LocationCell cell) {

        if (this.getCurrentWeight() < this.getSettings().getFullWeight() && cell.containsCreature(this)){
            Map.Entry<String, Integer> topPriorityPrey = getTopPriorityPrey(cell);

            if (topPriorityPrey != null){
                Set<Creature> priorityCreatures = cell.getCellInhabitants().get(topPriorityPrey.getKey());

                cell.getLock().lock();
                try {
                    List<Creature> dieCreatures = new ArrayList<>();
                    for (Creature creature: priorityCreatures) {
                        if (RandomGenerator.get(100) < topPriorityPrey.getValue()){
                            if (cell.containsCreature(this)
                                    && cell.containsCreature(creature)
                                    && this.getIsReadyForAction().get()
                                    && creature.getIsReadyForAction().get()
                            ) {
                                this.setCurrentWeight(
                                        this.getCurrentWeight() + creature.getCurrentWeight()
                                );
                                dieCreatures.add(creature);

                                String msg = "Creature#1 has eaten Creature#2";
                                Logger.logEvent(LifeCycleStages.EAT, this, creature, cell, msg);
                            } else {

                                String msg = "Creature#1 did not eat. Cell does not contains Creature#1 or its prey (Creature#2)";
                                Logger.logEvent(LifeCycleStages.EAT, this, creature, cell, msg);
                            }
                        } else {

                            String msg = "Creature#1 had no chances to eat Creature#2";
                            Logger.logEvent(LifeCycleStages.EAT, this, creature, cell, msg);
                        }
                        if (this.getCurrentWeight() >= this.getSettings().getFullWeight()){
                            break;
                        }
                    }
                    for (Creature creature: dieCreatures) {
                        creature.die(cell);
                    }
                } finally {
                    cell.getLock().unlock();
                }
            } else {

                String msg = "Creature has no priority prey to eat at current cell";
                Logger.logEvent(LifeCycleStages.EAT, this, cell, msg);
            }
        } else {

            String msg = "Creature has full weight or no such creature exists";
            Logger.logEvent(LifeCycleStages.EAT, this, cell, msg);
        }
    }

    private Map.Entry<String, Integer> getTopPriorityPrey(LocationCell cell) {

        // Sort food chain elements according to Kill-probability
        Map.Entry<String, Integer> priorityFood = this.getSettings().getFoodChainSettings()
                .entrySet()
                .stream()
                .filter(o -> cell.getCellInhabitants().get(o.getKey()) != null
                        && cell.getCellInhabitants().get(o.getKey()).size() > 0)
                .max(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (Objects.equals(o1.getValue(), o2.getValue())) {
                            return 0;
                        } else {
                            return o1.getValue() > o2.getValue() ? 1 : -1;
                        }
                    }
                })
                .orElse(null)
                ;
        return priorityFood;
    }
}
