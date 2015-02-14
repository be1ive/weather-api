package com.be1ive.weather.owm.api;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeather extends OpenWeatherObject {

    /**
     * 	City identification
     */
    private String id;

    /**
     * 	Data receiving time, unix time, GMT
     */
    private Date dt;

    /**
     * 	City name
     */
    private String name;

    /**
     * 	City Geo location
     */
    private GeoLocation coord;

    /**
     * 	System Geo location
     */
    private SystemInformation sys;

    /**
     * 	Main Information
     */
    private MainInformation main;

    /**
     * 	Wind Information
     */
    private WindInformation wind;

    /**
     * 	Clouds Information
     */
    private CloudsInformation clouds;

    /**
     * 	Weather Information
     */
    private List<WeatherInformation> weather;

    /**
     * 	Rain Information
     */
    private RainInformation rain;

    /**
     * 	Snow Information
     */
    private SnowInformation snow;

}
