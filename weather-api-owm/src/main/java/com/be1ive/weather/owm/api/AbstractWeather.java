package com.be1ive.weather.owm.api;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class AbstractWeather extends OpenWeatherMapObject {

    private final Date date;

    private final List<WeatherCondition> conditions;

    public AbstractWeather(Date date, List<WeatherCondition> conditions) {
        this.date = date;
        this.conditions = conditions;
    }

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
