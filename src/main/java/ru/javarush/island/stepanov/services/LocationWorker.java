package ru.javarush.island.stepanov.services;

import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.registry.PrototypeRegistry;
import ru.javarush.island.stepanov.settings.GlobalSettings;
import ru.javarush.island.stepanov.utils.logger.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LocationWorker extends Thread{

    private static final Integer N_THREADS = 4;
    private static final Integer OUTPUT_FREQUENCY = 1;
    private final AtomicInteger nRuns = new AtomicInteger(0);
    private final Location location;
    private final PrototypeRegistry prototypeRegistry;

    public LocationWorker(Location location, PrototypeRegistry prototypeRegistry, GlobalSettings settings) {
        this.location = location;
        this.prototypeRegistry = prototypeRegistry;
        this.nRuns.set(settings.getCountPeriods());
    }

    @Override
    public void run() {

        Logger.logStatistics(location);

        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(N_THREADS);
        List<CreatureWorker> workers = this.generateWorkers();

        mainPool.scheduleWithFixedDelay(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(N_THREADS);
            workers.forEach(servicePool::submit);
            this.awaitTermination(servicePool);

            Logger.logStatistics(location);
            Logger.dumpLogToFile();

            int stepCount = this.nRuns.getAndDecrement();
            if (stepCount == 0){
                mainPool.shutdown();
            }

        }, OUTPUT_FREQUENCY, OUTPUT_FREQUENCY, TimeUnit.SECONDS);

    }

    private List<CreatureWorker> generateWorkers(){
        return prototypeRegistry.getPrototypedClasses()
                .stream()
                .map(o -> new CreatureWorker(o, location))
                .toList();
    }

    private void awaitTermination(ExecutorService pool){
        pool.shutdown();
        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
