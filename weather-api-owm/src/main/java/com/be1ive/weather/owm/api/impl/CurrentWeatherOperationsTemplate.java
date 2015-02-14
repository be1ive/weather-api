package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.UncategorizedApiException;
import com.be1ive.weather.owm.api.BoxParameters;
import com.be1ive.weather.owm.api.CircleParameters;
import com.be1ive.weather.owm.api.ParametrisedList;
import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import com.be1ive.weather.owm.api.WeatherCondition;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeatherOperationsTemplate implements CurrentWeatherOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public CurrentWeatherOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public CurrentWeather currentWeatherByCityName(String city) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city);
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByCityAndCountryCode(String city, String country) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city + "," + country);
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByCityId(String id) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("id", id);
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByLatLon(double lat, double lon) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(lat));
        queryParams.set("lon", Double.toString(lon));
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public ParametrisedList<CurrentWeather> currentWeatherInBox(BoxParameters parameters) {
        return api.fetchObjects("box/city", CurrentWeather.class, parameters.toParameters());
    }

    @Override
    public ParametrisedList<CurrentWeather> currentWeatherInCircle(CircleParameters parameters) {
        return api.fetchObjects("find", CurrentWeather.class, parameters.toParameters());
    }
}
