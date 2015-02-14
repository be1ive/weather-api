package com.be1ive.weather.owm.api;

import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 14.02.2015.
 */
public interface OpenWeatherMapApi {

    static final String OWM_API_URL = "http://api.openweathermap.org/data/2.5";

    static final String OWM_AUTH_PARAM = "APPID";

    <T> T fetchObject(String objectName, Class<T> type, MultiValueMap<String, String> queryParameters);

    <T> List<T> fetchObjects(String objectName, Class<T> type, MultiValueMap<String, String> queryParameters);

}
