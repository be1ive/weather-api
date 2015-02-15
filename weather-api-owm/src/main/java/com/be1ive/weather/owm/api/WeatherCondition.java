package com.be1ive.weather.owm.api;

/**
 * Created by Nikolay on 14.02.2015.
 */
public enum WeatherCondition {

    THUNDERSTORM_WITH_LIGHT_RAIN (Group.THUNDERSTORM, "200","thunderstorm with light rain", "11d.png"),
    THUNDERSTORM_WITH_RAIN (Group.THUNDERSTORM, "201", "thunderstorm with rain", "11d.png"),
    THUNDERSTORM_WITH_HEAVY_RAIN (Group.THUNDERSTORM, "202", "thunderstorm with heavy rain", "11d.png"),
    THUNDERSTORM_LIGHT (Group.THUNDERSTORM, "210", "light thunderstorm", "11d.png"),
    THUNDERSTORM (Group.THUNDERSTORM, "211", "thunderstorm", "11d.png"),
    THUNDERSTORM_HEAVY (Group.THUNDERSTORM, "212", "heavy thunderstorm", "11d.png"),
    THUNDERSTORM_RAGGED (Group.THUNDERSTORM, "221", "ragged thunderstorm", "11d.png"),
    THUNDERSTORM_WITH_LIGHT_DRIZZLE (Group.THUNDERSTORM, "230", "thunderstorm with light drizzle", "11d.png"),
    THUNDERSTORM_WITH_DRIZZLE (Group.THUNDERSTORM, "231", "thunderstorm with drizzle", "11d.png"),
    THUNDERSTORM_WITH_HEAVY_DRIZZLE (Group.THUNDERSTORM, "232", "thunderstorm with heavy drizzle", "11d.png"),

    DRIZZLE_LIGHT_INTENSITY (Group.DRIZZLE,"300", "light intensity drizzle", "09d.png"),
    DRIZZLE (Group.DRIZZLE,"301", "drizzle", "09d.png"),
    DRIZZLE_HEAVY_INTENSITY (Group.DRIZZLE,"302", "heavy intensity drizzle", "09d.png"),
    DRIZZLE_RAIN_LIGHT_INTENSITY (Group.DRIZZLE,"310", "light intensity drizzle rain", "09d.png"),
    DRIZZLE_RAIN (Group.DRIZZLE,"311", "drizzle rain", "09d.png"),
    DRIZZLE_RAIN_HEAVY_INTENSITY (Group.DRIZZLE,"312", "heavy intensity drizzle rain", "09d.png"),
    DRIZZLE_AND_SHOWER_RAIN (Group.DRIZZLE,"313", "shower rain and drizzle", "09d.png"),
    DRIZZLE_AND_HEAVY_SHOWER_RAIN (Group.DRIZZLE,"314", "heavy shower rain and drizzle", "09d.png"),
    DRIZZLE_SHOWER (Group.DRIZZLE,"321", "shower drizzle", "09d.png"),

    RAIN_LIGHT (Group.RAIN, "500", "light rain", "10d.png"),
    RAIN_MODERATE (Group.RAIN, "501", "moderate rain", "10d.png"),
    RAIN_HEAVY_INTENSITY (Group.RAIN, "502", "heavy intensity rain", "10d.png"),
    RAIN_VERY_HEAVY (Group.RAIN, "503", "very heavy rain", "10d.png"),
    RAIN_EXTREME (Group.RAIN, "504", "extreme rain", "10d.png"),
    RAIN_FREEZING (Group.RAIN, "511", "freezing rain", "13d.png"),
    RAIN_SHOWER_LIGHT_INTENSITY  (Group.RAIN, "520", "light intensity shower rain ", "09d.png"),
    RAIN_SHOWER (Group.RAIN, "521", "shower rain", "09d.png"),
    RAIN_SHOWER_HEAVY_INTENSITY (Group.RAIN, "522", "heavy intensity shower rain", "09d.png"),
    RAIN_SHOWER_RAGGED (Group.RAIN, "531", "ragged shower rain", "09d.png"),

    SNOW_LIGHT (Group.SNOW, "600", "light snow", "13d.png"),
    SNOW (Group.SNOW, "601", "snow", "13d.png"),
    SNOW_HEAVY (Group.SNOW, "602", "heavy snow", "13d.png"),
    SNOW_SLEET (Group.SNOW, "611", "sleet", "13d.png"),
    SNOW_SHOWER_SLEET (Group.SNOW, "612", "shower sleet", "13d.png"),
    SNOW_AND_LIGHT_RAIN (Group.SNOW, "615", "light rain and snow", "13d.png"),
    SNOW_AND_RAIN (Group.SNOW, "616", "rain and snow", "13d.png"),
    SNOW_LIGHT_SHOWER (Group.SNOW, "620", "light shower snow", "13d.png"),
    SNOW_SHOWER (Group.SNOW, "621", "shower snow", "13d.png"),
    SNOW_HEAVY_SHOWER (Group.SNOW, "622", "heavy shower snow", "13d.png"),

