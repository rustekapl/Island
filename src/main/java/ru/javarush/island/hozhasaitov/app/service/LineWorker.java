package ru.javarush.island.hozhasaitov.app.service;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.island.hozhasaitov.app.entity.map.Cell;
import ru.javarush.island.hozhasaitov.app.util.AppendEukaryotesToSet;
import ru.javarush.island.hozhasaitov.app.util.ImplementationConduct;

import java.util.HashSet;
import java.util.Set;

public class LineWorker implements Runnable {

    private final Cell[] lineMap;

    public LineWorker(Cell[] lineMap) {
        this.lineMap = lineMap;
    }


    @Override
    public void run() {
        Set<Eukaryote> eukaryotes = new HashSet<>();
        AppendEukaryotesToSet.append(lineMap, eukaryotes);
        ImplementationConduct.invokMethods(eukaryotes);
    }

}
