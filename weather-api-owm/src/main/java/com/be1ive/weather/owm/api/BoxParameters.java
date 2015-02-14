package com.be1ive.weather.owm.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class BoxParameters implements Serializable {

    private double topLatitude;

    private double topLongitude;

    private double botLatitude;

    private double botLongitude;

    private boolean cluster;

    private int count;

    public BoxParameters topLatitude(double topLatitude) {
        this.topLatitude = topLatitude;
        return this;
    }

    public BoxParameters topLongitude(double topLongitude) {
        this.topLongitude = topLongitude;
        return this;
    }

    public BoxParameters botLatitude(double botLatitude) {
        this.botLatitude = botLatitude;
        return this;
    }

    public BoxParameters botLongitude(double botLongitude) {
        this.botLongitude = botLongitude;
        return this;
    }

    public BoxParameters cluster(boolean cluster) {
        this.cluster = cluster;
        return this;
    }

    public BoxParameters count(int count) {
        this.count = count;
        return this;
    }

    public MultiValueMap<String, String> toParameters() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("bbox", topLatitude + "," + topLongitude + "," + botLatitude + "," + botLongitude);
        params.set("cluster", cluster ? "yes" : "");
        params.set("count", count == 0 ? "1" : Integer.toString(count));
        return params;
    }

}
