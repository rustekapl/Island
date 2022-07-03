package ru.javarush.island.drogunov.services;

import ru.javarush.island.drogunov.enity.TargetGameUnit;
import ru.javarush.island.drogunov.enity.game_space.Cell;
import ru.javarush.island.drogunov.enity.game_space.GameMap;
import ru.javarush.island.drogunov.enity.game_unit.GameUnit;
import ru.javarush.island.drogunov.enity.game_unit.animals.Animal;
import ru.javarush.island.drogunov.exceptions.UnitTargetNotFoundException;
import ru.javarush.island.drogunov.util.Randomizer;
import ru.javarush.island.drogunov.util.Statistics;

public class Task {

    private final GameUnit gameUnit;
    private final Cell cell;
    private final GameMap gameMap;
    private final double decreaseForWalk;
    private final double decreaseForMultiply;


    public Task(GameUnit gameUnit, Cell cell, GameMap gameMap) {
        this.gameUnit = gameUnit;
        this.cell = cell;
        this.gameMap = gameMap;
        //TODO Coding. Magic values or methods. Bad reading and understanding
        decreaseForWalk = gameUnit.getLimits().getMaxSatiety() * 0.3;
        decreaseForMultiply = gameUnit.getLimits().getMaxSatiety() * 0.5;
    }

    public void toDo() {
        if (gameUnit instanceof Animal animal) {
            if (gameUnit.getSatiety() < 0) {
                gameUnit.saveDie(cell);
                //Statistics
                Statistics.incrementCountDeadOfHanger();
                return;
            }
            //TODO просьба дать оценку реализации метода taskEat согласно ООП
            //TODO Метод Eat реализован по другому чем walk and multiply.
            // старался сделать по ООП, То что передается Cell видел, не успел исправить, для этого необходимо делать
            // эффективный поиск Cell по GameUnit в GameMap

            //можно и так и эдак, но надо ОДНОТИПНО. Сложную логику всегда лучше в сервисы,
            // но у нас в задании есть условие про ООП в животных.
            taskEat(animal);
            animal.walk(cell);
            gameUnit.subtractionSatiety(decreaseForWalk);
        }
        gameUnit.multiply(cell);
        //Statistics
        Statistics.incrementCountMultiply();
        //Statistics
        gameUnit.subtractionSatiety(decreaseForMultiply);
    }

    private void taskEat(Animal eaterAnimal) {
        if (eaterAnimal.isFullSatiety()) {
            return;
        }
        do {
            try {
                TargetGameUnit target = gameMap.getTarget(gameUnit, cell);
                GameUnit targetUnit = target.getTargetUnit();
                int probability = target.getProbability();
                if (Randomizer.getResult(probability)) {
                    cell.kickGameUnit(targetUnit);
                    //<Statistics>
                    Statistics.incrementCountHaveBeenEaten();
                    //</Statistics>
                    eaterAnimal.eat(targetUnit);
                } else {
                    targetUnit.setAccess(true);
                }
            } catch (UnitTargetNotFoundException e) {
                gameUnit.setAccess(true);
                break;
                //TODO тут так понимаю логирование
            }
            //TODO Что лучше было бы рекурсия или то что сделано do\while
        } while (!eaterAnimal.isFullSatiety());
    }

}
