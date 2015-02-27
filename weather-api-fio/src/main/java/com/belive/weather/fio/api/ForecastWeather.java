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

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class ForecastWeather extends ForecastIOObject {

    private Double latitude;

    private Double longitude;

    private Integer offset;

    private String timezone;

    private CurrentlyWeather currently;

    private HourlyWeather hourly;

    private DailyWeather daily;

    //The requested latitude.
    public Double latitude() {
        return latitude;
    }

    //The requested longitude.
    public Double longitude() {
        return longitude;
    }

    //The current timezone offset in hours from GMT.
    public Integer offset() {
        return offset;
    }

    // The IANA timezone name for the requested location (e.g. America/New_York).
    // This is the timezone used for text forecast summaries and for determining the exact start time of daily data points.
    // (Developers are advised to rely on local system settings rather than this value if at all possible:
    // users may deliberately set an unusual timezone, and furthermore are likely to know what they actually want better than our timezone database does.)
    public String timezone() {
        return timezone;
    }

    //A data point (see below) containing the current weather conditions at the requested location.
    public CurrentlyWeather currently() {
        return currently;
    }

    //A data block (see below) containing the weather conditions hour-by-hour for the next two days.
    public HourlyWeather hourly() {
        return hourly;
    }

    //A data block (see below) containing the weather conditions day-by-day for the next week.
    public DailyWeather daily() {
        return daily;
    }
}
