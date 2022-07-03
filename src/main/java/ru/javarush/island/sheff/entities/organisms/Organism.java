package ru.javarush.island.sheff.entities.organisms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.javarush.island.sheff.entities.abstraction.behavior.Breeding;
import ru.javarush.island.sheff.util.Randomizer;

import java.util.Set;

@Getter
@AllArgsConstructor
public abstract class Organism implements Breeding {

    protected int id;
    protected int steps;
    protected String name;
    protected double weight;
    protected boolean femaleGender;
    protected boolean canBreed;
    protected boolean dead;
    protected Limit limit;
    protected Location location;

    public Organism() {
    }

    public Organism(Organism other) {
        this();
        id = ++other.id;
        limit = other.getLimit();
        steps = limit.getMaxSpeed();
        name = other.getName();
        weight = other.getWeight();
        femaleGender = Randomizer.getChance(50);
        canBreed = femaleGender;
        dead = false;
        location = new Location(other.getLocation());
    }

    public abstract Organism copy();

    public abstract Set<Organism> spawn();

    public abstract void endTurn();

    public double wasEatenBy(double weight) {
        this.weight = this.weight - weight;
        return weight;
    }

    public boolean isKilled(boolean chance) {
        return isDead() ? isDead() : (dead = chance);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " №" + id + " {" +
                "HashCode=" + this.hashCode() +
                ", steps=" + steps +
                ", location=" + location +
                ", name=\"" + name + '\"' +
                ", weight=" + weight +
                ", femaleGender=" + femaleGender +
                ", limit=" + limit +
                '}';
    }
}
