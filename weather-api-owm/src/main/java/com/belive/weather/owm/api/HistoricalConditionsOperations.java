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

package com.belive.weather.owm.api;

import java.util.Date;

/**
 * Defines operations for reading city historical weather data and raw data from weather stations.
 *
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public interface HistoricalConditionsOperations {

    /**
     * Retrieves weather forecast by city name
     * @param city City Name
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByNameInPeriod(String city, Date start, Date end);

    /**
     * Retrieves weather forecast by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByNameAndCountryInPeriod(String city, String country, Date start, Date end);

    /**
     * Retrieves weather forecast by city id
     * @param id City Id
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByIdInPeriod(String id, Date start, Date end);

    /**
     * Retrieves current weather conditions by geographic coordinates
     * @param lat Latitude
     * @param lon Longitude
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByLatLonInPeriod(double lat, double lon, Date start, Date end);

    /**
     * Retrieves weather forecast by city name
     * @param city City Name
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByNameAtTime(String city, Date start);

    /**
     * Retrieves weather forecast by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByNameAndCountryAtTime(String city, String country, Date start);

    /**
     * Retrieves weather forecast by city id
     * @param id City Id
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByIdAtTime(String id, Date start);

    /**
     * Retrieves current weather conditions by geographic coordinates
     * @param lat Latitude
     * @param lon Longitude
     * @return the requested {@link HistoricalConditions<City>}
     */
    HistoricalConditions<City> conditionsNearCityByLatLonAtTime(double lat, double lon, Date start);
}
