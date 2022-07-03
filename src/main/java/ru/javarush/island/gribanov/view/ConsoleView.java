package ru.javarush.island.gribanov.view;

import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.entity.lives.animals.herbivores.Herbivore;
import ru.javarush.island.gribanov.entity.lives.animals.predators.Predator;
import ru.javarush.island.gribanov.entity.map.Cell;
import ru.javarush.island.gribanov.entity.map.GameMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ConsoleView implements View {

   public static class Color {

        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";


        public static final String FILL_GREEN = "\u001B[42m";
        public static final String FILL_YELLOW = "\u001B[43m";
        public static final String FILL_ORANGE = "\u001B[01;48;05;173m";
        public static final String FILL_CYAN = "\u001B[46m";

        private static final String[] Scale = {
                BLACK, BLUE, PURPLE, RED
        };


        public static String getColor(int size, int maxCount) {
            if (size > maxCount) {
                return Color.FILL_CYAN;
            }
            int index = Scale.length - 1 - (Scale.length * size) / (maxCount + 1);
            return Scale[index];
        }
    }

    private final GameMap gameMap;

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    @Override
    public String showStatistics() {
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
        printLegend();
        StringBuilder out = new StringBuilder("\n");
        Cell[][] cells = gameMap.getCells();
        final int cols = gameMap.WIDTH;
        final int rows = gameMap.HEIGHT;
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                String residentSting = get(cells[row][col]);
                int cellWidth = 4;
                out.append(String.format("║%-" + cellWidth + "s", residentSting));
            }
            out.append('║').append("\n");
        }
        System.out.println(out);
        return out.toString();
    }

    private void printLegend() {
        System.out.println("LEGEND:");
        System.out.println("Plant: " + Color.FILL_GREEN + " " + Color.RESET + " - >80%, "
                + Color.FILL_ORANGE + " " + Color.RESET + " - >50%, "
                + Color.FILL_YELLOW + " " + Color.RESET + " - >0%");
        System.out.println("Animals: " + Color.BLACK + "\uD83D\uDC3A|\uD83D\uDC07" + Color.RESET + " - >75%, "
                + Color.BLUE + "\uD83D\uDC3A|\uD83D\uDC07" + Color.RESET + " - >50%, "
                + Color.PURPLE + "\uD83D\uDC3A|\uD83D\uDC07" + Color.RESET + " - >25%"
                + Color.RED + "\uD83D\uDC3A|\uD83D\uDC07" + Color.RESET + " - >0%");
    }

    private String get(Cell cell) {
        int[] plantsCount = getPlantCount(cell);
        MaxCountAnimal herbivoreMaxCount = getMaxAnimalCount(cell, Herbivore.class);
        MaxCountAnimal predatorMaxCount = getMaxAnimalCount(cell, Predator.class);
        String colorPlant;
        if (plantsCount[0] == 0) {
            colorPlant = "";
        } else if (plantsCount[0] > 0 && plantsCount[0] <= plantsCount[1] *0.5) {
            colorPlant = Color.FILL_YELLOW;
        } else if (plantsCount[0] > 0 && plantsCount[0] <= plantsCount[1] *0.8) {
            colorPlant = Color.FILL_ORANGE;
        } else {
            colorPlant = Color.FILL_GREEN;
        }
        return colorPlant + predatorMaxCount.getIcon() + "|" + herbivoreMaxCount.getIcon() + Color.RESET;
    }

    private MaxCountAnimal getMaxAnimalCount(Cell cell, Class<?> clazz) {
        cell.getLock().lock();
        MaxCountAnimal maxCountAnimal = cell.getResidents().values().stream()
                .filter((list) -> list.size() > 0)
                .filter((list) -> clazz.isAssignableFrom(list.iterator().next().getClass()))
                .sorted((o1, o2) -> o2.size() - o1.size())
                .limit(1)
                .map(list -> {
                    MaxCountAnimal maxAnimal = new MaxCountAnimal("  ", 0);
                    Organism organism = list.stream().findAny().orElseThrow();
                    int maxCount = organism.getLimit().getCOUNT_ON_CELL();
                    String color = Color.getColor(list.size(), maxCount);
                    String animalIcon =  color + organism.getIcon();
                    maxAnimal.setIcon(animalIcon);
                    maxAnimal.setCount(list.size());
                    return maxAnimal;})
                .findAny().orElseGet(MaxCountAnimal::new);
        cell.getLock().unlock();
        return maxCountAnimal;
    }

    private int[] getPlantCount (Cell cell){
        cell.getLock().lock();
        int maxCount = 0;
        Set<Organism> plants = cell.getResidents().get("Plant");
        int count = plants.size();
        if (count > 0){
            maxCount = plants
                    .stream()
                    .findAny()
                    .get()
                    .getLimit()
                    .getCOUNT_ON_CELL();
        }
        cell.getLock().unlock();
        return new int[]{count, maxCount};
    }
}
