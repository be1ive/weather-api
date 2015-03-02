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

package com.belive.weather.fio.api;

import java.util.Date;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class HourlyWeatherPoint extends AbstractWeatherPoint {

    private final Double precipAccumulation;

    private final Double temperature;

    private final Double apparentTemperature;

    public HourlyWeatherPoint(Date time, String summary, String icon, String precipProbability, String precipType,
            Double precipIntensity, Double dewPoint, Double windSpeed, Double windBearing, Double cloudCover,
            Double humidity, Double pressure, Double visibility, Double ozone, Double precipAccumulation,
            Double temperature, Double apparentTemperature) {
        super(time, summary, icon, precipProbability, precipType, precipIntensity, dewPoint, windSpeed, windBearing,
                cloudCover, humidity, pressure, visibility, ozone);
        this.precipAccumulation = precipAccumulation;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
    }

    public Double precipAccumulation() {
        return precipAccumulation;
    }

    public Double temperature() {
        return temperature;
    }

    public Double apparentTemperature() {
        return apparentTemperature;
    }
}
