package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.City;
import com.be1ive.weather.owm.api.CurrentWeather;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class SnowObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        SnowObjectMixin(
                @JsonProperty("3h") Double volume){}

    }
}
