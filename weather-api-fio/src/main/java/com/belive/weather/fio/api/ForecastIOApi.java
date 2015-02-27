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

import com.fasterxml.jackson.databind.JavaType;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public interface ForecastIOApi {

    static final String FIO_API_URL = "https://api.forecast.io/forecast/$APIKEY$";

    static final String FIO_AUTH_PARAM = "APIKEY";

    <T> T fetchObject(String objectName, JavaType type, MultiValueMap<String, String> queryParameters);

    <T> List<T> fetchObjects(String objectName, JavaType type, MultiValueMap<String, String> queryParameters);

}
