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

package com.belive.weather.fio.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
abstract class CurrentlyWeatherPointMixin extends AbstractWeatherPointMixin {

    @JsonCreator
    CurrentlyWeatherPointMixin(
            @JsonDeserialize(using = UnixDateDeserializer.class)
            @JsonProperty("time") Date time,
            @JsonProperty("summary") String summary,
            @JsonProperty("icon") String icon,
            @JsonProperty("precipProbability") String precipProbability,
            @JsonProperty("precipType") String precipType,
            @JsonProperty("precipIntensity") Double precipIntensity,
            @JsonProperty("dewPoint") Double dewPoint,
            @JsonProperty("windSpeed") Double windSpeed,
            @JsonProperty("windBearing") Double windBearing,
            @JsonProperty("cloudCover") Double cloudCover,
            @JsonProperty("humidity") Double humidity,
            @JsonProperty("pressure") Double pressure,
            @JsonProperty("visibility") Double visibility,
            @JsonProperty("ozone") Double ozone,
            @JsonProperty("nearestStormBearing") Double nearestStormBearing,
            @JsonProperty("nearestStormDistance") Double nearestStormDistance,
            @JsonProperty("temperature") Double temperature,
            @JsonProperty("apparentTemperature") Double apparentTemperature)
    {
        super(time, summary, icon, precipProbability, precipType, precipIntensity, dewPoint, windSpeed, windBearing,
                cloudCover, humidity, pressure, visibility, ozone);
    }

}
