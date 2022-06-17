package com.javarush.island.khmelov.services;

import com.javarush.island.khmelov.entity.Game;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class GameWorker extends Thread {
    public static final int PERIOD = 500;
    private final Game game;

    @Override
    public void run() {
        game.getView().showMap();
        game.getView().showStatistics();
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);

        List<OrganismWorker> workers = game.getEntityFactory().getAllPrototypes()
                .stream()
                .map(o -> new OrganismWorker(o, game.getGameMap()))
                .toList();
        mainPool.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(4);
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                    synchronized (System.out) {
                        System.out.println("\n".repeat(30));
                        game.getView().showMap();
                        game.getView().showStatistics();
                        System.out.flush();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS); //TODO need config
    }
}
