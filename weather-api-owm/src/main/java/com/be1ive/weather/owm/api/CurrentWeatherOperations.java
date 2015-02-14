package com.be1ive.weather.owm.api;

import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public interface CurrentWeatherOperations {

    CurrentWeather currentWeatherByCityName(String city);

    CurrentWeather currentWeatherByCityId(String id);

    CurrentWeather currentWeatherByLatLon(double lat, double lon);

}
