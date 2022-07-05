package ru.javarush.island.kossatyy.repository.factory;

import ru.javarush.island.kossatyy.entity.creatures.Creature;
import ru.javarush.island.kossatyy.entity.creatures.Group;
import ru.javarush.island.kossatyy.repository.factory.fauna.*;
import ru.javarush.island.kossatyy.repository.factory.flora.HerbFactory;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntityFactory implements Factory {

    private static EntityFactory FACTORY;

    private final Map<String, Factory> factoryMap;
    private final Map<String, Creature> prototypes;

    public EntityFactory() {
        factoryMap = createFactoryMap();
        prototypes = createPrototypes();
    }

    public static EntityFactory getFactory() {
        if (FACTORY == null){
            FACTORY = new EntityFactory();
        }
        return FACTORY;
    }

    public Map<String, Creature> getPrototypes() {
        return prototypes;
    }

    @Override
    public Creature create(String type) {
        Factory factory = factoryMap.get(type);
        Creature creature = factory.create(type);
        if (creature != null) {
            return creature;
        } else throw new IllegalArgumentException("Wrong type for creation - " + type);
    }

    private Map<String, Factory> createFactoryMap() {
        Map<String, Factory> factories = new LinkedHashMap<>(){{
            put(Group.WOLF.getType(), new WolfFactory());
            put(Group.SNAKE.getType(), new SnakeFactory());
            put(Group.FOX.getType(), new FoxFactory());
            put(Group.BEAR.getType(), new BearFactory());
            put(Group.EAGLE.getType(), new EagleFactory());
            put(Group.HORSE.getType(), new HorseFactory());
            put(Group.DEER.getType(), new DeerFactory());
            put(Group.RABBIT.getType(), new RabbitFactory());
            put(Group.MOUSE.getType(), new MouseFactory());
            put(Group.GOAT.getType(), new GoatFactory());
            put(Group.SHEEP.getType(), new SheepFactory());
            put(Group.BOAR.getType(), new BoarFactory());
            put(Group.BUFFALO.getType(), new BuffaloFactory());
            put(Group.DUCK.getType(), new DuckFactory());
            put(Group.CATERPILLAR.getType(), new CaterpillarFactory());
            put(Group.HERB.getType(), new HerbFactory());
        }};
        return Collections.unmodifiableMap(factories);
    }

    private Map<String, Creature> createPrototypes() {
        Map<String, Creature> result = new LinkedHashMap<>();

        for (Map.Entry<String, Factory> pair : factoryMap.entrySet()){
            String type = pair.getKey();
            Creature creature = pair.getValue().create(type);
            result.put(type, creature);
        }
        return Collections.unmodifiableMap(result);
    }

}
