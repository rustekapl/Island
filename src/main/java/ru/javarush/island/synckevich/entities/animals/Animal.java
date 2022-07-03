package ru.javarush.island.synckevich.entities.animals;

import ru.javarush.island.synckevich.entities.Entity;
import ru.javarush.island.synckevich.enums.Action;
import ru.javarush.island.synckevich.enums.Direction;
import ru.javarush.island.synckevich.game.Randomizer;

public abstract class Animal extends Entity {
    private int speed;
    private double hungryPoints;
    private double healthPoints;

    public double getHealthPoints() {
        return this.healthPoints;
    }

    public int getSpeed() {
        return this.speed;
    }

    public double getHungryPoints() {
        return this.hungryPoints;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setMaxOnCell(int maxOnCell) {
        this.maxOnCell = maxOnCell;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    protected void setHungryPoints(double hungryPoints) {
        this.hungryPoints = hungryPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public abstract boolean eat(Entity entity);

    public abstract Animal reproduce();

    public Direction chooseDirection() {
        return Direction.values()[(Randomizer.get(Direction.values().length))];
    }

    public Action chooseAction() {
        Action action = Action.values()[Randomizer.get(Action.values().length)];
        boolean isActionFlag = Randomizer.get(100) < action.getActionChanceIndex();
        return isActionFlag ? action : Action.SLEEP;
    }
}
