package ru.javarush.island.sheff.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.javarush.island.sheff.entities.map.GameMap;
import ru.javarush.island.sheff.repository.OrganismFactory;
import ru.javarush.island.sheff.services.Scheduler;
import ru.javarush.island.sheff.view.SimulatorView;

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
