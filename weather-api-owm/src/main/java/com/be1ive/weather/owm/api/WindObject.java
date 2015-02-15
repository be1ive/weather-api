package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class WindObject extends OpenWeatherObject {

    private final Double speed;

    private final Double deg;

    private final Double gust;

    public WindObject(Double speed, Double deg, Double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    /**
     * Wind speed, mps
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Wind direction, degrees (meteorological)
     */
    public Double getDeg() {
        return deg;
    }

    /**
     * 	Wind gust, mps
     */
    public Double getGust() {
        return gust;
    }

    @Override
    public String toString() {
        return "WindObject{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
