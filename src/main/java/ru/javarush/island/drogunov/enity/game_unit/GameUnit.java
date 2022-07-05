package ru.javarush.island.drogunov.enity.game_unit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.javarush.island.drogunov.enity.game_space.Cell;
import ru.javarush.island.drogunov.exceptions.CloneUnitException;
import ru.javarush.island.drogunov.interfaces.Multiple;
import ru.javarush.island.drogunov.util.Randomizer;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@EqualsAndHashCode(of = "id")
public abstract class GameUnit implements Cloneable, Multiple {

    private static final AtomicLong indicator = new AtomicLong(System.currentTimeMillis());
    private long id = indicator.incrementAndGet();
    private final String type = this.getClass().getSimpleName();
    private final String name;
    private final String icon;
    private AtomicBoolean access = new AtomicBoolean(true);

    protected Lock lock = new ReentrantLock(true);

    protected volatile double satiety;

    protected double weight;
    protected Limits limits;

    public GameUnit(String name, String icon, Limits limits) {
        this.name = name;
        this.icon = icon;
        this.limits = limits;
        this.weight = Randomizer.getRandom(limits.getMaxWeight());
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return (name + " " + icon);
        //TODO Вопрос тут вместо конкатенации лучше было бы использовать StringBuilder??
    }


    @Override
    public boolean multiply(Cell cell) {
//        System.out.println("размножился " + name + Thread.currentThread().getName());
//        if (this instanceof Plant) {
        cell.lockCell();
        try {
            if (cell.isMaxPopulation(this)) {
                GameUnit clone = this.clone(this);
                cell.getUnitsMap().get(getType()).add(clone);
                return true;
            }
        } finally {
            cell.unlockCell();
        }
        return false;
    }

    @Override
    protected GameUnit clone() throws CloneNotSupportedException {
        GameUnit clone = (GameUnit) super.clone();
        clone.id = indicator.incrementAndGet();
        clone.weight = Randomizer.getRandom(limits.getMaxWeight());
        clone.satiety = Randomizer.getRandom(limits.getMaxSatiety());
        clone.setAccess(true);
        return clone;
    }

    @SuppressWarnings("unchecked")
    public <T extends GameUnit> T clone(T unit) {
        try {
            return (T) unit.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneUnitException("don't cloned", e);
        }
    }

    @SuppressWarnings("SameReturnValue")
    public void saveDie(Cell cell) {
        cell.lockCell();
        try {
            Set<GameUnit> set = cell.getUnitsMap().get(this.getType());
            set.remove(this);
        } finally {
            cell.unlockCell();
        }
    }

    //TODO Non-atomic operation on volatile field
    // Я так понимаю при обращении к переменной помеченной volatile c метода это действие не атомарно?
    public void subtractionSatiety(double subtract) {
        satiety -= subtract;
    }

    public boolean isAccess() {
        return access.getPlain();
    }

    public void setAccess(boolean set) {
        access.set(set);
    }


    public synchronized GameUnit saveGet() {
//        access.compareAndExchangeAcquire(true, false);
        access.compareAndExchange(true, false);
        //Помню что это грязно блокировать в одном месте, а разблокировать в другом.

        return this;
    }

}
