package ru.javarush.island.aleev.entity.organism;

import ru.javarush.island.aleev.parameters.Parameters;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Organismes {
    private final Set<Organism> organismes = new LinkedHashSet<>();
    private Parameters parameters;

    //    public void addAll(Set<Organism> newOrganism){
//        organismes.addAll(newOrganism);
//    }
    public void add(Organism organism) {
        organismes.add(organism);
    }

    //    public boolean add(Organism organism){
//       return organismes.add(organism);
//    }
    public boolean contains(Organism organism) {
        return organismes.contains(organism);
    }

    public void remove(Organism organism) {
        organismes.remove(organism);
    }

    public int size() {
        return organismes.size();
    }

//    TODO
//    public double calculateSize(){
//        int size = organismes.size();
//
//        return size;
//    }

    public String getIcon() {
        return parameters.getIcon();
    }

    public Parameters getParameters() {
        return parameters;
    }


    public Stream<Organism> stream() {
        return organismes.stream();
    }
}
