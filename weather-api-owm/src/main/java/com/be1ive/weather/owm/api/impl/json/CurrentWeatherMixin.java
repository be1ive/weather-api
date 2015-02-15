package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CityObject;
import com.be1ive.weather.owm.api.CloudsObject;
import com.be1ive.weather.owm.api.MainObject;
import com.be1ive.weather.owm.api.RainObject;
import com.be1ive.weather.owm.api.SnowObject;
import com.be1ive.weather.owm.api.SystemObject;
import com.be1ive.weather.owm.api.WeatherCondition;
import com.be1ive.weather.owm.api.WindObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CurrentWeatherMixin extends OpenWeatherObjectMixin {

    @JsonUnwrapped
    CityObject city;

    @JsonProperty("sys")
    SystemObject sys;

    @JsonProperty("main")
    MainObject main;

    @JsonProperty("wind")
    WindObject wind;

    @JsonProperty("clouds")
    CloudsObject clouds;

    @JsonProperty("weather")
    @JsonDeserialize(using = WeatherConditionListDeserializer.class)
    List<WeatherCondition> weather;

    @JsonProperty("rain")
    RainObject rain;

    @JsonProperty("snow")
    SnowObject snow;
}
