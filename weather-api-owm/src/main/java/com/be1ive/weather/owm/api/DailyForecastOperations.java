package com.be1ive.weather.owm.api;

/**
 * Defines operations for reading daily weather forecast up to 16 days
 * @author
 */
public interface DailyForecastOperations {

    /**
     * Retrieves weather forecast by city name
     * @param city City Name
     * @return the requested {@link HourlyForecast}
     */
    DailyForecast dailyForecastByCityName(String city);

    /**
     * Retrieves weather forecast by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link HourlyForecast}
     */
    DailyForecast dailyForecastByCityAndCountryCode(String city, String country);

    /**
     * Retrieves weather forecast by city id
     * @param id City Id
     * @return the requested {@link HourlyForecast}
     */
    DailyForecast dailyForecastByCityId(String id);

    /**
     * Retrieves weather forecast by geographic coordinates
     * @param lat Latitude
     * @param lon Longitude
     * @return the requested {@link HourlyForecast}
     */
    DailyForecast dailyForecastByLatLon(double lat, double lon);

}
