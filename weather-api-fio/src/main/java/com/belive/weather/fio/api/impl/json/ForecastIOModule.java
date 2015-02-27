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

package com.belive.weather.fio.api.impl.json;

import com.belive.weather.fio.api.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class ForecastIOModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public ForecastIOModule() {
        super("ForecastIOModule");
    }

    @Override
    public void setupModule(SetupContext context) {

        context.setMixInAnnotations(ForecastIOObject.class, ForecastIOObjectMixin.class);

        context.setMixInAnnotations(ForecastWeather.class, ForecastWeatherMixin.class);

        context.setMixInAnnotations(AbstractWeatherPoint.class, AbstractWeatherPointMixin.class);

        context.setMixInAnnotations(CurrentlyWeatherPoint.class, CurrentlyWeatherPointMixin.class);
        context.setMixInAnnotations(DailyWeatherPoint.class, DailyWeatherPointMixin.class);
        context.setMixInAnnotations(HourlyWeatherPoint.class, HourlyWeatherPointMixin.class);

        context.setMixInAnnotations(CurrentlyWeather.class, CurrentlyWeatherMixin.class);
        context.setMixInAnnotations(DailyWeather.class, DailyWeatherMixin.class);
        context.setMixInAnnotations(HourlyWeather.class, HourlyWeatherMixin.class);
    }
}
