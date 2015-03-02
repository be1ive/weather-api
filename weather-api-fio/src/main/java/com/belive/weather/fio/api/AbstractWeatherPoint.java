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
public abstract class AbstractWeatherPoint {

    protected final Date time;

    protected final String summary;

    protected final String icon;

    protected final String precipProbability;

    protected final String precipType;

    protected final Double precipIntensity;

    protected final Double dewPoint;

    protected final Double windSpeed;

    protected final Double windBearing;

    protected final Double cloudCover;

    protected final Double humidity;

    protected final Double pressure;

    protected final Double visibility;

    protected final Double ozone;

    public AbstractWeatherPoint(Date time, String summary, String icon, String precipProbability,
            String precipType, Double precipIntensity, Double dewPoint, Double windSpeed, Double windBearing,
            Double cloudCover, Double humidity, Double pressure, Double visibility, Double ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.precipIntensity = precipIntensity;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.ozone = ozone;
    }

    public Date time() {
        return time;
    }

    public String summary() {
        return summary;
    }

    public String icon() {
        return icon;
    }

    public String precipProbability() {
        return precipProbability;
    }

    public String precipType() {
        return precipType;
    }

    public Double precipIntensity() {
        return precipIntensity;
    }

    public Double dewPoint() {
        return dewPoint;
    }

    public Double windSpeed() {
        return windSpeed;
    }

    public Double windBearing() {
        return windBearing;
    }

    public Double cloudCover() {
        return cloudCover;
    }

    public Double humidity() {
        return humidity;
    }

    public Double pressure() {
        return pressure;
    }

    public Double visibility() {
        return visibility;
    }

    public Double ozone() {
        return ozone;
    }
}