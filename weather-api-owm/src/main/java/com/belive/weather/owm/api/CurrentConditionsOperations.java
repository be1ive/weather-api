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


/**
 * Defines operations for reading current weather conditions.
 *
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public interface CurrentConditionsOperations {

    /**
     * Retrieves current weather conditions by city name
     * @param city City Name
     * @return the requested {@link CurrentCityConditions}
     */
    CurrentConditions<City> conditionsNearCityByCityName(String city);

    /**
     * Retrieves current weather conditions by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link CurrentCityConditions}
     */
    CurrentConditions<City> conditionsNearCityByCityAndCountryCode(String city, String country);

    /**
     * Retrieves current weather by city id
     * @param id City Id
     * @return the requested {@link CurrentCityConditions}
     */
    CurrentConditions<City> conditionsNearCityByCityId(String id);

    /**
     * Retrieves current weather conditions for several city IDs
     * @param ids City Ids
     * @return the requested {@link ParametrisedList< CurrentCityConditions >}
     */
    ParametrisedList<CurrentConditions<City>> conditionsNearCityByCityIds(String... ids);

    /**
     * Retrieves current weather conditions by geographic coordinates
     * @param lat Latitude
     * @param lon Longitude
     * @return the requested {@link CurrentCityConditions}
     */
    CurrentConditions<City> conditionsNearCityByLatLon(double lat, double lon);

    /**
     * Retrieves current weather conditions for cities within a rectangle zone
     * @param topLeftLat Latitude of the top left point
     * @param topLeftLon Longitude of the top left point
     * @param botRightLat Latitude of the bottom right point
     * @param botRightLon Longitude of the bottom right point
     * @return the requested {@link ParametrisedList< CurrentCityConditions >}
     */
    ParametrisedList<CurrentConditions<City>> conditionsNearCityInBox(double topLeftLat, double topLeftLon,
            double botRightLat, double botRightLon);

    /**
     * Retrieves current weather conditions for cities in cycle
     * @param centrLat Latitude of the center point
     * @param centrLon Longitude of the center point
     * @param cnt Expected number of points
     * @return the requested {@link ParametrisedList< CurrentCityConditions >}
     */
    ParametrisedList<CurrentConditions<City>> conditionsNearCityInCircle(double centrLat, double centrLon, int cnt);

}
