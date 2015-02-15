package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.City;
import com.be1ive.weather.owm.api.CurrentWeather;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CurrentConditionsMixin extends OpenWeatherMapObjectMixin {

    @JsonUnwrapped
    City city;

    @JsonUnwrapped
    CurrentWeather currentWeather;

}
