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
public class DailyWeatherPoint extends AbstractWeatherPoint {

    private final Date sunriseTime;

    private final Date sunsetTime;

    private final Double moonPhase;

    private final Double precipIntensityMax;

    private final Date precipIntensityMaxTime;

    private final Double precipAccumulation;

    private final Double temperatureMin;

    private final Date temperatureMinTime;

    private final Double temperatureMax;

    private final Date temperatureMaxTime;

    private final Double apparentTemperatureMin;

    private final Date apparentTemperatureMinTime;

    private final Double apparentTemperatureMax;

    private final Date apparentTemperatureMaxTime;

    public DailyWeatherPoint(Date time, String summary, String icon, String precipProbability, String precipType,
            Double precipIntensity, Double dewPoint, Double windSpeed, Double windBearing, Double cloudCover,
            Double humidity, Double pressure, Double visibility, Double ozone, Date sunriseTime, Date sunsetTime,
            Double moonPhase, Double precipIntensityMax, Date precipIntensityMaxTime, Double precipAccumulation,
            Double temperatureMin, Date temperatureMinTime, Double temperatureMax, Date temperatureMaxTime,
            Double apparentTemperatureMin, Date apparentTemperatureMinTime, Double apparentTemperatureMax,
            Date apparentTemperatureMaxTime) {
        super(time, summary, icon, precipProbability, precipType, precipIntensity, dewPoint, windSpeed, windBearing,
                cloudCover, humidity, pressure, visibility, ozone);
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipIntensityMax = precipIntensityMax;
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        this.precipAccumulation = precipAccumulation;
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public Date sunriseTime() {
        return sunriseTime;
    }

    public Date sunsetTime() {
        return sunsetTime;
    }

    public Double moonPhase() {
        return moonPhase;
    }

    public Double precipIntensityMax() {
        return precipIntensityMax;
    }

    public Date precipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public Double precipAccumulation() {
        return precipAccumulation;
    }

    public Double temperatureMin() {
        return temperatureMin;
    }

    public Date temperatureMinTime() {
        return temperatureMinTime;
    }

    public Double temperatureMax() {
        return temperatureMax;
    }

    public Date temperatureMaxTime() {
        return temperatureMaxTime;
    }

    public Double apparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public Date apparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public Double apparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public Date getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }
}
