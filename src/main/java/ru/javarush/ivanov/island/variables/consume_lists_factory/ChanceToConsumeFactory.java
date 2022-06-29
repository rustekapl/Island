package ru.javarush.ivanov.island.variables.consume_lists_factory;

import ru.javarush.ivanov.island.variables.ListOfAnimalsAndHerbs;

public class ChanceToConsumeFactory {
    public static ChanceToConsumeList createConsumeList(ListOfAnimalsAndHerbs listOfAnimalsAndHerbs) {
        return switch (listOfAnimalsAndHerbs) {
            case BEAR -> new BearChanceToConsumeList();
            case BOAR -> new BoarChanceToConsumeList();
            case BUFFALO -> new BuffaloChanceToConsumeList();
            case CATERPILLAR -> new CaterpillarChanceToConsumeList();
            case DEER -> new DeerChanceToConsumeList();
            case DUCK -> new DuckChanceToConsumeList();
            case FOX -> new FoxChanceToConsumeList();
            case GOAT -> new GoatChanceToConsumeList();
            case HAWK -> new HawkChanceToConsumeList();
            case HERBS -> new HerbsChanceToConsumeList();
            case HORSE -> new HorseChanceToConsumeList();
            case RABBIT -> new RabbitChanceToConsumeList();
            case RAT -> new RatChanceToConsumeList();
            case SHEEP -> new SheepChanceToConsumeList();
            case SNAKE -> new SnakeChanceToConsumeList();
            case WOLF -> new WolfChanceToConsumeList();
        };
    }
}
