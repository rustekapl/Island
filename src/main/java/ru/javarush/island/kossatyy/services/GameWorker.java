package ru.javarush.island.kossatyy.services;

import lombok.RequiredArgsConstructor;
import ru.javarush.island.kossatyy.entity.Game;
import ru.javarush.island.kossatyy.settings.Config;
import ru.javarush.island.kossatyy.view.View;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GameWorker extends Thread {
    private final Game game;
    private final int PERIOD = Config.getConfig().getPERIOD();

    @Override
    public void run() {
        View view = game.getView();
        view.showMap();
        view.showStatistics();
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);
        int countCreatures = game.getEntityFactory().getAlfaSquad().size();
        Phaser phaser = new Phaser();

        List<CreatureWorker> workers = game
                .getEntityFactory()
                .getAlfaSquad()
                .values()
                .stream()
                .map(creature -> new CreatureWorker(creature, game.getIsland(), phaser))
                .collect(Collectors.toList());
        mainPool.scheduleAtFixedRate(() -> {
            ExecutorService servicePool = Executors.newFixedThreadPool(4);
            workers.forEach(servicePool::submit);
            servicePool.shutdown();
            //TODO Code style. Needs reformat or extraction to methods / variables / constants
            await(view, servicePool);
        }, PERIOD, PERIOD, TimeUnit.MILLISECONDS);
    }

    private void await(View view, ExecutorService servicePool) {
        try {
            if (servicePool.awaitTermination(PERIOD, TimeUnit.MILLISECONDS)) {
                view.showMap();
                view.showStatistics();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
