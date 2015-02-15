package com.be1ive.weather.owm.api;


/**
 * Defines operations for reading current weather.
 * @author
 */
public interface CurrentConditionsOperations {

    /**
     * Retrieves current weather by city name
     * @param city City Name
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentWeatherByCityName(String city);

    /**
     * Retrieves current weather by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentWeatherByCityAndCountryCode(String city, String country);

    /**
     * Retrieves current weather by city id
     * @param id City Id
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentWeatherByCityId(String id);

    /**
     * Retrieves current weather for several city IDs
     * @param ids City Ids
     * @return the requested {@link ParametrisedList< CurrentConditions >}
     */
    ParametrisedList<CurrentConditions> currentWeatherByCityIds(String... ids);

    /**
     * Retrieves current weather by geographic coordinates
     * @param lat Latitude
     * @param lon Longitude
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentWeatherByLatLon(double lat, double lon);

    /**
     * Retrieves current weather for cities within a rectangle zone
     * @param topLeftLat Latitude of the top left point
     * @param topLeftLon Longitude of the top left point
     * @param botRightLat Latitude of the bottom right point
     * @param botRightLon Longitude of the bottom right point
     * @return the requested {@link ParametrisedList< CurrentConditions >}
     */
    ParametrisedList<CurrentConditions> currentWeatherInBox(double topLeftLat, double topLeftLon, double botRightLat, double botRightLon);

    /**
     * Retrieves current weather for cities in cycle
     * @param centrLat Latitude of the center point
     * @param centrLon Longitude of the center point
     * @param cnt Expected number of points
     * @return the requested {@link ParametrisedList< CurrentConditions >}
     */
    ParametrisedList<CurrentConditions> currentWeatherInCircle(double centrLat, double centrLon, int cnt);

}
