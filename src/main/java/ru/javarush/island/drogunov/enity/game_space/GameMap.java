package ru.javarush.island.drogunov.enity.game_space;


import ru.javarush.island.drogunov.Constants;
import ru.javarush.island.drogunov.enity.TargetGameUnit;
import ru.javarush.island.drogunov.enity.game_unit.GameUnit;
import ru.javarush.island.drogunov.enity.game_unit.plants.Plant;
import ru.javarush.island.drogunov.exceptions.UnitTargetNotFoundException;
import ru.javarush.island.drogunov.util.Statistics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameMap {
    private final Cell[][] space;

    public GameMap(GameSettings gameSettings) {
        int width = gameSettings.getWidth();
        int length = gameSettings.getLength();
        space = new Cell[width][length];
    }

    public int getCountLine() {
        return space.length;
    }

    public int getCountColum() {
        return space[0].length;
    }

    public Cell[][] getSpace() {
        return space;
    }

    public Set<GameUnit> getSetUnits() {
        Set<GameUnit> setUnitsOnGameMap = new HashSet<>();
        Arrays.stream(space).forEach(lines -> Arrays.stream(lines).forEach(cell -> cell.getUnitsMap().values().forEach(setUnitsOnGameMap::addAll)));
        return setUnitsOnGameMap;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(space);
    }

    public boolean isFinished() {
        return getSetUnits().stream().allMatch(gameUnit -> gameUnit instanceof Plant) || Statistics.getCountDays() == GameSettings.getGameTimeDays();
    }

//TODO в targetUnits хранится вероятность съедания, но согласно ООП как я его понимаю, GameMap
//    не может знать о вероятности съедания так как это бизнес логика,
//    Вопрос: Откуда мне нужно было вернуть цифру вероятности для Task, так как она необходима в ней
//    Как раз в Task я стараюсь разместить всю бизнес логику?
//    Вероятный ответ: GameMap может знать о типах Юнитов или тянуть вероятность съедания с настроек?

    public TargetGameUnit getTarget(GameUnit eater, Cell cell) {
        Map<Class<?>, Integer> targetUnits = Constants.PROBABILITY_EATING.get(eater.getClass());

        for (var pair : targetUnits.entrySet()) {
            String simpleName = pair.getKey().getSimpleName();
            Integer probability = pair.getValue();

            GameUnit target = cell.getTarget(simpleName);
            if (target != null) {
                return new TargetGameUnit(target, probability);
            }
        }
        throw new UnitTargetNotFoundException("Target not found");
    }

}
