package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class MainObject extends OpenWeatherObject {

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
