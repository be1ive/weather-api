package com.be1ive.weather.owm.api;

import java.util.Date;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class CityObject extends OpenWeatherObject {

    private final String id;
    private final Date dt;
    private final String name;
    private final LocationObject coord;

    public CityObject(String id, Date dt, String name, LocationObject coord) {
        this.id = id;
        this.dt = dt;
        this.name = name;
        this.coord = coord;
    }

    /**
     * 	City identification
     */
    public String getId() {
        return id;
    }

    /**
     * 	Data receiving time, unix time, GMT
     */
    public Date getDt() {
        return dt;
    }

    /**
     * 	City name
     */
    public String getName() {
        return name;
    }

    /**
     * 	City Geo location
     */
    public LocationObject getCoord() {
        return coord;
    }

    @Override
    public String toString() {
        return "CityObject{" +
                "id='" + id + '\'' +
                ", dt=" + dt +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                '}';
    }
}
