package com.be1ive.weather.owm.api;

import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeather extends OpenWeatherObject {

    private CityObject city;

    private SystemObject sys;

    private MainObject main;

    private WindObject wind;

    private CloudsObject clouds;

    private List<WeatherCondition> weather;

    private RainObject rain;

    private SnowObject snow;

    /**
     * 	City Information
     */
    public CityObject getCity() {
        return city;
    }

    /**
     * 	System Information
     */
    public SystemObject getSys() {
        return sys;
    }

    /**
     * 	Main Information
     */
    public MainObject getMain() {
        return main;
    }

    /**
     * 	Wind Information
     */
    public WindObject getWind() {
        return wind;
    }

    /**
     * 	Clouds Information
     */
    public CloudsObject getClouds() {
        return clouds;
    }

    /**
     * 	Weather Information
     */
    public List<WeatherCondition> getWeather() {
        return weather;
    }

    /**
     * 	Rain Information
     */
    public RainObject getRain() {
        return rain;
    }

    /**
     * 	Snow Information
     */
    public SnowObject getSnow() {
        return snow;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "city=" + city +
                ", sys=" + sys +
                ", main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", weather=" + weather +
                ", rain=" + rain +
                ", snow=" + snow +
                '}';
    }
}
