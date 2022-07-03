package sheff;

import ru.javarush.island.sheff.repository.Settings;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static ru.javarush.island.sheff.repository.Settings.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class SettingsTests {

    private static final String PATH = "/sheff/config.properties";
    private static Properties properties;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        properties = new Properties();
        properties.load(Settings.class.getResourceAsStream(PATH));
    }

    @Test
    void settingsTest() {

        assertInstanceOf(Integer.class, ROWS.getValue());
        assertInstanceOf(Integer.class, COLS.getValue());
        assertInstanceOf(Integer.class, DEFAULT.getValue());
        assertInstanceOf(Integer.class, START.getValue());
        assertInstanceOf(Integer.class, DURATION.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_BEAR.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_BOA.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_BOAR.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_BUFFALO.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_CATERPILLAR.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_DEER.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_DUCK.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_EAGLE.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_FOX.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_GOAT.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_HORSE.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_MOUSE.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_PLANT.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_RABBIT.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_SHEEP.getValue());
        assertInstanceOf(Integer.class, COUNT_OF_WOLF.getValue());

        assertInstanceOf(String.class, properties.get("rows"));
        assertInstanceOf(String.class, properties.get("cols"));
        assertInstanceOf(String.class, properties.get("default"));
        assertInstanceOf(String.class, properties.get("start"));
        assertInstanceOf(String.class, properties.get("duration"));
        assertInstanceOf(String.class, properties.get("bear"));
        assertInstanceOf(String.class, properties.get("boa"));
        assertInstanceOf(String.class, properties.get("boar"));
        assertInstanceOf(String.class, properties.get("buffalo"));
        assertInstanceOf(String.class, properties.get("caterpillar"));
        assertInstanceOf(String.class, properties.get("deer"));
        assertInstanceOf(String.class, properties.get("duck"));
        assertInstanceOf(String.class, properties.get("eagle"));
        assertInstanceOf(String.class, properties.get("fox"));
        assertInstanceOf(String.class, properties.get("goat"));
        assertInstanceOf(String.class, properties.get("horse"));
        assertInstanceOf(String.class, properties.get("mouse"));
        assertInstanceOf(String.class, properties.get("plant"));
        assertInstanceOf(String.class, properties.get("rabbit"));
        assertInstanceOf(String.class, properties.get("sheep"));
        assertInstanceOf(String.class, properties.get("wolf"));
    }
}
