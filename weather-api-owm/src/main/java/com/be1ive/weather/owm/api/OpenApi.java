package com.be1ive.weather.owm.api;

import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 14.02.2015.
 */
public interface OpenApi {

    static final String OPEN_API_URL = "https://api.openweathermap.org/data/2.5/";

    <T> List<T> fetchObjects(String objectName, Class<T> type, Map<String, String> queryParameters);

}
