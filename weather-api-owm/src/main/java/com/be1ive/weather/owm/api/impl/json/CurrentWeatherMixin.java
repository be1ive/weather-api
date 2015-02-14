package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CloudsInformation;
import com.be1ive.weather.owm.api.GeoLocation;
import com.be1ive.weather.owm.api.RainInformation;
import com.be1ive.weather.owm.api.SnowInformation;
import com.be1ive.weather.owm.api.SystemInformation;
import com.be1ive.weather.owm.api.WeatherCondition;
import com.be1ive.weather.owm.api.WindInformation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CurrentWeatherMixin extends OpenWeatherObjectMixin {

    @JsonProperty("id")
    String id;

    @JsonProperty("dt")
    Date dt;

    @JsonProperty("name")
    String name;

    @JsonProperty("coord")
    GeoLocation coord;

    @JsonProperty("sys")
    SystemInformation sys;

    @JsonProperty("main")
    SystemInformation main;

    @JsonProperty("wind")
    WindInformation wind;

    @JsonProperty("clouds")
    CloudsInformation clouds;

    @JsonProperty("weather")
    @JsonDeserialize(using = WeatherConditionDeserializer.class)
    List<WeatherCondition> weather;

    @JsonProperty("rain")
    RainInformation rain;

    @JsonProperty("snow")
    SnowInformation snow;

    private static class WeatherConditionDeserializer extends JsonDeserializer<List<WeatherCondition>> {
        @Override
        public List<WeatherCondition> deserialize(JsonParser jsonParser, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            try {
                ObjectCodec oc = jsonParser.getCodec();
                JsonNode node = oc.readTree(jsonParser);
                if (node != null) {
                    List<WeatherCondition> list = new ArrayList<>();
                    for (Iterator<JsonNode> itr = node.elements(); itr.hasNext(); ) {
                        list.add(WeatherCondition.forId(itr.next().get("id").asText()));
                    }
                    return list;
                } else {
                    return Collections.EMPTY_LIST;
                }
            } catch (IllegalArgumentException e) {
                return Collections.EMPTY_LIST;
            }
        }
    }

}
