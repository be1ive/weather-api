/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.belive.weather.owm.api;

import java.util.Date;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class CurrentWeather extends AbstractWeather {

    private SystemObject systemObject;

    private MainObject mainObject;

    private WindObject windObject;

    private CloudsObject cloudsObject;

    private RainObject rainObject;

    private SnowObject snowObject;

    /**
     * 	System Information
     */
    public SystemObject getSystem() {
        return systemObject;
    }

    /**
     * 	Main Information
     */
    public MainObject getMain() {
        return mainObject;
    }

    /**
     * 	Wind Information
     */
    public WindObject getWind() {
        return windObject;
    }

    /**
     * 	Clouds Information
     */
    public CloudsObject getClouds() {
        return cloudsObject;
    }

    /**
     * 	Rain Information
     */
    public RainObject getRain() {
        return rainObject;
    }

    /**
     * 	Snow Information
     */
    public SnowObject getSnow() {
        return snowObject;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "systemObject=" + systemObject +
                ", mainObject=" + mainObject +
                '}';
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class MainObject extends OpenWeatherMapObject {

        private final Double temperature;

        private final Double humidity;

        private final Double minTemperature;

        private final Double maxTemperature;

        private final Double pressure;

        private final Double seaLevel;

        private final Double groundLevel;

        public MainObject(Double temperature, Double minTemperature, Double maxTemperature, Double humidity, Double pressure, Double seaLevel, Double groundLevel) {
            this.temperature = temperature;
            this.minTemperature = minTemperature;
            this.maxTemperature = maxTemperature;
            this.humidity = humidity;
            this.pressure = pressure;
            this.seaLevel = seaLevel;
            this.groundLevel = groundLevel;
        }

        /**
         * Temperature, Kelvin (subtract 273.15 to convert to Celsius)
         */
        public Double getTemperature() {
            return temperature;
        }

        /**
         * 	Minimum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally)
         */
        public Double getMinTemperature() {
            return minTemperature;
        }

        /**
         * Maximum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally)
         */
        public Double getMaxTemperature() {
            return maxTemperature;
        }

        /**
         * Humidity, %
         */
        public Double getHumidity() {
            return humidity;
        }

        /**
         * Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
         */
        public Double getPressure() {
            return pressure;
        }

        /**
         * Atmospheric pressure on the sea level, hPa
         */
        public Double getSeaLevel() {
            return seaLevel;
        }

        /**
         * Atmospheric pressure on the ground level, hPa
         */
        public Double getGroundLevel() {
            return groundLevel;
        }

        @Override
        public String toString() {
            return "MainObject{" +
                    "temperature=" + temperature +
                    ", minTemperature=" + minTemperature +
                    ", maxTemperature=" + maxTemperature +
                    ", humidity=" + humidity +
                    ", pressure=" + pressure +
                    ", seaLevel=" + seaLevel +
                    ", groundLevel=" + groundLevel +
                    '}';
        }
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class SystemObject extends OpenWeatherMapObject {

        private final String message;

        private final String country;

        private final Date sunrise;

        private final Date sunset;

        public SystemObject(String message, String country, Date sunrise, Date sunset) {
            this.message = message;
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

        /**
         * System parameter, do not use it
         */
        public String getMessage() {
            return message;
        }

        /**
         * Country (GB, JP etc.)
         */
        public String getCountry() {
            return country;
        }

        /**
         * Sunrise time, unix, UTC
         */
        public Date getSunrise() {
            return sunrise;
        }

        /**
         * Sunset time, unix, UTC
         */
        public Date getSunset() {
            return sunset;
        }

        @Override
        public String toString() {
            return "SystemObject{" +
                    "message='" + message + '\'' +
                    ", country='" + country + '\'' +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    '}';
        }
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class WindObject extends OpenWeatherMapObject {

        private final Double speed;

        private final Double degree;

        private final Double gust;

        public WindObject(Double speed, Double degree, Double gust) {
            this.speed = speed;
            this.degree = degree;
            this.gust = gust;
        }

        /**
         * Wind speed, mps
         */
        public Double getSpeed() {
            return speed;
        }

        /**
         * Wind direction, degrees (meteorological)
         */
        public Double getDegree() {
            return degree;
        }

        /**
         * 	Wind gust, mps
         */
        public Double getGust() {
            return gust;
        }

        @Override
        public String toString() {
            return "WindObject{" +
                    "speed=" + speed +
                    ", degree=" + degree +
                    ", gust=" + gust +
                    '}';
        }
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class CloudsObject extends OpenWeatherMapObject {

        private final Double cloudiness;

        public CloudsObject(Double cloudiness) {
            this.cloudiness = cloudiness;
        }

        /**
         * Cloudiness, %
         */
        public Double getCloudiness() {
            return cloudiness;
        }

        @Override
        public String toString() {
            return "CloudsObject{" +
                    "cloudiness=" + cloudiness +
                    '}';
        }
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class SnowObject extends OpenWeatherMapObject {

        private final Double volume;

        public SnowObject(Double volume) {
            this.volume = volume;
        }

        /**
         * Snow volume for last 3 hours, mm
         */
        public Double getVolume() {
            return volume;
        }

        @Override
        public String toString() {
            return "SnowObject{" +
                    "volume=" + volume +
                    '}';
        }
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class RainObject extends OpenWeatherMapObject {

        private final Double volume;

        public RainObject(Double volume) {
            this.volume = volume;
        }

        /**
         * Precipitation volume for last 3 hours, mm
         */
        public Double getVolume() {
            return volume;
        }

        @Override
        public String toString() {
            return "RainObject{" +
                    "volume=" + volume +
                    '}';
        }
    }
}
