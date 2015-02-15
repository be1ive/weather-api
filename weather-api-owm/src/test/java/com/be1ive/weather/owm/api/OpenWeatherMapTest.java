package com.be1ive.weather.owm.api;

import com.be1ive.weather.owm.api.impl.OpenWeatherMapTemplate;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class OpenWeatherMapTest {

    public static void main (String args[]) {
        OpenWeatherMap openWeatherMap = new OpenWeatherMapTemplate("dab15b81ad001128f8bd2621c5605b1c");

        CurrentConditionsOperations cwo = openWeatherMap.currentConditionsOperations();
        HourlyForecastOperations hfo = openWeatherMap.hourlyForecastOperations();

        DailyForecastOperations dfo = openWeatherMap.dailyForecastOperations();
        dfo.dailyForecastByCityName("Москва");

//        CurrentConditions currentConditions = cwo.currentConditionsByCityName("Москва");
//        HourlyForecast hourlyForecast = fwo.hourlyForecastByCityName("Москва");
//        ParametrisedList<CurrentWeather> currentWeathers2 =
//                cwo.currentConditionsInBox(new BoxParameters().topLatitude(12).topLongitude(32).botLatitude(15).botLongitude(37));
//
//        ParametrisedList<CurrentWeather> currentWeathers3 =
//                cwo.currentConditionsByCityIds("524901", "703448");

//        System.out.print(currentWeather);
    }
}
