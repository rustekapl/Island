package ru.javarush.island.bityutskih.services;

import ru.javarush.island.bityutskih.entity.Plant;

public class PlantRunner implements Runnable {

    public PlantRunner(Plant ignoredPlant) {
    }

    @Override
    public void run() {
        do {
            reproduce();
            ServiceSleep.sleep(10);
        } while (!Thread.currentThread().isInterrupted());
    }

    public void reproduce() {

    }
}
