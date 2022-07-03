package ru.javarush.island.sheff.repository;

import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.map.GameMap;
import ru.javarush.island.sheff.util.Randomizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.javarush.island.sheff.repository.Settings.*;

public record GameMapCreator(OrganismFactory organismFactory) {

    public GameMap createRandomStartGameMapFromSettings() {
        return createRandomStartGameMap(ROWS.getValue(), COLS.getValue(), START.getValue(), true);
    }

    public GameMap createRandomStartGameMap(int rows, int cols, int startingQuantity, boolean isGenerateAdditionalOrganisms) {

        GameMap gameMap = new GameMap(rows, cols, organismFactory);
        gameMap.initialize();

        Cell[][] cells = gameMap.getCells();
        //TODO Code style. Long code. Needs to be split into several methods
        Arrays.stream(OrganismTypes.values()).forEach(organismTypes -> {
            cells[Randomizer.getZeroToBound(rows)][Randomizer.getZeroToBound(cols)]
                    .getResidents()
                    .get(organismTypes.getName())
                    .addAll(Stream.generate(() -> organismFactory.getNewOrganism(organismTypes))
                            .limit(Integer.min(startingQuantity, organismFactory.getPrototypeOrganismLimit(organismTypes).getMaxCount()))
                            .collect(Collectors.toSet()));

            if (isGenerateAdditionalOrganisms) {
                Stream.generate(() -> organismFactory.getNewOrganism(organismTypes))
                        .limit(valueOf("COUNT_OF_" + organismTypes.getName().toUpperCase())
                                .getValue() - Integer.min(startingQuantity, organismFactory.getPrototypeOrganismLimit(organismTypes).getMaxCount()))
                        .forEach(organisms -> {
                            Cell[] arr = Arrays.stream(cells)
                                    .flatMap(Arrays::stream)
                                    .filter(cell -> cell.getResidents()
                                            .get(organismTypes.getName()).size() < organisms.getLimit().getMaxCount())
                                    .toArray(Cell[]::new);

                            if (arr.length > 0) {
                                arr[Randomizer.getZeroToBound(arr.length)]
                                        .getResidents()
                                        .get(organismTypes.getName())
                                        .add(organisms);
                            }
                        });
            }
        });

        Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .forEach(cell -> cell.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .forEach(organism -> {
                            organism.getLocation().setRow(cell.getRow());
                            organism.getLocation().setCol(cell.getCol());
                        }));

        return gameMap;
    }
}
