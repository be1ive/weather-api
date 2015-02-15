package com.be1ive.weather.owm.api;


/**
 * Defines operations for reading current weather.
 * @author
 */
public interface CurrentWeatherOperations {

    /**
     * Retrieves current weather by city name
     * @param city City Name
     * @return the requested {@link CurrentWeather}
     */
    CurrentWeather currentWeatherByCityName(String city);

    /**
     * Retrieves current weather by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link CurrentWeather}
     */
    CurrentWeather currentWeatherByCityAndCountryCode(String city, String country);

    /**
     * Retrieves current weather by city id
     * @param id City Id
     * @return the requested {@link CurrentWeather}
     */
    CurrentWeather currentWeatherByCityId(String id);

    /**
     * Retrieves current weather for several city IDs
     * @param ids City Ids
     * @return the requested {@link ParametrisedList<CurrentWeather>}
     */
    ParametrisedList<CurrentWeather> currentWeatherByCityIds(String... ids);

    /**
     * Retrieves current weather by geographic coordinates
     * @param lat Latitude
     * @param lon Longitude
     * @return the requested {@link CurrentWeather}
     */
    CurrentWeather currentWeatherByLatLon(double lat, double lon);

    /**
     * Retrieves current weather for cities within a rectangle zone
     * @param topLeftLat Latitude of the top left point
     * @param topLeftLon Longitude of the top left point
     * @param botRightLat Latitude of the bottom right point
     * @param botRightLon Longitude of the bottom right point
     * @return the requested {@link ParametrisedList<CurrentWeather>}
     */
    ParametrisedList<CurrentWeather> currentWeatherInBox(double topLeftLat, double topLeftLon, double botRightLat, double botRightLon);

    /**
     * Retrieves current weather for cities in cycle
     * @param centrLat Latitude of the center point
     * @param centrLon Longitude of the center point
     * @param cnt Expected number of points
     * @return the requested {@link ParametrisedList<CurrentWeather>}
     */
    ParametrisedList<CurrentWeather> currentWeatherInCircle(double centrLat, double centrLon, int cnt);

}
