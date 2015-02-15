package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.ParametrisedList;
import com.be1ive.weather.owm.api.CurrentWeather;
import com.be1ive.weather.owm.api.CurrentWeatherOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeatherOperationsTemplate implements CurrentWeatherOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public CurrentWeatherOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public CurrentWeather currentWeatherByCityName(String city) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city);
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByCityAndCountryCode(String city, String country) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city + "," + country);
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByCityId(String id) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("id", id);
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public ParametrisedList<CurrentWeather> currentWeatherByCityIds(String... ids) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        StringBuilder sb = new StringBuilder("");
        for (String id : ids) {
            sb.append(",").append(id);
        }
        sb.deleteCharAt(0);
        queryParams.add("id", sb.toString());

        return api.fetchObjects("group", CurrentWeather.class, queryParams);
    }

    @Override
    public CurrentWeather currentWeatherByLatLon(double lat, double lon) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(lat));
        queryParams.set("lon", Double.toString(lon));
        return api.fetchObject("weather", CurrentWeather.class, queryParams);
    }

    @Override
    public ParametrisedList<CurrentWeather> currentWeatherInBox(double topLeftLat, double topLeftLon, double botRightLat, double botRightLon) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("bbox", Double.toString(topLeftLat) + "," + Double.toString(topLeftLon) + "," + Double.toString(botRightLat) + "," + Double.toString(botRightLon));
        return api.fetchObjects("box/city", CurrentWeather.class, queryParams);
    }

    @Override
    public ParametrisedList<CurrentWeather> currentWeatherInCircle(double centrLat, double centrLon, int cnt) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(centrLat));
        queryParams.set("lon", Double.toString(centrLon));
        queryParams.set("count", cnt == 0 ? "1" : Integer.toString(cnt));
        return api.fetchObjects("find", CurrentWeather.class, queryParams);
    }
}
