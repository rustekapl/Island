package sheff;

import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.map.GameMap;
import ru.javarush.island.sheff.entities.organisms.Organism;
import ru.javarush.island.sheff.repository.GameMapCreator;
import ru.javarush.island.sheff.repository.OrganismFactory;
import ru.javarush.island.sheff.repository.OrganismFactorySingleton;
import ru.javarush.island.sheff.repository.OrganismTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static ru.javarush.island.sheff.repository.OrganismTypes.*;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrganismTests {

    private OrganismFactory organismFactory;

    @BeforeEach
    void setUp() {
        organismFactory = OrganismFactorySingleton.INSTANCE;
        GameMapCreator gameMapCreator = new GameMapCreator(organismFactory);
        GameMap gameMap = gameMapCreator.createRandomStartGameMap(1, 1, 2, false);
        Cell[][] cells = gameMap.getCells();
        Cell currentCell = cells[0][0];
        Map<String, HashSet<Organism>> residents = currentCell.getResidents();
    }

    @Test
    void creatingEachOrganismTest() {

        Map<String, HashSet<Organism>> organisms = Map.ofEntries(
                entry ("Bear", new HashSet<>(List.of(organismFactory.getNewOrganism(BEAR)))),
                entry ("Boa", new HashSet<>(List.of(organismFactory.getNewOrganism(BOA)))),
                entry ("Boar", new HashSet<>(List.of(organismFactory.getNewOrganism(BOAR)))),
                entry ("Buffalo", new HashSet<>(List.of(organismFactory.getNewOrganism(BUFFALO)))),
                entry ("Caterpillar", new HashSet<>(List.of(organismFactory.getNewOrganism(CATERPILLAR)))),
                entry ("Deer", new HashSet<>(List.of(organismFactory.getNewOrganism(DEER)))),
                entry ("Duck", new HashSet<>(List.of(organismFactory.getNewOrganism(DUCK)))),
                entry ("Eagle", new HashSet<>(List.of(organismFactory.getNewOrganism(EAGLE)))),
                entry ("Fox", new HashSet<>(List.of(organismFactory.getNewOrganism(FOX)))),
                entry ("Goat", new HashSet<>(List.of(organismFactory.getNewOrganism(GOAT)))),
                entry ("Horse", new HashSet<>(List.of(organismFactory.getNewOrganism(HORSE)))),
                entry ("Mouse", new HashSet<>(List.of(organismFactory.getNewOrganism(MOUSE)))),
                entry ("Plant", new HashSet<>(List.of(organismFactory.getNewOrganism(PLANT)))),
                entry ("Rabbit", new HashSet<>(List.of(organismFactory.getNewOrganism(RABBIT)))),
                entry ("Sheep", new HashSet<>(List.of(organismFactory.getNewOrganism(SHEEP)))),
                entry ("Wolf", new HashSet<>(List.of(organismFactory.getNewOrganism(WOLF)))));

        assertEquals(16, organisms.size());
        organisms.forEach((key, value) -> {
            assertTrue(value.stream().findFirst().isPresent());
            assertEquals(value.stream().findFirst().get().getClass(), OrganismTypes.valueOf(key.toUpperCase()).getType());
        });
    }
}
