package ru.javarush.ivanov.island.entities.territory;

import ru.javarush.ivanov.island.entities.Creature;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Square {

    private Residents residents = new Residents();
    private Square[][] territory;
    private final int squareNumberWidth;
    private final int squareNumberHeight;
    private final Lock lock = new ReentrantLock(true);

    public Square(int squareNumberWidth, int squareNumberHeight) {
        this.squareNumberWidth = squareNumberWidth;
        this.squareNumberHeight = squareNumberHeight;
    }

    public int getSquareNumberWidth() {
        return squareNumberWidth;
    }

    public int getSquareNumberHeight() {
        return squareNumberHeight;
    }


    public Lock getLock() {
        return lock;
    }

    public Map<String, Set<Creature>> getResidents() {
        return residents;
    }

    public void setResidents(Residents residents) {
        this.residents = residents;
    }

    public Square[][] getTerritory() {
        return territory;
    }

    public void setTerritory(Square[][] territory) {
        this.territory = territory;
    }

    public boolean remove(Creature creature) {
        String simpleName = creature.getClass().getSimpleName();
        if (residents.containsKey(simpleName)) {
            residents.get(simpleName).remove(creature);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return squareNumberWidth == square.squareNumberWidth
                && squareNumberHeight == square.squareNumberHeight
                && Objects.equals(residents, square.residents)
                && Arrays.deepEquals(territory, square.territory)
                && Objects.equals(lock, square.lock);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(residents, squareNumberWidth, squareNumberHeight, lock);
        result = 31 * result + Arrays.deepHashCode(territory);
        return result;
    }
}
