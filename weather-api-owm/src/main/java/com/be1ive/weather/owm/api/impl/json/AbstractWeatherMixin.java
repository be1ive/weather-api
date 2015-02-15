package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.WeatherCondition;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikolay on 15.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractWeatherMixin extends OpenWeatherMapObjectMixin {

    @JsonProperty("dt")
    @JsonDeserialize(using = UnixDateDeserializer.class) Date date;

    @JsonProperty("weather")
    @JsonDeserialize(using = WeatherConditionListDeserializer.class) List<WeatherCondition> conditions;

}
