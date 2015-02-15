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
public class CurrentWeatherMixin extends AbstractWeatherMixin {

    @JsonCreator
    CurrentWeatherMixin(
            @JsonProperty("dt") @JsonDeserialize(using = UnixDateDeserializer.class) Date date,
            @JsonProperty("weather") @JsonDeserialize(using = WeatherConditionListDeserializer.class) List<WeatherCondition> conditions,
            @JsonProperty("sys") CurrentWeather.SystemObject systemObject,
            @JsonProperty("main") CurrentWeather.MainObject mainObject,
            @JsonProperty("wind") CurrentWeather.WindObject windObject,
            @JsonProperty("clouds") CurrentWeather.CloudsObject cloudsObject,
            @JsonProperty("rain") CurrentWeather.RainObject rainObject,
            @JsonProperty("snow") CurrentWeather.SnowObject snowObject)
    {
        super(date, conditions);
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class MainObjectMixin extends OpenWeatherMapObjectMixin {

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

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class CloudsObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        CloudsObjectMixin(
                @JsonProperty("all") Double all) {}

    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class RainObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        RainObjectMixin(
                @JsonProperty("3h") Double volume){}

    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class SystemObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        SystemObjectMixin(
                @JsonProperty("message") String message,
                @JsonProperty("country") String country,
                @JsonDeserialize(using = UnixDateDeserializer.class) @JsonProperty("sunrise") Date sunrise,
                @JsonDeserialize(using = UnixDateDeserializer.class) @JsonProperty("sunset") Date sunset) {}
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class WindObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        WindObjectMixin(
                @JsonProperty("speed") Double speed,
                @JsonProperty("deg") Double degree,
                @JsonProperty("gust") Double gust) {}

    }
}
