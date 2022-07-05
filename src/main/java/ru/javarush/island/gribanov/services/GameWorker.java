package ru.javarush.island.gribanov.services;



import ru.javarush.island.gribanov.entity.Game;
import ru.javarush.island.gribanov.utils.Configuration;
import ru.javarush.island.gribanov.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class GameWorker extends Thread {
    private final Game game;
    private final int PERIOD = Configuration.get().getPeriod();

    public GameWorker(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        View view = game.getView();
        view.showMap();
        view.showStatistics();
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(8);

        List<OrganismWorker> workers = Arrays.stream(Configuration.get()
                .getPrototypes()).toList()
                .stream()
                .map(o -> new OrganismWorker(o, game.getGameMap()))
                .toList();
        mainPool.scheduleAtFixedRate(() -> {
            //TODO Coding. Magic values or methods. Bad reading and understanding
            ExecutorService servicePool = Executors.newFixedThreadPool(8);
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            try {
                if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                        view.showMap();
                        view.showStatistics();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);
    }
}
