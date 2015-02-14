package com.be1ive.weather.owm.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class MainInformationMixin {

    @JsonProperty("temp")
    double temp;

    @JsonProperty("humidity")
    double humidity;

    @JsonProperty("temp_min")
    double tempMin;

    @JsonProperty("temp_max")
    double tempMax;

    @JsonProperty("pressure")
    double pressure;

    @JsonProperty("sea_level")
    double seaLevel;

    @JsonProperty("grnd_level")
    double grndLevel;

}
