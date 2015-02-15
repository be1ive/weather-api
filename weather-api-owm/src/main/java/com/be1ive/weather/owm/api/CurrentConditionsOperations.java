package com.be1ive.weather.owm.api;


/**
 * Defines operations for reading current weather conditions.
 * @author
 */
public interface CurrentConditionsOperations {

    /**
     * Retrieves current weather conditions by city name
     * @param city City Name
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentConditionsByCityName(String city);

    /**
     * Retrieves current weather conditions by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentConditionsByCityAndCountryCode(String city, String country);

    /**
     * Retrieves current weather by city id
     * @param id City Id
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentConditionsByCityId(String id);

    /**
     * Retrieves current weather conditions for several city IDs
     * @param ids City Ids
     * @return the requested {@link ParametrisedList<CurrentConditions>}
     */
    ParametrisedList<CurrentConditions> currentConditionsByCityIds(String... ids);

    /**
     * Retrieves current weather conditions by geographic coordinates
     * @param lat Latitude
     * @param lon Longitude
     * @return the requested {@link CurrentConditions}
     */
    CurrentConditions currentConditionsByLatLon(double lat, double lon);

    /**
     * Retrieves current weather conditions for cities within a rectangle zone
     * @param topLeftLat Latitude of the top left point
     * @param topLeftLon Longitude of the top left point
     * @param botRightLat Latitude of the bottom right point
     * @param botRightLon Longitude of the bottom right point
     * @return the requested {@link ParametrisedList<CurrentConditions>}
     */
    ParametrisedList<CurrentConditions> currentConditionsInBox(double topLeftLat, double topLeftLon, double botRightLat, double botRightLon);

    /**
     * Retrieves current weather conditions for cities in cycle
     * @param centrLat Latitude of the center point
     * @param centrLon Longitude of the center point
     * @param cnt Expected number of points
     * @return the requested {@link ParametrisedList<CurrentConditions>}
     */
    ParametrisedList<CurrentConditions> currentConditionsInCircle(double centrLat, double centrLon, int cnt);

}
