package com.be1ive.weather.owm.api;

import com.be1ive.weather.owm.api.impl.OpenWeatherMapTemplate;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class OpenWeatherMapTest {

    public static void main (String args[]) {
        OpenWeatherMap openWeatherMap = new OpenWeatherMapTemplate("dab15b81ad001128f8bd2621c5605b1c");

        CurrentConditionsOperations cwo = openWeatherMap.currentConditionsOperations();
        HourlyForecastOperations fwo = openWeatherMap.hourlyForecastOperations();
        CurrentConditions currentConditions = cwo.currentWeatherByCityName("Москва");
        HourlyForecast hourlyForecast = fwo.forecastWeatherByCityName("Москва");
//        ParametrisedList<CurrentWeather> currentWeathers2 =
//                cwo.currentWeatherInBox(new BoxParameters().topLatitude(12).topLongitude(32).botLatitude(15).botLongitude(37));
//
//        ParametrisedList<CurrentWeather> currentWeathers3 =
//                cwo.currentWeatherByCityIds("524901", "703448");

//        System.out.print(currentWeather);
    }
}
