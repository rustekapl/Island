package ru.javarush.island.komlev.services;

import ru.javarush.island.komlev.etnity.Game;
import ru.javarush.island.komlev.etnity.organizms.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {
    public static final int PERIOD = 1000;
    private final Game game;

    @Override
    public void run() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        List<OrganismWorker> workers = new ArrayList<>();
        for (Organism germ : game.getEntityFactory().getAllPrototypes()) {
            OrganismWorker orgWorker = new OrganismWorker(germ, game.getGameMap());
            workers.add(orgWorker);
        }
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ExecutorService servicePool = Executors.newFixedThreadPool(4);
                for (OrganismWorker worker : workers) {
                    servicePool.submit(worker);
                }
                servicePool.shutdown();
                try {
                    if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                        game.getView().showMap();
                        game.getView().showStatistics();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);
    }

    public GameWorker(Game game) {
        this.game = game;


    }
}