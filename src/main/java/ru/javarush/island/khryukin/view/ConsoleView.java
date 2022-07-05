package ru.javarush.island.khryukin.view;

import ru.javarush.island.khryukin.entity.map.Cell;
import ru.javarush.island.khryukin.entity.map.GameMap;
import ru.javarush.island.khryukin.entity.organisms.Organism;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleView implements View{
    private final GameMap gameMap;
    private final int positions = 5;
    private final String border = "═".repeat(positions);

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    @Override
    public String showStatistics() {
        Cell[][] cells = gameMap.getCells();
        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<String, Set<Organism>> residents = cell.getResidents();
                residents.values().stream()
                        .filter(s->s.size()>0)
                        .forEach(s->map.put(s.stream().findAny().get().getIcon(),s.size()));
                System.out.print(map);
                map.clear();
            }
            System.out.println();
        }
        return map.toString();
    }

    public String showGeneralStatistics(){
        Map<String, Integer> statistics = new HashMap<>();
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                var residents = cell.getResidents();
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
        Cell[][] cells = gameMap.getCells();
        final int cols = gameMap.getCols();
        final int rows = gameMap.getRows();
        int oneCellWidth = positions + 1;
        int width = oneCellWidth * cols + 2;
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
                //TODO --- Code style. Need always delete code. Not comment it.
                //.map(list -> list.stream().findAny().get().getIcon())
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private String line(int cols, char left, char center, char right) {
        return (IntStream.range(0, cols)
                .mapToObj(col -> (col == 0 ? left : center) + border)
                .collect(Collectors.joining("", "", String.valueOf(right))));
    }
}
