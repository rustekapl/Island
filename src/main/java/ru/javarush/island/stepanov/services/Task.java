package ru.javarush.island.stepanov.services;

import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.entities.creatures.animals.Animal;
import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.location.LocationCell;
import ru.javarush.island.stepanov.utils.logger.LifeCycleStages;
import ru.javarush.island.stepanov.utils.logger.Logger;
import lombok.ToString;

@ToString
public class Task {

    private final Creature creature;
    private final LocationCell cell;
    private final Location location;

    public Task(Creature creature, LocationCell cell, Location location) {
        this.creature = creature;
        this.cell = cell;
        this.location = location;
    }

    public void doDailyRoutine(){

        if (creature.starved()){
            creature.safeDie(cell);

            String msg = "Starved to death.";
            Logger.logEvent(LifeCycleStages.DIE, creature, cell, msg);
        } else {

            if (creature instanceof Animal animal){
                animal.eat(cell);
                animal.reproduce(cell);
                animal.move(cell, location);
            } else {
                creature.reproduce(cell);
            }
        }

    }
}
