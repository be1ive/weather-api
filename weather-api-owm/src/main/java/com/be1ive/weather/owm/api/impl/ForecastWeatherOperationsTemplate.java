package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.ForecastWeather;
import com.be1ive.weather.owm.api.ForecastWeatherOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import com.be1ive.weather.owm.api.ParametrisedList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Nikolay on 14.02.2015.
 */
public class ForecastWeatherOperationsTemplate implements ForecastWeatherOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public ForecastWeatherOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public ForecastWeather forecastWeatherByCityName(String city) {
        return null;
    }

    @Override
    public ForecastWeather forecastWeatherByCityAndCountryCode(String city, String country) {
        return null;
    }

    @Override
    public ForecastWeather forecastWeatherByCityId(String id) {
        return null;
    }
}
