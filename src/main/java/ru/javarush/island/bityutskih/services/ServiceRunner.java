package ru.javarush.island.bityutskih.services;

import ru.javarush.island.bityutskih.entity.Animal;
import ru.javarush.island.bityutskih.entity.Nature;
import ru.javarush.island.bityutskih.entity.Plant;
import ru.javarush.island.bityutskih.entity.Service;

import java.util.concurrent.*;


public class ServiceRunner {
    private final Service service;

    public ServiceRunner() {
        this.service = new Service();
    }

    public void runService() {
        service.makeNature();
        CopyOnWriteArrayList<Nature> nature = service.getNature();
        ExecutorService animalExecService = Executors.newFixedThreadPool(100);
        ExecutorService plantExecService = Executors.newFixedThreadPool(100);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10000);

        scheduledExecutorService.scheduleAtFixedRate(new ServiceStatistics(service), 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new ServiceCleaner(service), 500, 1000, TimeUnit.MILLISECONDS);

        for (Nature a : nature) {
            if (a instanceof Animal) {
                animalExecService.submit(new AnimalRunner((Animal) a, service));
            } else if (a instanceof Plant) {
                plantExecService.submit(new PlantRunner((Plant) a));
            }

        }
        try {
            Thread.sleep(10000);
            animalExecService.shutdown();
            plantExecService.shutdown();
            scheduledExecutorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        animalExecService.shutdownNow();
        plantExecService.shutdownNow();
        scheduledExecutorService.shutdownNow();
    }
}
