package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.AbstractWeather;
import com.be1ive.weather.owm.api.City;
import com.be1ive.weather.owm.api.CurrentConditions;
import com.be1ive.weather.owm.api.DailyForecast;
import com.be1ive.weather.owm.api.DailyWeather;
import com.be1ive.weather.owm.api.HourlyForecast;
import com.be1ive.weather.owm.api.Location;
import com.be1ive.weather.owm.api.OpenWeatherMapObject;
import com.be1ive.weather.owm.api.CurrentWeather;
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
