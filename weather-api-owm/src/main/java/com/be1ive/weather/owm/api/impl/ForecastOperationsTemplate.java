package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.HourlyForecast;
import com.be1ive.weather.owm.api.HourlyForecastOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Nikolay on 14.02.2015.
 */
public class ForecastOperationsTemplate implements HourlyForecastOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public ForecastOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public HourlyForecast forecastWeatherByCityName(String city) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city);
        return api.fetchObject("forecast", HourlyForecast.class, queryParams);
    }

    @Override
    public HourlyForecast forecastWeatherByCityAndCountryCode(String city, String country) {
        return forecastWeatherByCityName(city + "," + country);
    }

    @Override
    public HourlyForecast forecastWeatherByCityId(String id) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("id", id);
        return api.fetchObject("forecast", HourlyForecast.class, queryParams);
    }
}
