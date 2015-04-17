# Forecast IO

Example:
        
        ForecastIO forecastIO = new ForecastIOTemplate(YOUR API KEY);
        ForecastOperations fo = forecastIO.forecastOperations();
        ForecastWeather forecastWeather = fo.forecastByLatLon(37, 55);
