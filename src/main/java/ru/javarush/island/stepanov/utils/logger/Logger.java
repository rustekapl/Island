package ru.javarush.island.stepanov.utils.logger;

import lombok.Getter;
import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.location.LocationCell;
import ru.javarush.island.stepanov.utils.FileWriter;
import ru.javarush.island.stepanov.utils.StatisticsCollector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static LoggerLevel level = LoggerLevel.GENERALIZED;
    private static String separator = " ";
    private static String arrow = " --> ";
    private static String bracketOpen = "[";
    private static String bracketClose = "]";
    private static String frameOpen = "\n***********************************";
    private static String frameClosed = "***********************************\n";

    @Getter
    private static final LogContainer logContainer = new LogContainer();

    private Logger(){}

    public static void dumpLogToFile(){
        FileWriter.writeFile(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "_runlog.txt",
                Logger.getLogContainer().getLog()
        );
    }

    public static void logStatistics(Location location){
        String statistics = StatisticsCollector.returnGeneralizedStatistics(location);
        System.out.println(statistics);
        logContainer.writeLog(frameOpen);
        logContainer.writeLog(statistics);
        logContainer.writeLog(frameClosed);
    }

    public static void logEvent(LifeCycleStages stage, Creature subject, LocationCell cell, String message) {
        if (Logger.level == LoggerLevel.EVENT) {
            String eventInfo = bracketOpen + subject.getName() + separator + cell.getCoordinate() + bracketClose;
            String nowDTTM = bracketOpen + LocalDateTime.now().toString() + bracketClose;
            message = bracketOpen + message + bracketClose;

            String outputMsg = String.format(
                    "%26s %45s %10s %s",
                    nowDTTM, eventInfo, stage.name(), message
            );

            logContainer.writeLog(outputMsg);
        }
    }

    public static void logEvent(LifeCycleStages stage, Creature subject, Creature object, LocationCell cell, String message) {
        if (Logger.level == LoggerLevel.EVENT) {
            String eventInfo = bracketOpen + subject.getName() + arrow + object.getName() + separator + cell.getCoordinate() + bracketClose;
            String nowDTTM = bracketOpen + LocalDateTime.now() + bracketClose;
            message = bracketOpen + message + bracketClose;

            String outputMsg = String.format(
                    "%26s %45s %10s %s",
                    nowDTTM, eventInfo, stage.name(), message
            );

            logContainer.writeLog(outputMsg);
        }
    }

    public static void logEvent(LifeCycleStages stage, Creature subject, LocationCell cell, LocationCell cellTo, String message) {
        if (Logger.level == LoggerLevel.EVENT) {
            String eventInfo = bracketOpen + subject.getName() + separator + separator + cell.getCoordinate() + arrow + cellTo.getCoordinate() + bracketClose;
            String nowDTTM = bracketOpen + LocalDateTime.now() + bracketClose;
            message = bracketOpen + message + bracketClose;

            String outputMsg = String.format(
                    "%26s %45s %10s %s",
                    nowDTTM, eventInfo, stage.name(), message
            );

            logContainer.writeLog(outputMsg);
        }
    }
}
