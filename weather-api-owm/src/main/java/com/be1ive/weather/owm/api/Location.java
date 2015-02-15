package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class Location extends OpenWeatherMapObject {

    private final Double latitude;

    private final Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Location, latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Location, longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "LocationObject{" +
                "lat=" + latitude +
                ", lon=" + longitude +
                '}';
    }
}