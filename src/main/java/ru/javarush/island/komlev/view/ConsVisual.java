package ru.javarush.island.komlev.view;

import ru.javarush.island.komlev.etnity.map.Cell;
import ru.javarush.island.komlev.etnity.map.GameMap;
import ru.javarush.island.komlev.etnity.organizms.Organism;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsVisual implements View {
    private final GameMap gameMap;
    private final int positions = 3;
    private final String border = "=".repeat(positions);

    public ConsVisual(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public String showStatistics() {
        Cell[][] cells = gameMap.getCells();
        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                var residents = cell.getResidents();
                if (Objects.nonNull(residents)) {
                    for (Set<Organism> set : residents.values()) {
                        if (set.size() > 0) {
                            String icon = set.stream().findAny().get().getIcon();
                            map.put(icon, map.getOrDefault(icon, 0) + set.size());
                        }
                    }
                }
            }
        }
        System.out.println(map + "\n");
        return map.toString();
    }


    @Override
    public String showMap() {
        Cell[][] cells = gameMap.getCells();
        final int cols = gameMap.getCols();
        final int rows = gameMap.getRows();

        StringBuilder out = new StringBuilder();
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
        out.append(line(cols, '╚', '╩', '╝')).append("\n");
        System.out.println(out);
        return out.toString();
    }

    private String get(Cell cell) {
        return cell.getResidents().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .limit(positions)
                .map(list -> list.stream().findAny().get().getClass().getSimpleName().substring(0, 1))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private String line(int cols, char left, char center, char right) {
        return (IntStream.range(0, cols)
                .mapToObj(col -> (col == 0 ? left : center) + border)
                .collect(Collectors.joining("", "", String.valueOf(right))));
    }

}
