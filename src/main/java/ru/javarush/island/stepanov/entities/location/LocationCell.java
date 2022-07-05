package ru.javarush.island.stepanov.entities.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.javarush.island.stepanov.entities.creatures.Creature;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
public class LocationCell {

    @EqualsAndHashCode.Include()
    @Setter
    private Coord coordinate;
    private final ReentrantLock lock = new ReentrantLock();
    private final ConcurrentHashMap<String, Set<Creature>> cellInhabitants = new ConcurrentHashMap<>(){
        @Override
        public Set<Creature> put(String key, Set<Creature> value) {
            this.putIfAbsent(key, new HashSet<>());
            return super.put(key, value);
        }
        @Override
        public Set<Creature> get(Object key) {
            this.putIfAbsent((String) key, new HashSet<>());
            return super.get(key);
        }
    };

    public LocationCell(Coord coordinate){
        this.coordinate = coordinate;
    }

    public boolean containsCreature(Creature creature){
        return cellInhabitants.get(creature.getClass().getSimpleName()).contains(creature);
    }

    public Set<Creature> getCreatures(String className){
        return cellInhabitants.get(className);
    }
}
