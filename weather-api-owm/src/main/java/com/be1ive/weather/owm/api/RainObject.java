package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class RainObject extends OpenWeatherObject {

    private final Double volume;

    public RainObject(Double volume) {
        this.volume = volume;
    }

    /**
     * Precipitation volume for last 3 hours, mm
     */
    public Double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "RainObject{" +
                "volume=" + volume +
                '}';
    }
}
