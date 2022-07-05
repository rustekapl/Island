package ru.javarush.island.sheff.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ru.javarush.island.sheff.exception.InitGameException;
import ru.javarush.island.sheff.repository.OrganismTypes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonParser {
    //TODO ---  private???
    Gson gson = new Gson();
    JsonObject jsonObject;

    public JsonParser(File file) {

        try (FileReader reader = new FileReader(file)) {
            jsonObject = gson.fromJson(reader, JsonObject.class);

        } catch (IOException e) {
            throw new InitGameException("Unable to load " + file + " file from classpath.", e);
        }

    }

    public <T> T getObject(OrganismTypes organismTypes) {
        return gson.fromJson(jsonObject.getAsJsonObject(organismTypes.getName().toLowerCase()), organismTypes.getType());
    }
}
