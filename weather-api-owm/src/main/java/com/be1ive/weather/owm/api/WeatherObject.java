package com.be1ive.weather.owm.api;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class WeatherObject extends OpenWeatherObject {

    private final Date date;

    private final List<WeatherCondition> weatherConditions;

    private final SystemObject systemObject;

    private final MainObject mainObject;

    private final WindObject windObject;

    private final CloudsObject cloudsObject;

    private final RainObject rainObject;

    private final SnowObject snowObject;

    public WeatherObject(Date date, List<WeatherCondition> weatherConditions, SystemObject systemObject, MainObject mainObject, WindObject windObject, CloudsObject cloudsObject, RainObject rainObject, SnowObject snowObject) {
        this.date = date;
        this.weatherConditions = weatherConditions;
        this.systemObject = systemObject;
        this.mainObject = mainObject;
        this.windObject = windObject;
        this.cloudsObject = cloudsObject;
        this.rainObject = rainObject;
        this.snowObject = snowObject;
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
        return weatherConditions;
    }

    /**
     * 	System Information
     */
    public SystemObject getSystem() {
        return systemObject;
    }

    /**
     * 	Main Information
     */
    public MainObject getMain() {
        return mainObject;
    }

    /**
     * 	Wind Information
     */
    public WindObject getWind() {
        return windObject;
    }

    /**
     * 	Clouds Information
     */
    public CloudsObject getClouds() {
        return cloudsObject;
    }

    /**
     * 	Rain Information
     */
    public RainObject getRain() {
        return rainObject;
    }

    /**
     * 	Snow Information
     */
    public SnowObject getSnow() {
        return snowObject;
    }

    @Override
    public String toString() {
        return "WeatherObject{" +
                "date=" + date +
                ", conditions=" + weatherConditions +
                ", system=" + systemObject +
                ", main=" + mainObject +
                ", wind=" + windObject +
                ", clouds=" + cloudsObject +
                ", rain=" + rainObject +
                ", snow=" + snowObject +
                '}';
    }
}
