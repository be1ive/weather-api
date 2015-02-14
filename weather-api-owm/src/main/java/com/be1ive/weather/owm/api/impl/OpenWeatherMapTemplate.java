package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.OpenWeatherMap;
import com.be1ive.weather.owm.api.impl.json.OpenWeatherMapModule;
import com.be1ive.weather.AbstractApiConfigurations;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class OpenWeatherMapTemplate extends AbstractApiConfigurations implements OpenWeatherMap {

    private CurrentWeatherOperations currentWeatherOperations;

    private ObjectMapper objectMapper;

    public OpenWeatherMapTemplate() {
        initialize();
    }

    public OpenWeatherMapTemplate(String accessToken) {
        super(accessToken);
        initialize();
    }

    @Override
    public CurrentWeatherOperations currentWeatherOperations() {
        return currentWeatherOperations;
    }

    @Override
    public <T> List<T> fetchObjects(String objectName, Class<T> type, Map<String, String> queryParameters) {
        JsonNode jsonNode = getRestTemplate().getForObject(OPEN_API_URL, JsonNode.class, queryParameters);
        return list(type, jsonNode);
    }

    private <T> List<T> list(Class<T> type, JsonNode jsonNode) {
        List<T> data = deserializeDataList(jsonNode.get("data"), type);
        return new ArrayList<>(data);
    }

    private <T> List<T> deserializeDataList(JsonNode jsonNode, final Class<T> elementType) {
        try {
            CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, elementType);
            return (List<T>) objectMapper.reader(listType).readValue(jsonNode.toString());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new OpenWeatherMapModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    private void initialize() {
        initOperations();
    }

    private void initOperations() {
        currentWeatherOperations = new CurrentWeatherOperationsTemplate(this, getRestTemplate());
    }
}
