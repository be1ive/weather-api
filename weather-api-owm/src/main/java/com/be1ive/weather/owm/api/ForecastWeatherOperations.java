package com.be1ive.weather.owm.api;

/**
 * Defines operations for reading forecast weather.
 * @author
 */
public interface ForecastWeatherOperations {

    /**
     * Retrieves forecast weather by city name
     * @param city City Name
     * @return the requested {@link ForecastWeather}
     */
    ForecastWeather forecastWeatherByCityName(String city);

    /**
     * Retrieves forecast weather by city name and country code
     * @param city City Name
     * @param country Country Code
     * @return the requested {@link ForecastWeather}
     */
    ForecastWeather forecastWeatherByCityAndCountryCode(String city, String country);

    /**
     * Retrieves forecast weather by city id
     * @param id City Id
     * @return the requested {@link ForecastWeather}
     */
    ForecastWeather forecastWeatherByCityId(String id);

}
