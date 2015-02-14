package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class GeoLocation extends OpenWeatherObject {

    /**
     * Location, latitude
     */
    private Double lat;

    /**
     * Location, longitude
     */
    private Double lon;

    public GeoLocation(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}