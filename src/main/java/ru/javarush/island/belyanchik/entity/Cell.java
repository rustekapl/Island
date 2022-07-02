package ru.javarush.island.belyanchik.entity;

import ru.javarush.island.belyanchik.enums.IslandParam;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final int col;
    private final int row;
    //TODO Code style. Many warnings. Skip or fix it.
    private QueueOrganism organisms;
    private int layerIndex;
    private final Lock lock = new ReentrantLock(true);


    public Cell(int x, int y, QueueOrganism organisms, int layerIndex) {
        this.col = x;
        this.row = y;
        this.organisms = organisms;
        this.layerIndex = layerIndex;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "col=" + col +
                ", row=" + row +
                ", layerIndex=" + layerIndex +
                '}';
    }

    public Lock getLock() {
        return lock;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public QueueOrganism getOrganisms() {
        return organisms;
    }

    public int getLayerIndex() {
        return layerIndex;
    }

    public Object getMonitor() {
        return this;
    }

    public int createInOneCell(String threadName, String emoji, String typeName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = IslandParam.classes[this.layerIndex];
        //int amount = Randomizer.get(0, this.getmaxPositionsToAdd());
        int amount = this.getmaxPositionsToAdd();
        for (int n = 0; n < amount; n++) {
            this.addNewOrganismInQueue(clazz);
        }
/*
        if (amount > 0) {
            System.out.println("Нить " + threadName + " обрабатывает ячейку " + this.col + ", " + this.row + " добавлено: " +
                    emoji + " " + typeName + " - " + amount + " шт.");
        }
*/
        return amount;
    }

    // Посчитать оставшуюся ёмкость очереди ячейки
    public int getmaxPositionsToAdd() {
        // максимально допустимое число организмов в ячейке для данного класса
        int maxNumberInCell = IslandParam.MAX_NUMBER_IN_CELL[this.layerIndex];
        // сколько ещё можно добавить организмов до максимального заполнения очереди
        int maxPositionsToAdd = maxNumberInCell - this.organisms.getDeque().size();
        return maxPositionsToAdd;
    }

    // добавить новый организм сласса clazz  в очередь ячейки
    public void addNewOrganismInQueue(Class clazz) {
        try {
            Class[] params = {int.class, int.class, boolean.class};
            this.organisms.add(clazz.getConstructor(params).newInstance(this.row, this.col, false));
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

