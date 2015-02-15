package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CityObject;
import com.be1ive.weather.owm.api.CloudsObject;
import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.ForecastWeather;
import com.be1ive.weather.owm.api.LocationObject;
import com.be1ive.weather.owm.api.MainObject;
import com.be1ive.weather.owm.api.OpenWeatherObject;
import com.be1ive.weather.owm.api.RainObject;
import com.be1ive.weather.owm.api.SnowObject;
import com.be1ive.weather.owm.api.SystemObject;
import com.be1ive.weather.owm.api.WeatherObject;
import com.be1ive.weather.owm.api.WindObject;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class OpenWeatherMapModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public OpenWeatherMapModule() {
        super("OpenWeatherMapModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(CityObject.class, CityObjectMixin.class);
        context.setMixInAnnotations(CloudsObject.class, CloudsObjectMixin.class);
        context.setMixInAnnotations(CurrentWeather.class, CurrentWeatherMixin.class);
        context.setMixInAnnotations(ForecastWeather.class, ForecastWeatherMixin.class);
        context.setMixInAnnotations(LocationObject.class, LocationObjectMixin.class);
        context.setMixInAnnotations(MainObject.class, MainObjectMixin.class);
        context.setMixInAnnotations(OpenWeatherObject.class, OpenWeatherObjectMixin.class);
        context.setMixInAnnotations(RainObject.class, RainObjectMixin.class);
        context.setMixInAnnotations(SnowObject.class, SnowObjectMixin.class);
        context.setMixInAnnotations(SystemObject.class, SystemObjectMixin.class);
        context.setMixInAnnotations(WeatherObject.class, WeatherObjectMixin.class);
        context.setMixInAnnotations(WindObject.class, WindObjectMixin.class);
    }
}
