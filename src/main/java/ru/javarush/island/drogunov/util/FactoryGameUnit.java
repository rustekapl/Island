package ru.javarush.island.drogunov.util;

import ru.javarush.island.drogunov.Constants;
import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_space.Cell;
import ru.javarush.island.drogunov.enity.game_unit.GameUnit;
import ru.javarush.island.drogunov.enity.game_unit.Limits;
import ru.javarush.island.drogunov.exceptions.ClassNotInstanceException;
import ru.javarush.island.drogunov.exceptions.ConstructorNotFound;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FactoryGameUnit implements Factory {

    @Override
    public Cell createCell() {
        //TODO Code style. Long code. Needs to be split into several methods
        Cell cell = new Cell();
        Map<String, Set<GameUnit>> gameUnitList = cell.getUnitsMap();
        for (Class<?> unit : Constants.GAME_UNITS.keySet()) {
            Set<GameUnit> unitsOnCell = new HashSet<>();

            UnitSetting setting = unit.getDeclaredAnnotation(UnitSetting.class);
            String name = setting.name();
            String icon = setting.icon();
            double maxWeight = setting.weight();
            int maxPopulation = setting.maxPopulations();
            Limits limit = new Limits(maxWeight, maxPopulation, setting.maxSteps(), setting.satiety());

            Constructor<?> constructor;
            try {
                constructor = unit.getConstructor(String.class, String.class, Limits.class);
                GameUnit gameUnit = (GameUnit) constructor.newInstance(name, icon, limit);
                unitsOnCell.add(gameUnit);
                int randomInteger = Randomizer.getRandom(maxPopulation) - 1;
                for (int i = 0; i < randomInteger; i++) {
                    GameUnit clone = gameUnit.clone(gameUnit);
                    unitsOnCell.add(clone);
                }
            } catch (NoSuchMethodException e) {
                throw new ConstructorNotFound("Constructor not found", e);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new ClassNotInstanceException("Class not instance", e);
            }
            gameUnitList.put(unit.getSimpleName(), unitsOnCell);
        }
        return cell;
    }
}
