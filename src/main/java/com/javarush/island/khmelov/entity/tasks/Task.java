package com.javarush.island.khmelov.entity.tasks;

import com.javarush.island.khmelov.entity.map.Cell;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public class Task {

    private final Cell cell;
    private final Consumer<Cell> operation;
    private Task subTask;

    public Task andThen(Task nextTask) {
        Task last = this;
        while (Objects.nonNull(last.subTask)) {
            last = last.subTask;
        }
        last.subTask = nextTask;
        return this;
    }

    public void safeTodoTaskAndSubTasks() {
        Task task = this;
        do {
            task.cell.getLock().lock();
            try {
                operation.accept(task.cell);
            } finally {
                task.cell.getLock().unlock();
                task = subTask;
            }
        } while (Objects.nonNull(task));
    }
}
