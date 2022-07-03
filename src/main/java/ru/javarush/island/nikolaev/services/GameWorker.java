package ru.javarush.island.nikolaev.services;

import lombok.RequiredArgsConstructor;
import ru.javarush.island.nikolaev.entity.Game;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class GameWorker extends Thread {
    public static final int PERIOD = 100;
    public static final int THREADCOUNT = 4;
    private final Game game;

    @Override
    public void run() {
        ScheduledExecutorService mainPool = (ScheduledExecutorService) Executors.newScheduledThreadPool(THREADCOUNT);

        List<OrganismWorker> workers = game.getEntityFactory().getAllPrototypes()
                .stream()
                .map(p -> new OrganismWorker(p, game.getGameMap()))
                .toList();
        mainPool.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(THREADCOUNT);
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                    game.getView().showMap();
                    game.getView().showStatistics();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);
    }
}
