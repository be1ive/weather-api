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

package com.belive.weather.fio.api.impl;

import com.belive.weather.AbstractApiConfigurations;
import com.belive.weather.AuthStrategy;
import com.belive.weather.fio.api.ForecastIO;
import com.belive.weather.fio.api.ForecastIOErrorHandler;
import com.belive.weather.fio.api.ForecastOperations;
import com.belive.weather.fio.api.impl.json.ForecastIOModule;
import com.belive.weather.support.URIBuilder;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.*;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class ForecastIOTemplate extends AbstractApiConfigurations implements ForecastIO {

    private ForecastOperations forecastOperations;

    private ObjectMapper objectMapper;

    public ForecastIOTemplate() {
        initialize();
    }

    public ForecastIOTemplate(String accessToken) {
        super(accessToken, FIO_AUTH_PARAM, AuthStrategy.AUTHORIZATION_URI_PARAMETER);
        initialize();
    }

    @Override
    public ForecastOperations forecastOperations() {
        return forecastOperations;
    }

    @Override
    public <T> T fetchObject(String objectName, JavaType type, MultiValueMap<String, String> uriParameters) {
        URI uri = URIBuilder.fromUri(FIO_API_URL + "/" + objectName).uriParameters(uriParameters).build();
        JsonNode jsonNode = getRestTemplate().getForObject(uri, JsonNode.class);
        return entry(type, jsonNode);
    }

    @Override
    public <T> List<T> fetchObjects(String objectName, JavaType type, MultiValueMap<String, String> uriParameters) {
        URI uri = URIBuilder.fromUri(FIO_API_URL + "/" + objectName).uriParameters(uriParameters).build();
        JsonNode jsonNode = getRestTemplate().getForObject(uri, JsonNode.class);
        return list(type, jsonNode);
    }

    private <T> T entry(JavaType type, JsonNode jsonNode) {
        try {
            return (T) objectMapper.reader(type).readValue(jsonNode.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> List<T> list(JavaType type, JsonNode jsonNode) {
        List<T> list = deserializeList(jsonNode.get("list"), type);
        return new ArrayList<>(list);
    }

    private <T> List<T> deserializeList(JsonNode jsonNode, final JavaType elementType) {
        try {
            CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, elementType);
            return (List<T>) objectMapper.reader(listType).readValue(jsonNode.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new ForecastIOModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new ForecastIOErrorHandler());
    }

    private void initialize() {
        initOperations();
    }

    private void initOperations() {
        forecastOperations = new ForecastOperationsTemplate(this, getRestTemplate());
    }
}
