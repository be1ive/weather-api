package com.be1ive.weather.owm.api;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class CurrentWeather extends AbstractWeather {

    private final SystemObject systemObject;

    private final MainObject mainObject;

    private final WindObject windObject;

    private final CloudsObject cloudsObject;

    private final RainObject rainObject;

    private final SnowObject snowObject;

    public CurrentWeather(Date date, List<WeatherCondition> conditions, SystemObject systemObject, MainObject mainObject, WindObject windObject, CloudsObject cloudsObject, RainObject rainObject, SnowObject snowObject) {
        super(date, conditions);
        this.systemObject = systemObject;
        this.mainObject = mainObject;
        this.windObject = windObject;
        this.cloudsObject = cloudsObject;
        this.rainObject = rainObject;
        this.snowObject = snowObject;
    }

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

        public MainObject(Double temperature, Double humidity, Double minTemperature, Double maxTemperature, Double pressure, Double seaLevel, Double groundLevel) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.minTemperature = minTemperature;
            this.maxTemperature = maxTemperature;
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
         * Humidity, %
         */
        public Double getHumidity() {
            return humidity;
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
                    ", humidity=" + humidity +
                    ", minTemperature=" + minTemperature +
                    ", maxTemperature=" + maxTemperature +
                    ", pressure=" + pressure +
                    ", seaLevel=" + seaLevel +
                    ", groundLevel=" + groundLevel +
                    '}';
        }
    }

    /**
     * Created by Nikolay on 14.02.2015.
     */
    public static class CloudsObject extends OpenWeatherMapObject {

        private final Double all;

        public CloudsObject(Double all) {
            this.all = all;
        }

        /**
         * Cloudiness, %
         */
        public Double getAll() {
            return all;
        }

        @Override
        public String toString() {
            return "CloudsObject{" +
                    "all=" + all +
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
}
