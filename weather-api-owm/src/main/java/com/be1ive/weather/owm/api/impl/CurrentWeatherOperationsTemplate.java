package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.OpenApi;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeatherOperationsTemplate implements CurrentWeatherOperations {

    protected final OpenApi openApi;

    protected final RestTemplate restTemplate;

    public CurrentWeatherOperationsTemplate(OpenApi openApi, RestTemplate restTemplate) {
        this.openApi = openApi;
        this.restTemplate = restTemplate;
    }

    @Override
    public CurrentWeather currentWeatherByCityName(String city) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("city", city);
        return openApi.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByCityId(String id) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", id);
        return openApi.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByLatLon(double lat, double lon) {
        Map<String, Double> queryParams = new HashMap<>();
        queryParams.put("lat", lat);
        queryParams.put("lon", lon);
        return openApi.fetchObject("weather", CurrentWeather.class, queryParams);
    }
}
