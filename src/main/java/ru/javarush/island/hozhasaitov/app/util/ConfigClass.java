package ru.javarush.island.hozhasaitov.app.util;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.island.hozhasaitov.app.constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

public class ConfigClass implements Serializable {

    public static ConfigClass CONFIG_CLASS = readJSON();


    private String nameApp;
    private int sizeXfield;
    private int sizeYfield;

    private ConfigClass() {

    }

    public static ConfigClass getInstance() {

        return CONFIG_CLASS;
    }

    @Serial
    public Object readResolve() {
        return CONFIG_CLASS;
    }

    private static ConfigClass readJSON() {
        try (FileInputStream fileInputStream = new FileInputStream(Constants.PATH_CONFIG)) {
            ObjectMapper mapper = new ObjectMapper(new JsonFactory());
            return mapper.readValue(fileInputStream, ConfigClass.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNameApp() {
        return nameApp;
    }

    public int getSizeXfield() {
        return sizeXfield;
    }

    public int getSizeYfield() {
        return sizeYfield;
    }

    @Override
    public String toString() {
        return "ConfigClass{" +
                "nameApp='" + nameApp + '\'' +
                ", sizeXfield=" + sizeXfield +
                ", sizeYfield=" + sizeYfield +
                '}';
    }
}
