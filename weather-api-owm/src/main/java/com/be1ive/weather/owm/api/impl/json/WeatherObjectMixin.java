package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CloudsObject;
import com.be1ive.weather.owm.api.MainObject;
import com.be1ive.weather.owm.api.RainObject;
import com.be1ive.weather.owm.api.SnowObject;
import com.be1ive.weather.owm.api.SystemObject;
import com.be1ive.weather.owm.api.WeatherCondition;
import com.be1ive.weather.owm.api.WindObject;
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
public class WeatherObjectMixin extends OpenWeatherObjectMixin {

    @JsonCreator
    WeatherObjectMixin(
            @JsonProperty("dt") @JsonDeserialize(using = UnixDateDeserializer.class) Date date,
            @JsonProperty("weather") @JsonDeserialize(using = WeatherConditionListDeserializer.class) List<WeatherCondition> weatherConditions,
            @JsonProperty("sys") SystemObject systemObject,
            @JsonProperty("main") MainObject mainObject,
            @JsonProperty("wind") WindObject windObject,
            @JsonProperty("clouds")CloudsObject cloudsObject,
            @JsonProperty("rain") RainObject rainObject,
            @JsonProperty("snow") SnowObject snowObject) {}

}
