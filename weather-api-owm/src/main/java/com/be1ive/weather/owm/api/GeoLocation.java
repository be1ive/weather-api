package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class GeoLocation extends OpenWeatherObject {

    /**
     * Location, latitude
     */
    private double lat;

    /**
     * Location, longitude
     */
    private double lon;

    public GeoLocation(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}