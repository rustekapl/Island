package ru.javarush.ivanov.island.threads;


import ru.javarush.ivanov.island.entities.territory.Island;
import ru.javarush.ivanov.island.view.IslandModelBuilder;
import ru.javarush.ivanov.island.view.Statistic;
import ru.javarush.ivanov.island.variables.ListOfAnimalsAndHerbs;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandWorker extends Thread {
    private final Island island;

    @Override
    public void run() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        Statistic statistic = new Statistic();
        IslandModelBuilder islandModelBuilder = new IslandModelBuilder();
        islandModelBuilder.letsBuild();
        statistic.giveMeStatistic(island);
        Set<String> listOfAnimals = ListOfAnimalsAndHerbs.getCurrencies();
        List<AnimalThread> animalThreads = listOfAnimals.stream().map(o -> new AnimalThread(o, island)).toList();
        executorRunner(executor, statistic, animalThreads);
    }

    private void executorRunner(ScheduledExecutorService executor, Statistic statistic, List<AnimalThread> animalThreads) {
        executor.scheduleAtFixedRate(() -> {
            ExecutorService executorForAnimal = Executors.newFixedThreadPool(5);
            animalThreads.forEach(executorForAnimal::submit);
            executorForAnimal.shutdown();
            try {
                if (executorForAnimal.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                    statistic.giveMeStatistic(island);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    public IslandWorker(Island island) {
        this.island = island;
    }
}