package ru.javarush.island.khmelov.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javarush.island.khmelov.entity.map.GameMap;
import ru.javarush.island.khmelov.repository.EntityFactory;
import ru.javarush.island.khmelov.repository.GameMapCreator;

class ConsoleViewTest {

    private ConsoleView consoleView;

    @BeforeEach
    private void setup() {
        GameMapCreator gameMapCreator = new GameMapCreator(new EntityFactory());
        GameMap map = gameMapCreator.createRandomFilledGameMap(4, 20);
        consoleView = new ConsoleView(map);
    }

    @Test
    void showMap() {
        String view = consoleView.showMap();
        String statistics = consoleView.showStatistics();
        Assertions.assertTrue(view.contains("╔"));
        Assertions.assertTrue(view.contains("\n╠"));
        Assertions.assertTrue(view.contains("\n╚") || view.contains("\n#"));
        Assertions.assertTrue(view.contains("╗\n") || view.contains("#\n"));
        Assertions.assertTrue(view.contains("╣\n") || view.contains("#\n"));
        Assertions.assertTrue(view.contains("╝") || view.contains("#\n"));
        Assertions.assertTrue(statistics.contains("{"));
        Assertions.assertTrue(statistics.contains("}"));
    }


}