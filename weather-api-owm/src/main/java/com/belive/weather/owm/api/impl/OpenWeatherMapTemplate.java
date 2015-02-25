/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.belive.weather.owm.api.impl;

import com.belive.weather.AbstractApiConfigurations;
import com.belive.weather.owm.api.CurrentConditionsOperations;
import com.belive.weather.owm.api.DailyForecastOperations;
import com.belive.weather.owm.api.HourlyForecastOperations;
import com.belive.weather.owm.api.OpenWeatherMap;
import com.belive.weather.owm.api.OpenWeatherMapErrorHandler;
import com.belive.weather.owm.api.ParametrisedList;
import com.belive.weather.owm.api.impl.json.OpenWeatherMapModule;
import com.belive.weather.support.URIBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class OpenWeatherMapTemplate extends AbstractApiConfigurations implements OpenWeatherMap {

    private CurrentConditionsOperations currentConditionsOperations;
    private HourlyForecastOperations hourlyForecastOperations;
    private DailyForecastOperations dailyForecastOperations;

    private ObjectMapper objectMapper;

    public OpenWeatherMapTemplate() {
        initialize();
    }

    public OpenWeatherMapTemplate(String accessToken) {
        super(OWM_AUTH_PARAM, accessToken);
        initialize();
    }

    @Override
    public CurrentConditionsOperations currentConditionsOperations() {
        return currentConditionsOperations;
    }

    @Override
    public HourlyForecastOperations hourlyForecastOperations() {
        return hourlyForecastOperations;
    }

    @Override
    public DailyForecastOperations dailyForecastOperations() {
        return dailyForecastOperations;
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

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new OpenWeatherMapErrorHandler());
    }

    private void initialize() {
        initOperations();
    }

    private void initOperations() {
        currentConditionsOperations = new CurrentConditionsOperationsTemplate(this, getRestTemplate());
        hourlyForecastOperations = new HourlyForecastOperationsTemplate(this, getRestTemplate());
        dailyForecastOperations = new DailyForecastOperationsTemplate(this, getRestTemplate());
    }
}
