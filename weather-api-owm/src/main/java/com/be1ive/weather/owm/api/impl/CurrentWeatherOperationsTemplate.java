package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.OpenApi;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeatherOperationsTemplate implements CurrentWeatherOperations {

    private final OpenApi openApi;

    private final RestTemplate restTemplate;

    public CurrentWeatherOperationsTemplate(OpenApi openApi, RestTemplate restTemplate) {
        this.openApi = openApi;
        this.restTemplate = restTemplate;
    }
}
