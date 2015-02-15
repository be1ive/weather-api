package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class WindObject extends OpenWeatherObject {

    private final Double speed;

    private final Double degree;

    private final Double gust;

    public WindObject(Double speed, Double degree, Double gust) {
        this.speed = speed;
        this.degree = degree;
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
    public Double getDegree() {
        return degree;
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
                ", degree=" + degree +
                ", gust=" + gust +
                '}';
    }
}
