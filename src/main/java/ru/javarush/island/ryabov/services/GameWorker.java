package ru.javarush.island.ryabov.services;

import lombok.SneakyThrows;
import ru.javarush.island.ryabov.config.Setting;
import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.Game;
import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.view.View;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {
    public static final int CORE_POOL_SIZE = Constants.POOLS.getParallelism();
    private final Game game;
    private final int PERIOD = Setting.get().getPeriod();

    private final GameMap gameMap;

    public GameWorker(Game game, GameMap gameMap) {
        this.game = game;
        this.gameMap = gameMap;
    }


    @Override
    public void run() {
        View view = game.getView();
        view.showStatistics();
        System.out.println("\n");

        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        List<OrganismWorker> workers = game
                .getEntityFactory()
                .getAllPrototypes()
                .stream()
                .map(o -> new OrganismWorker(game.getGameMap()))
                .toList();
        mainPool.scheduleWithFixedDelay(() -> runWorkers(view, workers)
                , PERIOD, PERIOD, TimeUnit.MILLISECONDS);
    }

    private void runWorkers(View view, List<OrganismWorker> workers) {
        ExecutorService servicePool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        workers.forEach(servicePool::submit);
        servicePool.shutdown();
        awaitPool(view, servicePool);
    }

    @SneakyThrows
    private void awaitPool(View view, ExecutorService servicePool) {
        if (servicePool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)) {
            view.showStatistics();
        }

    }
}