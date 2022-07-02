package ru.javarush.island.hozhasaitov.app.util;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.Plant;
import ru.javarush.island.hozhasaitov.app.interfaces.HerbivorousAnimal;
import ru.javarush.island.hozhasaitov.app.interfaces.PredatoryAnimal;

import java.util.Set;

public class ImplementationConduct {
    private ImplementationConduct() {
    }

    public static void invokMethods(Set<Eukaryote> eukaryotes) {

        for (Eukaryote eukaryote : eukaryotes) {
            if (eukaryote instanceof PredatoryAnimal predatoryAnimal) {
                predatoryAnimal.move(predatoryAnimal.searchPrey());
                predatoryAnimal.eat();
                predatoryAnimal.spawn();
                predatoryAnimal.die();
            } else if (eukaryote instanceof HerbivorousAnimal herbivorousAnimal) {
                herbivorousAnimal.move(herbivorousAnimal.searchPrey());
                herbivorousAnimal.eat();
                herbivorousAnimal.spawn();
                herbivorousAnimal.die();
            } else if (eukaryote instanceof Plant plant) {
                plant.spawn();

            }
        }
    }
}
