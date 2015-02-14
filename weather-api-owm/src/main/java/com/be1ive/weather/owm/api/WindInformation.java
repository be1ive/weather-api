package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class WindInformation extends OpenWeatherObject {

    /**
     * Wind speed, mps
     */
    private double speed;

    /**
     * Wind direction, degrees (meteorological)
     */
    private double deg;

    /**
     * 	Wind gust, mps
     */
    private double gust;
}
