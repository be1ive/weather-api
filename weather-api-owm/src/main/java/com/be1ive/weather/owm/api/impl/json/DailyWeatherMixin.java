package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.AbstractWeather;
import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.DailyWeather;
import com.be1ive.weather.owm.api.WeatherCondition;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikolay on 15.02.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyWeatherMixin extends AbstractWeatherMixin {

    @JsonUnwrapped
    DailyWeather.WindObject windObject;

    @JsonUnwrapped
    DailyWeather.CloudsObject cloudsObject;

    @JsonUnwrapped
    DailyWeather.RainObject rainObject;

    @JsonUnwrapped
    DailyWeather.SnowObject snowObject;

    @JsonUnwrapped
    DailyWeather.MainObject mainObject;

    @JsonProperty("temp")
    DailyWeather.TemperatureObject temperatureObject;

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class CloudsObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        CloudsObjectMixin(
                @JsonProperty("clouds") Double cloudiness) {}

    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class RainObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        RainObjectMixin(
                @JsonProperty("rain") Double volume){}

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

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class SnowObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        SnowObjectMixin(
                @JsonProperty("snow") Double volume){}

    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class TemperatureObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        TemperatureObjectMixin(
                @JsonProperty("day") Double temperature,
                @JsonProperty("min") Double minTemperature,
                @JsonProperty("max") Double maxTemperature,
                @JsonProperty("eve") Double eveningTemperature,
                @JsonProperty("night") Double nightTemperature,
                @JsonProperty("morn") Double morningTemperature){}

    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class MainObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        MainObjectMixin(
                @JsonProperty("humidity") Double humidity,
                @JsonProperty("pressure") Double pressure){}

    }

}
