package com.be1ive.weather.owm.api;

import java.util.List;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class DailyForecast extends OpenWeatherMapObject {

    private City city;

    private List<DailyWeather> dailyWeather;

    /**
     * 	City Information
     */
    public City getCity() {
        return city;
    }

    /**
     * 	Weather Information
     */
    public List<DailyWeather> getDailyWeather() {
        return dailyWeather;
    }


}
