package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class WindInformation extends OpenWeatherObject {

    /**
     * Wind speed, mps
     */
    private Double speed;

    /**
     * Wind direction, degrees (meteorological)
     */
    private Double deg;

    /**
     * 	Wind gust, mps
     */
    private Double gust;
}
