package com.be1ive.weather.owm.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SystemObjectMixin extends OpenWeatherObjectMixin {

    @JsonCreator
    SystemObjectMixin(
            @JsonProperty("message") String message,
            @JsonProperty("country") String country,
            @JsonDeserialize(using = UnixDateDeserializer.class) @JsonProperty("sunrise") Date sunrise,
            @JsonDeserialize(using = UnixDateDeserializer.class) @JsonProperty("sunset") Date sunset) {}
}
