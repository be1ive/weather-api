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

package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CurrentWeather;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherMixin extends AbstractWeatherMixin {

    @JsonProperty("wind")
    CurrentWeather.WindObject windObject;

    @JsonProperty("clouds")
    CurrentWeather.CloudsObject cloudsObject;

    @JsonProperty("rain")
    CurrentWeather.RainObject rainObject;

    @JsonProperty("snow")
    CurrentWeather.SnowObject snowObject;

    @JsonProperty("sys")
    CurrentWeather.SystemObject systemObject;

    @JsonProperty("main")
    CurrentWeather.MainObject mainObject;

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class CloudsObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        CloudsObjectMixin(
                @JsonProperty("all") Double cloudiness) {}

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
                @JsonProperty("3h") Double volume){}

    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    abstract static class MainObjectMixin extends OpenWeatherMapObjectMixin {

        @JsonCreator
        MainObjectMixin(
                @JsonProperty("temp") Double temperature,
                @JsonProperty("temp_min") Double minTemperature,
                @JsonProperty("temp_max") Double maxTemperature,
                @JsonProperty("humidity") Double humidity,
                @JsonProperty("pressure") Double pressure,
                @JsonProperty("sea_level") Double seaLevel,
                @JsonProperty("grnd_level") Double groundLevel){}

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

}
