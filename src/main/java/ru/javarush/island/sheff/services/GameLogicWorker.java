package ru.javarush.island.sheff.services;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.map.GameMap;
import ru.javarush.island.sheff.entities.organisms.Organism;
import ru.javarush.island.sheff.entities.organisms.animals.predators.Predator;
import ru.javarush.island.sheff.entities.organisms.plants.Plant;
import ru.javarush.island.sheff.exception.InitGameException;
import ru.javarush.island.sheff.repository.OrganismTypes;
import ru.javarush.island.sheff.services.tasks.*;
import ru.javarush.island.sheff.view.SimulatorView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameLogicWorker extends Thread {

    private final SimulatorView simulatorView;
    private final GameMap gameMap;
    private final ConcurrentMap<Integer, Cell[]> rows = new ConcurrentHashMap<>();
    private final List<Task> movingAnimalsTasks = new ArrayList<>();
    private List<Task> callEatTasks;
    private List<Task> callSpawnTasks;
    private List<Task> callSelectOfDirectionTasks;
    private List<Task> callEndTurnTasks;
    private int transferCount;
    private int day;
    private String statistics;
    private boolean isWorking;

    ListeningExecutorService executorService;

    public GameLogicWorker(SimulatorView simulatorView, GameMap gameMap) {
        this.simulatorView = simulatorView;
        this.gameMap = gameMap;
    }

    public void initialize() {
        this.transferCount = gameMap.getTransferCount();
        IntStream.range(0, gameMap.getCells().length).forEach(i -> rows.put(i, gameMap.getCells()[i]));
        statistics = getStatistics();
        simulatorView.startView(gameMap, statistics);

        callEatTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallEatTask callEatTask = new CallEatTask(rows.get(i));
            callEatTasks.add(callEatTask);
        }
        callSpawnTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallSpawnTask callSpawnTask = new CallSpawnTask(rows.get(i));
            callSpawnTasks.add(callSpawnTask);
        }
        callSelectOfDirectionTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallSelectOfDirectionTask callSelectOfDirectionTask = new CallSelectOfDirectionTask(rows.get(i));
            callSelectOfDirectionTasks.add(callSelectOfDirectionTask);
        }
        callEndTurnTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallEndTurnTask callEndTurnTask = new CallEndTurnTask(rows.get(i));
            callEndTurnTasks.add(callEndTurnTask);
        }
        isWorking = true;
    }

    @Override
    public void run() {
        if (isWorking) {
            try {
                runTasks(callEatTasks);
                runTasks(callSpawnTasks);

                for (int i = 0; i < transferCount; i++) {
                    runTasks(callSelectOfDirectionTasks);

                    ConcurrentMap<Integer, HashSet<Organism>> organisms = gameMap.getAllOrganismsMap();
                    movingAnimalsTasks.clear();
                    for (int j = 0; j < gameMap.getCells().length; j++) {
                        MovingAnimalsTask movingAnimalsTask = new MovingAnimalsTask(rows.get(j), organisms.get(j));
                        movingAnimalsTasks.add(movingAnimalsTask);
                    }

                    runTasks(movingAnimalsTasks);
                    gameMap.updateCells();
                    simulatorView.updateView(day, statistics);
                }

                runTasks(callEndTurnTasks);
                statistics = getStatistics();
                isWorking = checkPredators();

            } catch (InterruptedException | ExecutionException e) {
                throw new InitGameException("Problem with multithreading " + e);
            }
        }
    }

    private void runTasks(List<Task> tasks) throws InterruptedException, ExecutionException {
        executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(rows.size()));
        List<Future<Boolean>> futures = executorService.invokeAll(tasks);
        for (Future<Boolean> future : futures) {
            future.get();
            if (!future.isDone()) {
                isWorking = false;
                System.out.println("false");
            }
        }
    }

    private boolean checkPredators() {
        if (gameMap.getAllOrganismsSet()
                .stream()
                .parallel()
                .filter(organism -> (organism instanceof Predator))
                .anyMatch(organism -> !organism.isDead())) {
            simulatorView.updateView(day++, statistics);
            return true;
        } else {
            simulatorView.getMessage("All predators are dead");
            System.out.println("All predators are dead");
            return false;
        }
    }

    private String getStatistics() {
        return gameMap.getAllOrganismsSet()
                .stream()
                .parallel()
                .filter(organism -> !(organism instanceof Plant))
                .collect(Collectors.toConcurrentMap(Organism::getName, s -> 1, Integer::sum))
                .entrySet()
                .stream()
                .map((entry) -> OrganismTypes.valueOf(entry.getKey().toUpperCase()).getIcon()
                        + " " + OrganismTypes.valueOf(entry.getKey().toUpperCase()).getName()
                        + ": " + entry.getValue())
                .collect(Collectors.joining(", "))
                + OrganismTypes.PLANT.getIcon()
                + " " + OrganismTypes.PLANT.getName()
                + ": " + gameMap.getAllOrganismsSet()
                .stream()
                .filter(organism -> organism instanceof Plant)
                .mapToDouble(Organism::getWeight).sum();
    }
}

