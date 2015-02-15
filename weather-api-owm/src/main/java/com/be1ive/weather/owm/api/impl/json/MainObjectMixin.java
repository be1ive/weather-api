package com.be1ive.weather.owm.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class MainObjectMixin extends OpenWeatherObjectMixin {

    @JsonCreator
    MainObjectMixin(
            @JsonProperty("temp") Double temperature,
            @JsonProperty("humidity") Double humidity,
            @JsonProperty("temp_min") Double minTemperature,
            @JsonProperty("temp_max") Double maxTemperature,
            @JsonProperty("pressure") Double pressure,
            @JsonProperty("sea_level") Double seaLevel,
            @JsonProperty("grnd_level") Double groundLevel){}

}
