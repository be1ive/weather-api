package com.be1ive.weather.owm.api;

import com.be1ive.weather.ApiConfigurations;

/**
 * Created by Nikolay on 14.02.2015.
 */
public interface OpenWeatherMap extends OpenWeatherMapApi, ApiConfigurations {

    CurrentConditionsOperations currentConditionsOperations();

    HourlyForecastOperations hourlyForecastOperations();
}
