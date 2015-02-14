package com.be1ive.weather.owm.api;

import java.util.Date;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class SystemInformation extends OpenWeatherObject {

    /**
     * System parameter, do not use it
     */
    private String message;

    /**
     * Country (GB, JP etc.)
     */
    private String country;

    /**
     * Sunrise time, unix, UTC
     */
    private Date sunrise;

    /**
     * Sunset time, unix, UTC
     */
    private Date sunset;
}
