/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.belive.weather.owm.api.impl.json;

import com.belive.weather.owm.api.DailyWeather;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class CloudsObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        CloudsObjectMixin(
                @JsonProperty("clouds") Double cloudiness) {}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class RainObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        RainObjectMixin(
                @JsonProperty("rain") Double volume){}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class WindObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        WindObjectMixin(
                @JsonProperty("speed") Double speed,
                @JsonProperty("deg") Double degree,
                @JsonProperty("gust") Double gust) {}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class SnowObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        SnowObjectMixin(
                @JsonProperty("snow") Double volume){}

    }

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

    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class MainObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        MainObjectMixin(
                @JsonProperty("humidity") Double humidity,
                @JsonProperty("pressure") Double pressure){}

    }

}
