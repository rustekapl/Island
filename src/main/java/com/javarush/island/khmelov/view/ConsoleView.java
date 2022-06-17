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
                                        statistics.put(icon, statistics.getOrDefault(icon,0) + set.size());
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
        Cell[][] cells = gameMap.getCells();
        final int cols = gameMap.getCols();
        final int rows = gameMap.getRows();
        int oneCellWidth = positions + 1;
        int width = oneCellWidth * cols + 2;
        StringBuilder out = new StringBuilder("\n");
        for (int row = 0; row < rows; row++) {
            out.append(row == 0
                    ? line(cols, '╔', '╦', '╗')
                    : line(cols, '╠', '╬', '╣')
            ).append("\n");
            for (int col = 0; col < cols; col++) {
                String residentSting = get(cells[row][col]);
                out.append(String.format("║%-" + positions + "s", residentSting));
            }
            out.append('║').append("\n");
        }
        out.append(line(cols, '╚', '╩', '╝'));
        System.out.println(out);
        return out.toString();
    }

    private String get(Cell cell) {
        return cell.getResidents().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .limit(2)
                .map(o->o.stream().findAny().get().getLetter()+o.size())
                .collect(Collectors.joining());
//                .limit(positions)
//                .map(list -> list.stream().findAny().get().getClass().getSimpleName().substring(0, 1))
//                .map(Object::toString)
//                .collect(Collectors.joining());
    }

    private String line(int cols, char left, char center, char right) {
        return (IntStream.range(0, cols)
                .mapToObj(col -> (col == 0 ? left : center) + border)
                .collect(Collectors.joining("", "", String.valueOf(right))));
    }
}
