package ru.javarush.island.synckevich.game;

import ru.javarush.island.synckevich.entities.Entity;
import ru.javarush.island.synckevich.enums.EntityType;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameStats {
    private final GameField field;

    public GameStats(GameField field) {
        this.field = field;
    }

    public Runnable createShowStatsTask() {
        return () -> this.printStats(this.collectStats());
    }

    private Map<String, Integer> collectStats() {
        Map<String, Integer> entitiesStats = new ConcurrentHashMap<>();

        for (int y = 0; y < this.field.getHeight(); ++y) {

            for (int x = 0; x < this.field.getWidth(); ++x) {
                Cell cell = this.field.getCells()[y][x];
                List<Entity> entities = cell.getEntities();

                for (Entity entity : entities) {
                    String entityAsString = entity.getClass().getSimpleName();
                    String entityAsImage = EntityType.valueOf(entityAsString.toUpperCase()).getUnicodeSymbol();

                    if (!entitiesStats.containsKey(entityAsImage)) {
                        entitiesStats.put(entityAsImage, 1);
                    } else {
                        entitiesStats.put(entityAsImage, entitiesStats.get(entityAsImage) + 1);
                    }
                }
            }
        }

        return entitiesStats;
    }

    private void printStats(Map<String, Integer> entitiesStatistics) {
        System.out.println(MessageFormat.format("\n*** Day {0}-th ***",
                GameController.DAY_NUMBER.get()));
        System.out.println();
        entitiesStatistics.forEach((key, value) ->
                System.out.println(MessageFormat.format("{0} - {1}", key, value)));
        System.out.println("\n");
    }
}
