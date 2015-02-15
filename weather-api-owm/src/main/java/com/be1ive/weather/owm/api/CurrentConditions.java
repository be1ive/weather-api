package com.be1ive.weather.owm.api;


/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentConditions extends OpenWeatherMapObject {

    private City city;

    private CurrentWeather currentWeather;

    /**
     * 	City Information
     */
    public City getCity() {
        return city;
    }

    /**
     * 	Weather Information
     */
    public CurrentWeather getCurrentWeather() {
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
