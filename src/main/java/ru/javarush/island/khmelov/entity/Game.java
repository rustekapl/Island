package ru.javarush.island.khmelov.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.javarush.island.khmelov.entity.map.GameMap;
import ru.javarush.island.khmelov.repository.Factory;
import ru.javarush.island.khmelov.view.View;

@Getter
@RequiredArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final Factory entityFactory;
    private final View view;

}
