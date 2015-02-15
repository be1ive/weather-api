package com.be1ive.weather.owm.api;

/**
 * Defines operations for reading forecast weather.
 * @author
 */
public interface HourlyForecastOperations {

    /**
     * Retrieves weather forecast for 5 days with data every 3 hours, by city name
     * @param city City Name
     * @return the requested {@link HourlyForecast}
     */
    HourlyForecast forecastWeatherByCityName(String city);

    /**
     * Retrieves weather forecast for 5 days with data every 3 hours, by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link HourlyForecast}
     */
    HourlyForecast forecastWeatherByCityAndCountryCode(String city, String country);

    /**
     * Retrieves weather forecast for 5 days with data every 3 hours by city id
     * @param id City Id
     * @return the requested {@link HourlyForecast}
     */
    HourlyForecast forecastWeatherByCityId(String id);

}
