package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
}
