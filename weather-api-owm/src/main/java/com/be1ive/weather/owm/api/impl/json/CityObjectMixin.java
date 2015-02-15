package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.LocationObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nikolay on 15.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CityObjectMixin extends OpenWeatherObjectMixin {

    @JsonCreator
    CityObjectMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("country") String country,
            @JsonProperty("coord") LocationObject locationObject) {}
}
