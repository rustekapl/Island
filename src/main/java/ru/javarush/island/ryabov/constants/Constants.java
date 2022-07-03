package ru.javarush.island.ryabov.constants;

import ru.javarush.island.ryabov.abstraction.EntityScanner;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.util.ClassFinder;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Constants {
    public static final int ROWS = 2;
    public static final int COLS = 2;

    public static final List<Class<?>> TYPES = ClassFinder.find("ru.javarush.island.ryabov.entity.organisms.organism");
    public static final Organism[] ORGANISMS = EntityScanner.createPrototypes(TYPES);

    public static final ForkJoinPool POOLS = new ForkJoinPool();
}
