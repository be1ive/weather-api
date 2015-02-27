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

package com.belive.weather.fio.api.impl;

import com.belive.weather.fio.api.ForecastIOApi;
import com.belive.weather.fio.api.ForecastOperations;
import com.belive.weather.fio.api.ForecastWeather;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class ForecastOperationsTemplate implements ForecastOperations {

    protected final ForecastIOApi api;

    protected final RestTemplate restTemplate;

    public ForecastOperationsTemplate(ForecastIOApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public ForecastWeather forecastByLatLon(double lat, double lon) {
        MultiValueMap<String, String> uriParams = new LinkedMultiValueMap<>();
        uriParams.add("PARAMS", Double.toString(lat));
        uriParams.add("PARAMS", Double.toString(lon));
        return api.fetchObject("$PARAMS$", TypeFactory
                .defaultInstance().constructType(ForecastWeather.class), uriParams);
    }

    @Override
    public ForecastWeather forecastByLatLonAndDate(double lat, double lon, Date date) {
        MultiValueMap<String, String> uriParams = new LinkedMultiValueMap<>();
        uriParams.add("PARAMS", Double.toString(lat));
        uriParams.add("PARAMS", Double.toString(lon));
        uriParams.add("PARAMS", Integer.toString((int) (date.getTime() / 1000)));
        return api.fetchObject("$PARAMS$", TypeFactory
                .defaultInstance().constructType(ForecastWeather.class), uriParams);
    }
}
