package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class CloudsObject extends OpenWeatherObject {

    private final Double all;

    public CloudsObject(Double all) {
        this.all = all;
    }

    /**
     * Cloudiness, %
     */
    public Double getAll() {
        return all;
    }

    @Override
    public String toString() {
        return "CloudsObject{" +
                "all=" + all +
                '}';
    }
}
