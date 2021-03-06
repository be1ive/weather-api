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

import com.belive.weather.owm.api.impl.OpenWeatherMapTemplate;

import java.util.Date;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class OpenWeatherMapTest {

    public static void main (String args[]) {
        OpenWeatherMap openWeatherMap = new OpenWeatherMapTemplate("dab15b81ad001128f8bd2621c5605b1c");

        HistoricalConditionsOperations hco = openWeatherMap.historicalConditionsOperations();

        HistoricalConditions<City> historicalConditions = hco.conditionsNearCityByIdAtTime("5381421",
                new Date(1414986653*1000));
        System.out.print(historicalConditions);

    }
}
