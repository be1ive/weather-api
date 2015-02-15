package com.be1ive.weather.owm.api;

import java.util.List;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class HourlyForecast extends OpenWeatherMapObject {

    private City city;

    private List<CurrentWeather> currentWeather;

    /**
     * 	City Information
     */
    public City getCity() {
        return city;
    }

    /**
     * 	Weather Information
     */
    public List<CurrentWeather> getCurrentWeather() {
        return currentWeather;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "city=" + city +
                ", currentWeather=" + currentWeather +
                '}';
    }
}
