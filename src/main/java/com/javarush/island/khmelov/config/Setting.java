package com.javarush.island.khmelov.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.*;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter(AccessLevel.PROTECTED)
public class Setting {

    private static final Setting setting = new Setting();
    public static final String SETTING_YAML = "setting.yaml";

    public static Setting get() {
        return setting;
    }
    private int period;
    private int rows;
    private int cols;
    @Getter(AccessLevel.PROTECTED)
    private Map<String, Map<String, Integer>> foodMap = new LinkedHashMap<>();

    public Map<String, Integer> getFoodMap(String keyName) {
        this.foodMap.putIfAbsent(keyName, new LinkedHashMap<>());
        return foodMap.get(keyName);
    }

    private Setting() {
        loadFromDefault();
        updateFromYaml();
    }

    private void loadFromDefault() {
        period = 1000;
        rows=2;
        cols=2;
        for (int i = 0, n = Default.names.length; i < n; i++) {
            String key = Default.names[i];
            this.foodMap.putIfAbsent(key, new LinkedHashMap<>());
            for (int j = 0; j < n; j++) {
                int ratio = Default.setProbablyTable[i][j];
                if (ratio > 0) {
                    this.foodMap.get(key).put(Default.names[j], ratio);
                }
            }
        }
    }

    @SneakyThrows
    private void updateFromYaml() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ObjectReader readerForUpdating = mapper.readerForUpdating(this);
        URL resource = Setting.class.getClassLoader().getResource(SETTING_YAML);
        if (Objects.nonNull(resource)) {
            readerForUpdating.readValue(resource.openStream());
        }
    }

    @Override
    public String toString() {
        ObjectMapper yaml = new ObjectMapper(new YAMLFactory());
        yaml.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return yaml.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
