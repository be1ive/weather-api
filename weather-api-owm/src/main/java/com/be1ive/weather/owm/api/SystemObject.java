package com.be1ive.weather.owm.api;

import java.util.Date;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class SystemObject extends OpenWeatherObject {

    private final String message;

    private final String country;

    private final Date sunrise;

    private final Date sunset;

    public SystemObject(String message, String country, Date sunrise, Date sunset) {
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    /**
     * System parameter, do not use it
     */
    public String getMessage() {
        return message;
    }

    /**
     * Country (GB, JP etc.)
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sunrise time, unix, UTC
     */
    public Date getSunrise() {
        return sunrise;
    }

    /**
     * Sunset time, unix, UTC
     */
    public Date getSunset() {
        return sunset;
    }

    @Override
    public String toString() {
        return "SystemObject{" +
                "message='" + message + '\'' +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
