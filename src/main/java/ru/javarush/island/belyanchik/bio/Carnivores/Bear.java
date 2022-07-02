package ru.javarush.island.belyanchik.bio.Carnivores;

import ru.javarush.island.belyanchik.abstraction.Animal;
import ru.javarush.island.belyanchik.annotations.OrganismParam;
import ru.javarush.island.belyanchik.enums.IslandParam;

@OrganismParam(typeName = "Медведь", emoji = "\uD83D\uDC3B", bioTypeCode = 14, weight = 500, maxNumberInCell = 5, speed = 2, kgFood = 80)
public class Bear extends Animal {
    public static final String emoji; //!!!
    public static final String typeName; //!!!
    public static final int bioTypeCode;
    public static final int maxNumberInCell; // максимальное количество в ячейке
    public static final int speed;
    public static int counter = 0; // счётчик всех созданных экземпляров класса
    public static final int[][] menu; // рацион (вид, вероятность, предел насыщения)/d


    static {
        Class cl = Bear.class;
        emoji = Animal.getEmoji(cl); //!!!
        typeName = Animal.getTypeName(cl); //!!!
        bioTypeCode = Animal.getBioTypeCode(cl);
        maxNumberInCell = Animal.getMaxNumberInCell(cl);
        speed = Animal.getSpeed(cl);
        menu = IslandParam.RACION_PARAM[bioTypeCode];
    }

    public Bear(int row, int col, boolean newBorn) {
        super(row, col, newBorn);
        this.weight = IslandParam.WEIGHT[bioTypeCode];
        this.kgFood = IslandParam.KG_FOOD[bioTypeCode];
        this.number = ++counter;
        this.name = emoji + " " + typeName + "_" + number;
    }

    // Вернуть счётчик объектов
    public static int getCounter() {
        return counter;
    }
}