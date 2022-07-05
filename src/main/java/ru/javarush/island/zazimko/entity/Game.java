package ru.javarush.island.zazimko.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.javarush.island.zazimko.entity.map.GameMap;
import ru.javarush.island.zazimko.repository.Factory;
import ru.javarush.island.zazimko.view.View;

@Getter
@RequiredArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final Factory entityFactory;
    private final View view;

}
