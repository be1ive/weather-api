package com.be1ive.weather.owm.api;


/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeather extends OpenWeatherObject {

    private CityObject cityObject;

    private WeatherObject weatherObject;

    /**
     * 	City Information
     */
    public CityObject getCity() {
        return cityObject;
    }

    /**
     * 	Weather Information
     */
    public WeatherObject getWeather() {
        return weatherObject;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "city=" + cityObject +
                ", weather=" + weatherObject +
                '}';
    }
}
