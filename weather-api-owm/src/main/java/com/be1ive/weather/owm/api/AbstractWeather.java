package com.be1ive.weather.owm.api;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class AbstractWeather extends OpenWeatherMapObject {

    private Date date;

    private List<WeatherCondition> conditions;

    /**
     * 	Data receiving time, unix time, GMT
     */
    public Date getDate() {
        return date;
    }

    /**
     * 	Weather Information
     */
    public List<WeatherCondition> getConditions() {
        return conditions;
    }

}
