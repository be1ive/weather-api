package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.DailyForecast;
import com.be1ive.weather.owm.api.HourlyForecast;
import com.be1ive.weather.owm.api.HourlyForecastOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Nikolay on 14.02.2015.
 */
public class HourlyForecastOperationsTemplate implements HourlyForecastOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public HourlyForecastOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public HourlyForecast hourlyForecastByCityName(String city) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city);
        return api.fetchObject("forecast", HourlyForecast.class, queryParams);
    }

    @Override
    public HourlyForecast hourlyForecastByCityAndCountryCode(String city, String country) {
        return hourlyForecastByCityName(city + "," + country);
    }

    @Override
    public HourlyForecast hourlyForecastByCityId(String id) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("id", id);
        return api.fetchObject("forecast", HourlyForecast.class, queryParams);
    }

    @Override
    public HourlyForecast dailyForecastByLatLon(double lat, double lon) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(lat));
        queryParams.set("lon", Double.toString(lon));
        return api.fetchObject("forecast", HourlyForecast.class, queryParams);
    }
}
