package ru.javarush.ivanov.island.entities.territory;

public class Island {
    private final Square[][] islandTerritory;

    public Square[][] getIslandTerritory() {
        return islandTerritory;
    }

    public Island(Square[][] islandTerritory) {
        this.islandTerritory = islandTerritory;
    }

}
