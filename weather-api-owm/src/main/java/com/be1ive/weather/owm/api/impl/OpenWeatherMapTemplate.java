package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.OpenWeatherMap;
import com.be1ive.weather.owm.api.ParametrisedList;
import com.be1ive.weather.owm.api.impl.json.OpenWeatherMapModule;
import com.be1ive.weather.AbstractApiConfigurations;
import com.be1ive.weather.support.URIBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        super(OWM_AUTH_PARAM, accessToken);
        initialize();
    }

    @Override
    public CurrentWeatherOperations currentWeatherOperations() {
        return currentWeatherOperations;
    }

    @Override
    public <T> T fetchObject(String objectName, Class<T> type, MultiValueMap<String, String> queryParameters) {
        URI uri = URIBuilder.fromUri(OWM_API_URL + "/" + objectName).queryParams(queryParameters).build();
        return getRestTemplate().getForObject(uri, type);
    }

    @Override
    public <T> ParametrisedList<T> fetchObjects(String objectName, Class<T> type, MultiValueMap<String, String> queryParameters) {
        URI uri = URIBuilder.fromUri(OWM_API_URL + "/" + objectName).queryParams(queryParameters).build();
        JsonNode jsonNode = getRestTemplate().getForObject(uri, JsonNode.class);
        return list(type, jsonNode);
    }

    private <T> ParametrisedList<T> list(Class<T> type, JsonNode jsonNode) {
        List<T> list = deserializeList(jsonNode.get("list"), type);
        Map<String, String> params = new HashMap<>();
        for (Iterator<Map.Entry<String, JsonNode>> itr = jsonNode.fields(); itr.hasNext();) {
            Map.Entry<String, JsonNode> entry = itr.next();
            if (!entry.getKey().equals("list")) {
                params.put(entry.getKey(), entry.getValue().asText());
            }
        }
        return new ParametrisedList<T>(list, params);
    }

    private <T> List<T> deserializeList(JsonNode jsonNode, final Class<T> elementType) {
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
