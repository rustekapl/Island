package ru.javarush.island.stepanov.settings;

import lombok.Getter;
import lombok.ToString;
import ru.javarush.island.stepanov.utils.Decerializer;

import java.io.Serializable;
import java.util.Map;

@Getter
@ToString
public class GlobalSettings implements Serializable {

    private static volatile GlobalSettings instance;
    //TODO Code style. Many warnings. Skip or fix it.
    private int countPeriods;
    private Map<String, Integer> locationSize;
    private Map<String, String> creaturesIncluded;
    private Map<String, CreatureGeneralSettings> creatureGeneralSettingsMap;

    public static GlobalSettings getInstance(){
        if (instance != null){
            return instance;
        }
        synchronized (GlobalSettings.class){
            instance = new GlobalSettings();
            return instance;
        }
    }

    public static void importFromJsonString(String jsonString){
        GlobalSettings.instance = Decerializer.decerializeFromJsonString(jsonString, GlobalSettings.class);
    }

    public Integer getLocationWidth(){
        return this.locationSize.get("LOCATION_WIDTH");
    }

    public Integer getLocationHeight(){
        return this.locationSize.get("LOCATION_HEIGHT");
    }

}
