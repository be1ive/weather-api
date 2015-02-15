package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class LocationObject extends OpenWeatherObject {

    private final Double lat;

    private final Double lon;

    public LocationObject(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Location, latitude
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Location, longitude
     */
    public Double getLon() {
        return lon;
    }

    public static class Builder {
        private Double lat;
        private Double lon;

        public Builder() {
        }

        public Builder(Double lat, Double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public Builder latitude(Double lat) {
            this.lat = lat;
            return this;
        }

        public Builder longitude(Double lon) {
            this.lon = lon;
            return this;
        }

        public LocationObject build() {
            LocationObject object = new LocationObject(lat, lon);
            return object;
        }
    }

    @Override
    public String toString() {
        return "LocationObject{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}