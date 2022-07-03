package ru.javarush.island.drogunov.enity.game_unit.animals;

import ru.javarush.island.drogunov.enity.game_space.Cell;
import ru.javarush.island.drogunov.enity.game_unit.GameUnit;
import ru.javarush.island.drogunov.enity.game_unit.Limits;
import ru.javarush.island.drogunov.interfaces.Eating;
import ru.javarush.island.drogunov.interfaces.Walkable;
import ru.javarush.island.drogunov.util.Randomizer;


public abstract class Animal extends GameUnit implements Walkable, Eating {

    private static final double APPROVE_ERROR = 0.05;

    public Animal(String name, String icon, Limits limits) {
        super(name, icon, limits);
        super.satiety = Randomizer.getRandom(limits.getMaxSatiety());
    }

    //TODO Coding. Russian text?? Ok. My opinion: 我想很多人都很難閱讀。
    @Override
    public void eat(GameUnit target) {
        //TODO А есть ли тут необходимость в BigDecimal???
        // Комментарии оставлены специально
        //TODO ---  нет. вес неточный. были бы деньги - тогда да.
//        BigDecimal weightTargetUnit = new BigDecimal(target.getWeight());
//        BigDecimal neededSatiety = new BigDecimal(this.satiety - limits.getMaxSatiety());
//        BigDecimal result = weightTargetUnit.subtract(neededSatiety);
        //TODO и внутри класса лучше как обратятся\записывать через Getter\Setter??
        // Это поля этого класса но родителя
        // вполне ок
        double maxSatiety = this.limits.getMaxSatiety();
        double neededSatiety = this.satiety - maxSatiety;
        double weightTarget = target.getWeight();
        double result = neededSatiety + weightTarget;
        //TODO вот погрешность можно было бы обработать тут или обработать в сеттере
        //TODO ---  логику лучше не в сеттерах. тут ок
        plusSatiety(result > 0 ? neededSatiety : weightTarget);

    }

    private void plusSatiety(double plus) {
        double error = satiety * APPROVE_ERROR;
        double result = satiety + plus;
        double maxSatiety = limits.getMaxSatiety();
        satiety = (result - maxSatiety <= error) ? maxSatiety : result;
    }

    public boolean isFullSatiety() {
        return this.satiety >= limits.getMaxSatiety();
    }

    @Override
    public boolean multiply(Cell cell) {
        if (satiety < 0) {
            saveDie(cell);
            return false;
        }
        cell.lockCell();
        try {
            if (cell.isMaxPopulation(this)) {
                GameUnit partner = cell.getPair(this);
                if (partner != null) {
                    GameUnit clone = partner.clone(this);
                    cell.getUnitsMap().get(getType()).add(clone);
                    return true;
                }
            }
        } finally {
            cell.unlockCell();
        }
        return false;
    }

    @Override
    public boolean walk(Cell cell) {
        cell.lockCell();
        try {
            cell.getUnitsMap().get(getType()).remove(this);
        } finally {
            cell.unlockCell();
        }

        Cell nextCell = cell.getNextCell(this.getLimits().getMaxSteps());
        if (satiety < 0) {
            saveDie(cell);
            return false;
        }

        nextCell.lockCell();
        try {
            nextCell.getUnitsMap().get(getType()).add(this);
        } finally {
            nextCell.unlockCell();
        }
        return true;
    }
}
