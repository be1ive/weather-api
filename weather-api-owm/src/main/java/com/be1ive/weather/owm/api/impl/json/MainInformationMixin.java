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
    Double temp;

    @JsonProperty("humidity")
    Double humidity;

    @JsonProperty("temp_min")
    Double tempMin;

    @JsonProperty("temp_max")
    Double tempMax;

    @JsonProperty("pressure")
    Double pressure;

    @JsonProperty("sea_level")
    Double seaLevel;

    @JsonProperty("grnd_level")
    Double grndLevel;

}
