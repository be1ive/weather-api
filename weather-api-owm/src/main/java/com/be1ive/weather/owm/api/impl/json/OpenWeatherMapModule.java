package com.be1ive.weather.owm.api.impl.json;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class OpenWeatherMapModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public OpenWeatherMapModule() {
        super("OpenWeatherMapModule");
    }
}
