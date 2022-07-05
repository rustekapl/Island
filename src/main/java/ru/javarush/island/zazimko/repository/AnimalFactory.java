package ru.javarush.island.zazimko.repository;

import ru.javarush.island.zazimko.config.Setting;
import ru.javarush.island.zazimko.entity.map.Cell;
import ru.javarush.island.zazimko.entity.map.Residents;
import ru.javarush.island.zazimko.entity.organizms.Organism;
import ru.javarush.island.zazimko.entity.organizms.Organisms;
import ru.javarush.island.zazimko.util.Randoms;

import java.util.Arrays;
import java.util.List;

public class AnimalFactory implements Factory {
    //TODO Coding. Need move to config or settings
    public static final int PERCENT_FILL = 33;

    @Override
    public Cell createRandomCell(boolean empty) {
        Cell cell = new Cell();
        Residents residents = cell.getResidents();
        boolean fill = Randoms.get(PERCENT_FILL);
        if (fill && !empty) {
            for (Organism prototype : Setting.PROTOTYPES) {
                String type = prototype.getType();
                Organisms organisms = residents.get(type);
                int currentCount = organisms.size();
                int max = prototype.getLimit().getMaxCountInCell() - currentCount;
                int count = Randoms.random(0, max);
                for (int i = 0; i < count; i++) {
                    organisms.add(Organism.clone(prototype));
                }
            }
        }

        return cell;
    }

    @Override
    public List<Organism> getAllPrototypes() {
        return Arrays.asList(Setting.PROTOTYPES);
    }

    @Override
    public String toString() {
        return "EntityFactory{" +
                "prototypes=" + Arrays.toString(Setting.PROTOTYPES) +
                '}';
    }
}
