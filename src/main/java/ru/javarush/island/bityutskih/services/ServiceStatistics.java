package ru.javarush.island.bityutskih.services;

import ru.javarush.island.bityutskih.entity.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class ServiceStatistics implements Runnable {
    private final Service service;

    public ServiceStatistics(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        int predatorCounter = 0;
        int herbCounter = 0;
        int plantCounter = 0;
        int deadCounter = 0;

        CopyOnWriteArrayList<Nature> nature = service.getNature();
        for (Nature obj : nature) {
            if (obj instanceof Predators && !obj.isDead()) {
                predatorCounter++;
            } else if (obj instanceof Herbivores && !obj.isDead()) {
                herbCounter++;
            } else if (obj instanceof Plant && !obj.isDead()) {
                plantCounter++;
            }
            if (obj.isDead()) {
                deadCounter++;
            }
        }
        //TODO Coding. System.out here? Need move the output to View layer
        System.out.println("Хищников: " + predatorCounter);
        System.out.println("Травоядных: " + herbCounter);
        System.out.println("Растений: " + plantCounter);
        System.out.println("Погибло: " + deadCounter);
        System.out.println("***********************************************");
    }
}