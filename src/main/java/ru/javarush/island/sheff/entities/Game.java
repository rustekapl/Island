package ru.javarush.island.sheff.entities;

import ru.javarush.island.sheff.entities.map.GameMap;
import ru.javarush.island.sheff.repository.OrganismFactory;
import ru.javarush.island.sheff.services.Scheduler;
import ru.javarush.island.sheff.view.SimulatorView;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final OrganismFactory organismFactory;
    private final SimulatorView simulatorView;
    private final Scheduler scheduler;

    public void startGame() {
        scheduler.start();
    }
}
