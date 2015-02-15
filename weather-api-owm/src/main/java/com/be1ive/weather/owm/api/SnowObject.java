package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class SnowObject extends OpenWeatherObject {

    private final Double volume;

    public SnowObject(Double volume) {
        this.volume = volume;
    }

    /**
     * Snow volume for last 3 hours, mm
     */
    public Double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "SnowObject{" +
                "volume=" + volume +
                '}';
    }
}
