package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.CloudsInformation;
import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.GeoLocation;
import com.be1ive.weather.owm.api.MainInformation;
import com.be1ive.weather.owm.api.OpenWeatherObject;
import com.be1ive.weather.owm.api.RainInformation;
import com.be1ive.weather.owm.api.SnowInformation;
import com.be1ive.weather.owm.api.SystemInformation;
import com.be1ive.weather.owm.api.WindInformation;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sun.media.jfxmedia.control.VideoFormat;

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
        context.setMixInAnnotations(CloudsInformation.class, CloudsInformationMixin.class);
        context.setMixInAnnotations(CurrentWeather.class, CurrentWeatherMixin.class);
        context.setMixInAnnotations(GeoLocation.class, GeoLocationMixin.class);
        context.setMixInAnnotations(MainInformation.class, MainInformationMixin.class);
        context.setMixInAnnotations(OpenWeatherObject.class, OpenWeatherObjectMixin.class);
        context.setMixInAnnotations(RainInformation.class, RainInformationMixin.class);
        context.setMixInAnnotations(SnowInformation.class, SnowInformationMixin.class);
        context.setMixInAnnotations(SystemInformation.class, SystemInformationMixin.class);
        context.setMixInAnnotations(WindInformation.class, WindInformationMixin.class);
    }
}
