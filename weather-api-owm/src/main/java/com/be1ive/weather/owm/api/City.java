package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class City extends OpenWeatherMapObject {

    private final String id;
    private final String name;
    private final String country;
    private final Location location;

    public City(String id, String name, String country, Location location) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.location = location;
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
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "CityObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", location=" + location +
                '}';
    }
}
