package com.javarush.island.khmelov.entity.tasks;

import com.javarush.island.khmelov.entity.map.Cell;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public class Task {

    private final Cell cell;
    private final Consumer<Cell> operation;

    public void run() {
        Task task = this;
        Lock lock = task.cell.getLock();
        if (lock.tryLock()) {
            try {
                operation.accept(task.cell);
            } finally {
                lock.unlock();
            }
        }
    }
}
