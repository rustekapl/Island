package ru.javarush.island.stepanov.controllers;

import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.registry.PrototypeRegistry;
import ru.javarush.island.stepanov.services.LocationWorker;
import ru.javarush.island.stepanov.settings.GlobalSettings;
import ru.javarush.island.stepanov.utils.FileReader;
import ru.javarush.island.stepanov.utils.RandomSpawner;
import ru.javarush.island.stepanov.utils.logger.Logger;
import ru.javarush.island.stepanov.utils.logger.LoggerLevel;

import java.util.Map;

public class SimulationController {

    public void startSimulation(String settingsFileName, String loggerLevel){

        this.setLoggerLevel(loggerLevel);
        
        GlobalSettings globalSettings = this.readSettings(settingsFileName);
        Location islandField = this.initLocation(globalSettings);
        PrototypeRegistry prototypeRegistry = initPrototypeRegistry(globalSettings);
        for (Creature prototype: prototypeRegistry.getAllPrototypes()) {
            RandomSpawner.spawnByRandomCoordinates(prototype, prototype.getSettings().getStartPopulation(), islandField);
        }

        LocationWorker locationWorker = new LocationWorker(islandField, prototypeRegistry, globalSettings);
        locationWorker.start();
    }

    private void setLoggerLevel(String inputLevel){
        Logger.level = LoggerLevel.valueOf(inputLevel);
    }

    private GlobalSettings readSettings(String settingsFileName){ //
        String jsonConfig = FileReader.readResourceToString(settingsFileName);
        GlobalSettings.importFromJsonString(jsonConfig);
        return GlobalSettings.getInstance();
    }

    private Location initLocation(GlobalSettings settings){
        return new Location(
                settings.getLocationWidth(),
                settings.getLocationHeight()
        );
    }

    private PrototypeRegistry initPrototypeRegistry(GlobalSettings settings){
        PrototypeRegistry prototypeRegistry = PrototypeRegistry.getInstance();
        for (Map.Entry<String, String> entry: settings.getCreaturesIncluded().entrySet()) {
            prototypeRegistry.createPrototype(entry.getValue());
        }
        return prototypeRegistry;
    }

}
