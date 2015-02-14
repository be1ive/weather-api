package com.be1ive.weather.owm.api;

import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public interface CurrentWeatherOperations {

    CurrentWeather currentWeatherByCityName(String city);

    CurrentWeather currentWeatherByCityAndCountryCode(String city, String country);

    CurrentWeather currentWeatherByCityId(String id);

    CurrentWeather currentWeatherByLatLon(double lat, double lon);

    ParametrisedList<CurrentWeather> currentWeatherInBox(BoxParameters parameters);

    ParametrisedList<CurrentWeather> currentWeatherInCircle(CircleParameters parameters);

}
