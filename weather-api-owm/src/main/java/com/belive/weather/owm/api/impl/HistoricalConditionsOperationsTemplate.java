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

package com.belive.weather.owm.api.impl;

import com.belive.weather.owm.api.City;
import com.belive.weather.owm.api.HistoricalCityConditions;
import com.belive.weather.owm.api.HistoricalConditions;
import com.belive.weather.owm.api.HistoricalConditionsOperations;
import com.belive.weather.owm.api.OpenWeatherMapApi;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class HistoricalConditionsOperationsTemplate implements HistoricalConditionsOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public HistoricalConditionsOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByNameInPeriod(String city, Date start, Date end) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city);
        queryParams.set("start", Integer.toString((int) (start.getTime() / 1000)));
        if (end != null && start.before(end)) {
            queryParams.set("end", Integer.toString((int) (end.getTime() / 1000)));
        } else {
            queryParams.set("cnt", Integer.toString(1));
        }
        return api.fetchObject("history/city", TypeFactory.defaultInstance().constructType(HistoricalCityConditions.class), queryParams);
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByNameAndCountryInPeriod(String city, String country, Date start, Date end) {
        return conditionsNearCityByNameInPeriod(city + "," + country, start, end);
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByIdInPeriod(String id, Date start, Date end) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("id", id);
        queryParams.set("start", Integer.toString((int) (start.getTime() / 1000)));
        if (end != null && start.before(end)) {
            queryParams.set("end", Integer.toString((int) (end.getTime() / 1000)));
        } else {
            queryParams.set("cnt", Integer.toString(1));
        }
        queryParams.set("type", "hour");
        return api.fetchObject("history/city", TypeFactory.defaultInstance().constructType(HistoricalCityConditions.class),
                queryParams);
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByLatLonInPeriod(double lat, double lon, Date start, Date end) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(lat));
        queryParams.set("lon", Double.toString(lon));
        queryParams.set("start", Integer.toString((int) (start.getTime() / 1000)));
        if (end != null && start.before(end)) {
            queryParams.set("end", Integer.toString((int) (end.getTime() / 1000)));
        } else {
            queryParams.set("cnt", Integer.toString(1));
        }
        queryParams.set("type", "hour");
        return api.fetchObject("history/city", TypeFactory.defaultInstance().constructType(HistoricalCityConditions.class), queryParams);
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByNameAtTime(String city, Date start) {
        return conditionsNearCityByNameInPeriod(city, start, null);
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByNameAndCountryAtTime(String city, String country, Date start) {
        return conditionsNearCityByNameAndCountryInPeriod(city, country, start, null);
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByIdAtTime(String id, Date start) {
        return conditionsNearCityByIdInPeriod(id, start, null);
    }

    @Override
    public HistoricalConditions<City> conditionsNearCityByLatLonAtTime(double lat, double lon, Date start) {
        return conditionsNearCityByLatLonInPeriod(lat, lon, start, null);
    }

}
