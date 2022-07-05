package ru.javarush.island.zazimko.entity.map;


import ru.javarush.island.zazimko.entity.organizms.Organisms;
import ru.javarush.island.zazimko.util.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Residents extends LinkedHashMap<String, Organisms> {
    private static final int PERCENT_RANDOM_ROTATE = 1;

    private final Cell cell;

    public Residents(Cell cell) {
        this.cell = cell;
    }

    private void checkNull(Object key) {
        this.putIfAbsent(key.toString(), new Organisms());
    }

    @Override
    public Organisms get(Object key) {
        checkNull(key);
        return super.get(key);
    }

    @Override
    public Organisms put(String key, Organisms value) {
        checkNull(key);
        return super.put(key, value);
    }

    public void randomRotateResidents() {
        if (size() > 1 && Randoms.get(PERCENT_RANDOM_ROTATE)) {
            cell.getLock().lock();
            try {
                Set<Map.Entry<String, Organisms>> entrySet = entrySet();
                var iterator = entrySet.iterator();
                var organisms = iterator.next();
                iterator.remove();
                put(organisms.getKey(), organisms.getValue());
            } finally {
                cell.getLock().unlock();
            }
        }
    }
}
