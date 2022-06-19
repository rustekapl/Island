package com.javarush.island.khmelov.view;

import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.map.GameMap;
import com.javarush.island.khmelov.entity.organizms.Organism;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ConsoleView implements View {

    private static class Color {

        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

    }

    private final GameMap gameMap;
    private final int positions = 7;
    private final String border = "═".repeat(positions);

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    @Override
    public String showStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<Type, Set<Organism>> residents = cell.getResidents();
                if (Objects.nonNull(residents)) {
                    residents.values().stream()
                            .filter(set -> set.size() > 0)
                            .forEach(set -> {
                                        String icon = set.stream().findAny().get().getIcon();
                                        statistics.put(icon, statistics.getOrDefault(icon, 0) + set.size());
                                    }
                            );
                }
            }
        }
        System.out.println(statistics + "\n");
        return statistics.toString();
    }

    @Override
    public String showMap() {
        StringBuilder out = new StringBuilder("\n");
        Cell[][] cells = gameMap.getCells();
        final int cols = gameMap.getCols();
        final int rows = gameMap.getRows();
        for (int row = 0; row < rows; row++) {
            out.append(row == 0
                    ? line(cols, '╔', '╦', '╗')
                    : line(cols, '╠', '╬', '╣')
            ).append("\n");
            for (int col = 0; col < cols; col++) {
                String residentSting = get(cells[row][col]);
                out.append(String.format("║%-" + positions + "s", residentSting)).append(Color.RESET);
            }
            out.append('║').append("\n");
        }
        out.append(line(cols, '╚', '╩', '╝'));
        System.out.println(out);
        return out.toString();
    }

    private String get(Cell cell) {
        cell.getLock().lock();
        String collect = cell.getResidents().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
//                .limit(2)
//                .map(o->o.stream().findAny().get().getLetter()+o.size())
//                .collect(Collectors.joining());
                .limit(positions)
                .map(list -> {
                    Organism organism = list.stream().findAny().get();
                    int maxCount = organism.getLimit().getMaxCount();
                    String color = list.size() == maxCount
                            ? Color.BLACK
                            : list.size() > maxCount * 3 / 4
                            ? Color.BLUE
                            : list.size() > maxCount / 2
                            ? Color.GREEN
                            : list.size() > maxCount / 4
                            ? Color.YELLOW
                            : Color.RED;
                    return color + organism.getLetter();
                })
                .map(Object::toString)
                .collect(Collectors.joining());
        long count = cell.getResidents().values().stream()
                .filter((list) -> list.size() > 0).limit(positions).count();
        String blank = count < positions ? ".".repeat((int) (positions - count)) : "";
        cell.getLock().unlock();
        return collect + blank;
    }

    private String line(int cols, char left, char center, char right) {
        return (IntStream.range(0, cols)
                .mapToObj(col -> (col == 0 ? left : center) + border)
                .collect(Collectors.joining("", "", String.valueOf(right))));
    }
}
