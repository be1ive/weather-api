package com.be1ive.weather.owm.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class WindInformationMixin {

    @JsonProperty("speed")
    Double speed;

    @JsonProperty("deg")
    Double deg;

    @JsonProperty("gust")
    Double gust;

}
