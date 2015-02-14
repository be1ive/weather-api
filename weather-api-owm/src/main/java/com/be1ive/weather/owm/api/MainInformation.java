package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class MainInformation extends OpenWeatherObject {

    /**
     * Temperature, Kelvin (subtract 273.15 to convert to Celsius)
     */
    private Double temp;

    /**
     * Humidity, %
     */
    private Double humidity;

    /**
     * 	Minimum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally)
     */
    private Double tempMin;

    /**
     * Minimum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally)
     */
    private Double tempMax;

    /**
     * Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
     */
    private Double pressure;

    /**
     * Atmospheric pressure on the sea level, hPa
     */
    private Double seaLevel;

    /**
     * Atmospheric pressure on the ground level, hPa
     */
    private Double grndLevel;
}
