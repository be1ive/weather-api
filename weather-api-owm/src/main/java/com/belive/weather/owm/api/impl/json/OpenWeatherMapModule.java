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

package com.belive.weather.owm.api.impl.json;

import com.belive.weather.owm.api.AbstractWeather;
import com.belive.weather.owm.api.City;
import com.belive.weather.owm.api.CurrentConditions;
import com.belive.weather.owm.api.CurrentWeather;
import com.belive.weather.owm.api.DailyForecast;
import com.belive.weather.owm.api.DailyWeather;
import com.belive.weather.owm.api.HourlyForecast;
import com.belive.weather.owm.api.Location;
import com.belive.weather.owm.api.OpenWeatherMapObject;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class OpenWeatherMapModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public OpenWeatherMapModule() {
        super("OpenWeatherMapModule");
    }

    @Override
    public void setupModule(SetupContext context) {

        context.setMixInAnnotations(OpenWeatherMapObject.class, OpenWeatherMapObjectMixin.class);

        context.setMixInAnnotations(City.class, CityMixin.class);
        context.setMixInAnnotations(Location.class, LocationMixin.class);

        context.setMixInAnnotations(CurrentConditions.class, CurrentConditionsMixin.class);
        context.setMixInAnnotations(HourlyForecast.class, HourlyForecastMixin.class);
        context.setMixInAnnotations(DailyForecast.class,DailyForecastMixin.class);

        context.setMixInAnnotations(AbstractWeather.class, AbstractWeatherMixin.class);

        context.setMixInAnnotations(CurrentWeather.class, CurrentWeatherMixin.class);
        context.setMixInAnnotations(CurrentWeather.MainObject.class, CurrentWeatherMixin.MainObjectMixin.class);
        context.setMixInAnnotations(CurrentWeather.SystemObject.class, CurrentWeatherMixin.SystemObjectMixin.class);
        context.setMixInAnnotations(CurrentWeather.WindObject.class, CurrentWeatherMixin.WindObjectMixin.class);
        context.setMixInAnnotations(CurrentWeather.CloudsObject.class, CurrentWeatherMixin.CloudsObjectMixin.class);
        context.setMixInAnnotations(CurrentWeather.RainObject.class, CurrentWeatherMixin.RainObjectMixin.class);
        context.setMixInAnnotations(CurrentWeather.SnowObject.class, CurrentWeatherMixin.SnowObjectMixin.class);

        context.setMixInAnnotations(DailyWeather.class, DailyWeatherMixin.class);
        context.setMixInAnnotations(DailyWeather.MainObject.class, DailyWeatherMixin.MainObjectMixin.class);
        context.setMixInAnnotations(DailyWeather.WindObject.class, DailyWeatherMixin.WindObjectMixin.class);
        context.setMixInAnnotations(DailyWeather.CloudsObject.class, DailyWeatherMixin.CloudsObjectMixin.class);
        context.setMixInAnnotations(DailyWeather.RainObject.class, DailyWeatherMixin.RainObjectMixin.class);
        context.setMixInAnnotations(DailyWeather.SnowObject.class, DailyWeatherMixin.SnowObjectMixin.class);
        context.setMixInAnnotations(DailyWeather.TemperatureObject.class, DailyWeatherMixin.TemperatureObjectMixin.class);
    }
}
