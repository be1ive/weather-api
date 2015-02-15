package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.DailyForecast;
import com.be1ive.weather.owm.api.DailyForecastOperations;
import com.be1ive.weather.owm.api.HourlyForecast;
import com.be1ive.weather.owm.api.HourlyForecastOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class DailyForecastOperationsTemplate implements DailyForecastOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public DailyForecastOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public DailyForecast dailyForecastByCityName(String city) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city);
        return api.fetchObject("forecast/daily", DailyForecast.class, queryParams);
    }

    @Override
    public DailyForecast dailyForecastByCityAndCountryCode(String city, String country) {
        return dailyForecastByCityName(city + "," + country);
    }

    @Override
    public DailyForecast dailyForecastByCityId(String id) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("id", id);
        return api.fetchObject("forecast/daily", DailyForecast.class, queryParams);
    }

    @Override
    public DailyForecast dailyForecastByLatLon(double lat, double lon) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(lat));
        queryParams.set("lon", Double.toString(lon));
        return api.fetchObject("forecast/daily", DailyForecast.class, queryParams);
    }
}
