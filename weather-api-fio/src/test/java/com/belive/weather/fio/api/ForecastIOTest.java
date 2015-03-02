package com.belive.weather.fio.api;


import com.belive.weather.fio.api.impl.ForecastIOTemplate;

import java.util.Date;

/**
 * Created by Lena on 27-Feb-15.
 */
public class ForecastIOTest {

    public static void main(String... args) {
        ForecastIO forecastIO = new ForecastIOTemplate("f02e277aff8209f977867a17367371d5");
        ForecastOperations fo = forecastIO.forecastOperations();
        fo.forecastByLatLon(37, 55);
        fo.forecastByLatLonAndDate(37, 55, new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));

    }

}
