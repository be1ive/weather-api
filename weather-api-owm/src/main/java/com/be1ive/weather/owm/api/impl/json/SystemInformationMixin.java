package com.be1ive.weather.owm.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SystemInformationMixin {

    @JsonProperty("message")
    String message;

    @JsonProperty("country")
    String country;

    @JsonProperty("sunrise")
    Date sunrise;

    @JsonProperty("sunset")
    Date sunset;
}
