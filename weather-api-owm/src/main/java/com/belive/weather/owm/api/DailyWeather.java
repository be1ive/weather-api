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

/**
 * Created by Nikolay on 15.02.2015.
 */
public class DailyWeather extends AbstractWeather {

    private MainObject mainObject;

    private WindObject windObject;

    private CloudsObject cloudsObject;

    private RainObject rainObject;

    private SnowObject snowObject;

    private TemperatureObject temperatureObject;

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

    /**
     * 	Temperature Information
     */
    public TemperatureObject getTemperatureObject() {
        return temperatureObject;
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class MainObject extends OpenWeatherMapObject {

        private final Double humidity;

        private final Double pressure;

        public MainObject(Double humidity, Double pressure) {
            this.humidity = humidity;
            this.pressure = pressure;
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

        @Override
        public String toString() {
            return "MainObject{" +
                    "humidity=" + humidity +
                    ", pressure=" + pressure +
                    '}';
        }
    }

    public static class TemperatureObject extends OpenWeatherMapObject {

        private final Double temperature;

        private final Double minTemperature;

        private final Double maxTemperature;

        private final Double eveningTemperature;

        private final Double nightTemperature;

        private final Double morningTemperature;

        public TemperatureObject(Double temperature, Double minTemperature, Double eveningTemperature, Double nightTemperature, Double morningTemperature, Double maxTemperature) {
            this.temperature = temperature;
            this.minTemperature = minTemperature;
            this.maxTemperature = maxTemperature;
            this.eveningTemperature = eveningTemperature;
            this.nightTemperature = nightTemperature;
            this.morningTemperature = morningTemperature;
        }

        /**
         * Day temperature, Kelvin (subtract 273.15 to convert to Celsius)
         */
        public Double getTemperature() {
            return temperature;
        }

        /**
         * 	Min daily temperature, Kelvin
         */
        public Double getMinTemperature() {
            return minTemperature;
        }

        /**
         * Max daily temperature, Kelvin
         */
        public Double getMaxTemperature() {
            return maxTemperature;
        }

        /**
         * Evening temperature, Kelvin
         */
        public Double getEveningTemperature() {
            return eveningTemperature;
        }

        /**
         * Night temperature, Kelvin
         */
        public Double getNightTemperature() {
            return nightTemperature;
        }

        /**
         * Morning temperature, Kelvin
         */
        public Double getMorningTemperature() {
            return morningTemperature;
        }

        @Override
        public String toString() {
            return "TemperatureObject{" +
                    "temperature=" + temperature +
                    ", minTemperature=" + minTemperature +
                    ", maxTemperature=" + maxTemperature +
                    ", eveningTemperature=" + eveningTemperature +
                    ", nightTemperature=" + nightTemperature +
                    ", morningTemperature=" + morningTemperature +
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
