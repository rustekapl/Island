package ru.javarush.island.aleev.entity.organism.animals.carnivores;


import ru.javarush.island.aleev.cotstants.OrganismType;
import ru.javarush.island.aleev.entity.organism.Organism;
import ru.javarush.island.aleev.entity.organism.animals.Animal;
import ru.javarush.island.aleev.parameters.GameParameters;
import ru.javarush.island.aleev.parameters.Parameters;
import ru.javarush.island.aleev.utils.Randomizer;

import java.util.Iterator;
import java.util.Set;

public abstract class Carnivore extends Animal {

    public Carnivore(Parameters parameters) {
        super(parameters);
    }


    public void eat(Set<Organism> herbivores){
        int randomNum;
        Iterator<Organism> iterator= herbivores.iterator();
        while (iterator.hasNext()){
            Organism organism= iterator.next();
            randomNum= Randomizer.get(0,10);
            int currentChanceToEat = GameParameters
                    .getInstance()
                    .getChanceToEat()[OrganismType
                    .valueOf(this.getClass()
                            .getSimpleName()
                            .toUpperCase())
                    .ordinal()][OrganismType.valueOf(organism.getClass().getSimpleName().toUpperCase()).ordinal()];
            if(randomNum<currentChanceToEat){
                iterator.remove();
            }
        }
    }



    public void move() {
        //TODO --- ????
    }

    @Override
    public void reproduct() {
        //TODO ---  ????
    }

}
