package ru.javarush.island.zazimko.view;

import ru.javarush.island.zazimko.classes.animals.Organism;
import ru.javarush.island.zazimko.gameField.Cell;
import ru.javarush.island.zazimko.gameField.Field;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@SuppressWarnings("FieldCanBeLocal")
public class ConsoleView implements View {


    private final Field field;

    public ConsoleView(Field field) {
        this.field = field;

    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public void showStatistics() {
        Map<String, Double> rawStatistics = new HashMap<>();
        Map<String, Long> statistics = new HashMap<>();
        Cell[][] cells = field.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                ConcurrentHashMap<Type, Set<Organism>> organisms = cell.getOrganisms();
                if (Objects.nonNull(organisms)) {
                    for (Map.Entry<Type, Set<Organism>> pair : organisms.entrySet()) {
                        Set<Organism> animalSet = pair.getValue();
                        if (animalSet.size() > 0) {
                            animalSet
                                    .forEach(organisms1 -> {
                                                String icon = organisms1.getIcon();
                                                double count = animalSet.size();
                                                rawStatistics.put(icon, rawStatistics.getOrDefault(icon, 0D) + count);
                                            }
                                    );
                        }
                    }
                }
                rawStatistics.forEach((key, value) -> statistics.put(key, Math.round(value)));
                System.out.println(statistics + "\n");

            }
        }
        statistics.toString();
    }
}

