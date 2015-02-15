package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CityObject;
import com.be1ive.weather.owm.api.WeatherObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Nikolay on 15.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ForecastWeatherMixin extends OpenWeatherObjectMixin {

    @JsonProperty("city")
    CityObject cityObject;

    @JsonProperty("list")
    List<WeatherObject> weatherObjects;
}
