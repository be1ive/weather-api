package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class CityObject extends OpenWeatherObject {

    private final String id;
    private final String name;
    private final String country;
    private final LocationObject locationObject;

    public CityObject(String id, String name, String country, LocationObject locationObject) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.locationObject = locationObject;
    }

    /**
     * 	City identification
     */
    public String getId() {
        return id;
    }

    /**
     * 	City name
     */
    public String getName() {
        return name;
    }

    /**
     * 	City country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 	City Geo location
     */
    public LocationObject getLocation() {
        return locationObject;
    }

    @Override
    public String toString() {
        return "CityObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", location=" + locationObject +
                '}';
    }
}
