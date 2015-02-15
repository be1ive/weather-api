package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CityObject;
import com.be1ive.weather.owm.api.WeatherObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CurrentWeatherMixin extends OpenWeatherObjectMixin {

    @JsonUnwrapped
    CityObject cityObject;

    @JsonUnwrapped
    WeatherObject weatherObject;
}
