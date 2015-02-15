package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class MainObject extends OpenWeatherObject {

    private final Double temp;

    private final Double humidity;

    private final Double tempMin;

    private final Double tempMax;

    private final Double pressure;

    private final Double seaLevel;

    private final Double grndLevel;

    public MainObject(Double temp, Double humidity, Double tempMin, Double tempMax, Double pressure, Double seaLevel, Double grndLevel) {
        this.temp = temp;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
    }

    /**
     * Temperature, Kelvin (subtract 273.15 to convert to Celsius)
     */
    public Double getTemp() {
        return temp;
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
    public Double getTempMin() {
        return tempMin;
    }

    /**
     * Maximum temperature at the moment. This is deviation from current temp that is possible for large cities and megalopolises geographically expanded (use these parameter optionally)
     */
    public Double getTempMax() {
        return tempMax;
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
    public Double getGrndLevel() {
        return grndLevel;
    }

    @Override
    public String toString() {
        return "MainObject{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", pressure=" + pressure +
                ", seaLevel=" + seaLevel +
                ", grndLevel=" + grndLevel +
                '}';
    }
}
