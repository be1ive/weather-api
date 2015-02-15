package com.be1ive.weather.owm.api.impl;

import com.be1ive.weather.owm.api.ParametrisedList;
import com.be1ive.weather.owm.api.CurrentConditions;
import com.be1ive.weather.owm.api.CurrentConditionsOperations;
import com.be1ive.weather.owm.api.OpenWeatherMapApi;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentConditionsOperationsTemplate implements CurrentConditionsOperations {

    protected final OpenWeatherMapApi api;

    protected final RestTemplate restTemplate;

    public CurrentConditionsOperationsTemplate(OpenWeatherMapApi api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public CurrentConditions currentConditionsByCityName(String city) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("q", city);
        return api.fetchObject("weather", CurrentConditions.class, queryParams);
    }

    @Override
    public CurrentConditions currentConditionsByCityAndCountryCode(String city, String country) {
        return currentConditionsByCityName(city + "," + country);
    }

    @Override
    public CurrentConditions currentConditionsByCityId(String id) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("id", id);
        return api.fetchObject("weather", CurrentConditions.class, queryParams);
    }

    @Override
    public ParametrisedList<CurrentConditions> currentConditionsByCityIds(String... ids) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        StringBuilder sb = new StringBuilder("");
        for (String id : ids) {
            sb.append(",").append(id);
        }
        sb.deleteCharAt(0);
        queryParams.add("id", sb.toString());

        return api.fetchObjects("group", CurrentConditions.class, queryParams);
    }

    @Override
    public CurrentConditions currentConditionsByLatLon(double lat, double lon) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(lat));
        queryParams.set("lon", Double.toString(lon));
        return api.fetchObject("weather", CurrentConditions.class, queryParams);
    }

    @Override
    public ParametrisedList<CurrentConditions> currentConditionsInBox(double topLeftLat, double topLeftLon, double botRightLat, double botRightLon) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("bbox", Double.toString(topLeftLat) + "," + Double.toString(topLeftLon) + "," + Double.toString(botRightLat) + "," + Double.toString(botRightLon));
        return api.fetchObjects("box/city", CurrentConditions.class, queryParams);
    }

    @Override
    public ParametrisedList<CurrentConditions> currentConditionsInCircle(double centrLat, double centrLon, int cnt) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.set("lat", Double.toString(centrLat));
        queryParams.set("lon", Double.toString(centrLon));
        queryParams.set("count", cnt == 0 ? "1" : Integer.toString(cnt));
        return api.fetchObjects("find", CurrentConditions.class, queryParams);
    }
}
