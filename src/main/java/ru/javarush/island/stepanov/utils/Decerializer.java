package ru.javarush.island.stepanov.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.javarush.island.stepanov.exceptions.IslandAppException;

public class Decerializer {

    private Decerializer() {
    }

    public static <T> T decerializeFromJsonString(String jsonString, Class<T> outputClass){

        ObjectMapper mapper = configureMapper();

        try {
            return mapper.readValue(jsonString, outputClass);
        } catch (JsonProcessingException e) {
            throw new IslandAppException("Exception while decerializing from JsonString: " + e.getMessage());
        }
    }

    private static ObjectMapper configureMapper(){

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        return mapper;
    }

}