    ATMOSPHERE_MIST (Group.ATMOSPHERE,"701", "mist", "50d.png"),
    ATMOSPHERE_SMOKE (Group.ATMOSPHERE,"711", "smoke", "50d.png"),
    ATMOSPHERE_HAZE (Group.ATMOSPHERE,"721", "haze", "50d.png"),
    ATMOSPHERE_SAND_AND_DUST_WHIRLS (Group.ATMOSPHERE,"731", "sand, dust whirls", "50d.png"),
    ATMOSPHERE_FOG (Group.ATMOSPHERE,"741", "fog", "50d.png"),
    ATMOSPHERE_SAND (Group.ATMOSPHERE,"751", "sand", "50d.png"),
    ATMOSPHERE_DUST (Group.ATMOSPHERE,"761", "dust", "50d.png"),
    ATMOSPHERE_VOLCANIC_ASH (Group.ATMOSPHERE,"762", "volcanic ash", "50d.png"),
    ATMOSPHERE_SQUALLS (Group.ATMOSPHERE,"771", "squalls", "50d.png"),
    ATMOSPHERE_TORNADO (Group.ATMOSPHERE,"781", "tornado", "50d.png"),

    CLOUDS_CLEAR (Group.CLOUDS,"800", "clear sky", "01d.png", "01n.png"),
    CLOUDS_FEW (Group.CLOUDS,"801", "few clouds", "02d.png", "02n.png"),
    CLOUDS_SCATTERED (Group.CLOUDS,"802", "scattered clouds", "03d.png", "03d.png"),
    CLOUDS_BROKEN (Group.CLOUDS,"803", "broken clouds", "04d.png", "03d.png"),
    CLOUDS_OVERCAST (Group.CLOUDS,"804", "overcast clouds", "04d.png", "04d.png"),

    EXTREME_TORNADO (Group.EXTREME, "900", "tornado"),
    EXTREME_TROPICAL_STORM (Group.EXTREME, "901", "tropical storm"),
    EXTREME_HURRICANE (Group.EXTREME, "902", "hurricane"),
    EXTREME_COLD (Group.EXTREME, "903", "cold"),
    EXTREME_HOT (Group.EXTREME, "904", "hot"),
    EXTREME_WINDY (Group.EXTREME, "905", "windy"),
    EXTREME_HAIL (Group.EXTREME, "906", "hail"),

    ADDITIONAL_CALM  (Group.ADDITIONAL, "951", "calm"),
    ADDITIONAL_LIGHT_BREEZE (Group.ADDITIONAL, "952", "light breeze"),
    ADDITIONAL_GENTLE_BREEZE (Group.ADDITIONAL, "953", "gentle breeze"),
    ADDITIONAL_MODERATE_BREEZE (Group.ADDITIONAL, "954", "moderate breeze"),
    ADDITIONAL_FRESH_BREEZE (Group.ADDITIONAL, "955", "fresh breeze"),
    ADDITIONAL_STRONG_BREEZE (Group.ADDITIONAL, "956", "strong breeze"),
    ADDITIONAL_HIGH_WIND_NEAR_GALE  (Group.ADDITIONAL, "957", "high wind, near gale"),
    ADDITIONAL_GALE (Group.ADDITIONAL, "958", "gale"),
    ADDITIONAL_SEVERE_GALE (Group.ADDITIONAL, "959", "severe gale"),
    ADDITIONAL_STORM (Group.ADDITIONAL, "960", "storm"),
    ADDITIONAL_VIOLENT_STORM (Group.ADDITIONAL, "961", "violent storm"),
    ADDITIONAL_HURRICANE (Group.ADDITIONAL, "962", "hurricane"),

    OTHER(Group.OTHER, null, null);

    WeatherCondition(Group main, String id, String description, String... icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    /**
     * Weather condition id
     */
    public final String id;

    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.)
     */
    public final Group main;

    /**
     * Weather condition within the group
     */
    public final String description;

    /**
     * Weather icon id
     */
    public final String[] icon;

    public static WeatherCondition forId(String id) {
        for (WeatherCondition weatherCondition : values()) {
            if (id.equals(weatherCondition.id)) {
                return weatherCondition;
            }
        }
        return OTHER;
    }

    public enum Group {
        THUNDERSTORM, DRIZZLE, RAIN, SNOW, ATMOSPHERE, CLOUDS, EXTREME, ADDITIONAL, OTHER
    }
}
