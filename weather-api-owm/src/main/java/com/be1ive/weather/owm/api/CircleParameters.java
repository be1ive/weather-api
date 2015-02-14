package com.be1ive.weather.owm.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class CircleParameters implements Serializable {

    private double latitude;

    private double longitude;

    private boolean cluster;

    private int count;

    public CircleParameters latitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public CircleParameters longitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public CircleParameters cluster(boolean cluster) {
        this.cluster = cluster;
        return this;
    }

    public CircleParameters count(int count) {
        this.count = count;
        return this;
    }

    public MultiValueMap<String, String> toParameters() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("lat", Double.toString(latitude));
        params.set("lon", Double.toString(longitude));
        params.set("cluster", cluster ? "yes" : "");
        params.set("count", count == 0 ? "1" : Integer.toString(count));
        return params;
    }

}
