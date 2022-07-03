package ru.javarush.island.bulimov.services;

import ru.javarush.island.bulimov.entity.Game;
import ru.javarush.island.bulimov.entity.repository.AnimalsFactory;
import ru.javarush.island.bulimov.exception.IslandRunException;
import ru.javarush.island.bulimov.islandMap.Island;
import ru.javarush.island.bulimov.settings.Config;
import ru.javarush.island.bulimov.view.ConsoleView;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class GameWorker extends Thread{
    private final Game game = new Game(new Island(Config.COLUMN, Config.LINE), AnimalsFactory.getAnimals(), new ConsoleView());
    public static final int CORE_POOL_SIZE = 16;




    @Override
    public void run(){
        game.getIsland().createMap();
        game.getView().viewShow();

        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        List<OrganismWorker> workers = game
                .getAnimalsFactory()
                .values()
                .stream()
                .map(organism -> new OrganismWorker(organism, game.getIsland()))
                .collect(Collectors.toList());

        mainPool.scheduleWithFixedDelay(() -> runWorkers(game.getView(), workers), Config.PERIOD, Config.PERIOD, TimeUnit.MILLISECONDS);

    }
    private void runWorkers(ConsoleView view , List<OrganismWorker> workers) {
        ExecutorService servicePool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        workers.forEach(servicePool::submit);
        servicePool.shutdown();
        awaitPool(view, servicePool);

    }
    private void awaitPool(ConsoleView view, ExecutorService servicePool) {
        try{
            if (servicePool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)) {
                view.viewShow();
            }
        }
        catch (InterruptedException e) {
            throw new IslandRunException("Wait error "+e);
        }

    }
}
